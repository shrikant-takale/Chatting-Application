/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Shrikant
 */
public class Client
{
    private JFrame clientframe;
    private JTextArea ta;
    private JScrollPane scrollpane;
    private JTextField tf;
    
    private Socket socket;
    
    String ipaddress;
    
    Client()
    {
        ipaddress=JOptionPane.showInputDialog("Enter IP Address");
        
        if(ipaddress != null)
        {
            if(!ipaddress.equals(""))
            {
                connectToServer();
                
                clientframe=new JFrame("Client");
                clientframe.setSize(500,500);
                clientframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ta=new JTextArea();
                ta.setEditable(false);
                scrollpane=new JScrollPane(ta);
                clientframe.add(scrollpane);

                tf=new JTextField();
                clientframe.add(tf, BorderLayout.SOUTH);

                clientframe.setVisible(true);
            }
        }
    }
    
    void connectToServer()
    {
        try
        {
            socket=new Socket(ipaddress, 1111);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
