/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverr;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.ServerSocket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Shrikant
 */
public class Server
{
    private JFrame serverframe;
    private JTextArea ta;
    private JScrollPane scrollpane;
    private JTextField tf;
    
    private ServerSocket serversocket;
    
    private InetAddress inet_address;
    
    Server()
    {
        serverframe=new JFrame("Server");
        serverframe.setSize(500,500);
        serverframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ta=new JTextArea();
        ta.setEditable(false);
        scrollpane=new JScrollPane(ta);
        serverframe.add(scrollpane);
        
        tf=new JTextField();
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage(tf.getText());
            }
        });
        serverframe.add(tf, BorderLayout.SOUTH);
        
        serverframe.setVisible(true);
    }
    
    public void waitingForClient()
    {
        try
        {
            String ipaddress=getIpAddress();
            
            serversocket=new ServerSocket(1111);
            ta.setText("To connect with server, please provide IP Address : "+ipaddress);
            serversocket.accept();
            ta.setText("Client Connected\n");
            ta.append("----------------------------------------------------\n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getIpAddress()
    {
        String ip_address="";
        try
        {
            inet_address=InetAddress.getLocalHost();
            ip_address=inet_address.getHostAddress();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ip_address;
    }
    public void showMessage(String message)
    {
        ta.append(message+"\n");
        tf.setText("");
    }
}
