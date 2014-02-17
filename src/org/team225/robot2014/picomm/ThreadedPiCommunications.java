/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.picomm;

import com.sun.squawk.platform.posix.natives.Socket;
import edu.wpi.first.wpilibj.Timer;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author Andrew
 */
public class ThreadedPiCommunications implements Runnable {
    boolean hasTarget = false;
    
    public ThreadedPiCommunications()
    {
    }
    
    public boolean hasTarget()
    {
        return hasTarget;
    }
    
    public void updateState()
    {
        new Thread(this).start();
    }
    
    public void run()
    {
        try {
            StreamConnection conn = (StreamConnection)Connector.open("socket://10.2.25.22:1337");
            DataInputStream stream = conn.openDataInputStream();
            Timer t = new Timer();
            t.reset();
            t.start();
            while ( stream.available() == 0 && t.get() < 2.0 );
            int b = stream.read();
            hasTarget = (b != 0);
            t.stop();
            
            stream.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed!");
        }
    }
}
