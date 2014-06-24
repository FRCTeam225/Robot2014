/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.ServerSocketConnection;
import javax.microedition.io.SocketConnection;

/**
 *
 * @author Andrew
 */
public class ConstantServer implements Runnable {
    
    public static ConstantServer create(int port)
    {
        ConstantServer s = new ConstantServer(port);
        new Thread(s).start();
        return s;
    }
    
    ServerSocketConnection sock;
    
    public ConstantServer(int port)
    {
        try {
            sock = (ServerSocketConnection) Connector.open("serversocket://:" + port);
        } catch (IOException ex) {
            System.out.println("Error creating or binding socket");
            ex.printStackTrace();
        }
    }

    public void run() {
        while ( true )
        {
            try {
                SocketConnection clientSock  = (SocketConnection) sock.acceptAndOpen();
                new Thread(new Client(clientSock)).start();
                Thread.sleep(100);
            } catch (Exception ex) {
                System.out.println("Error accepting client connection");
                ex.printStackTrace();
            }
        }
    }
    
    protected class Client implements Runnable
    {
        SocketConnection sock;
        InputStream in;
        OutputStream out;
        public Client(SocketConnection sock) throws IOException
        {
            this.sock = sock;
            in = sock.openDataInputStream();
            out = sock.openDataOutputStream();
        }
        
        public void respond(String str) throws IOException
        {
            str += "\n\r";
            out.write(str.getBytes());
        }

        public void run() {
            try {
                Constants constants = Constants.getConstants();
                respond("# FRC225");
                respond("# Set constants by typing CONSTANT=NEWVALUE");
                respond("# Get constants by typing CONSTANT");
                while(true)
                {
                    boolean valueEntered = false;
                    String requestedKey = "";
                    String newValue = "";
                    while ( in.available() > 0 )
                    {
                        byte[] b = new byte[1];
                        in.read(b);
                        if ( b[0] == '\r' )
                        {} // disregard \r
                        else if ( b[0] == '\n' )
                        {
                           if ( requestedKey.equals("save") )
                           {
                               respond("Writing constants to file...");
                               if ( constants.save() )
                                   respond("Success!");
                               else
                                   respond("Write failed");
                           }
                           if ( valueEntered )
                           {
                               double newDoubleValue = Double.parseDouble(newValue);
                               constants.put(requestedKey, newDoubleValue);
                           }
                           respond(requestedKey+"="+constants.get(requestedKey));
                        }
                        else if ( b[0] == '=' )
                            valueEntered = true;
                        else
                        {
                            if ( valueEntered )
                                newValue += new String(b);
                            else
                                requestedKey += new String(b);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {} // Catch and ignore all client exceptions, 
        }
    }
    
}
