package org.team225.robot2014.constants;

import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.microedition.io.Connector;

/**
 * @author Andrew
 */
public class Constants extends DoubleTable {
    public static String PATH = "file:///constants";
    public static Constants constants = null;
    public Constants()
    {
        put("DRIVETRAIN_P", 0.0008);
        put("DRIVETRAIN_I", 0.0000);
        put("DRIVETRAIN_D", 0.007);
        
        put("DRIVETRAIN_DRIVESTRAIGHT_P", -0.065);
        
        put("DRIVETRAIN_TURN_P", -0.05);
        put("DRIVETRAIN_TURN_I", 0);
        put("DRIVETRAIN_TURN_D", -0.095);
        
        put("ARM_P", 0.01);
        put("ARM_I", 0);
        put("ARM_D", 0.01);
        
        put("ARM_DOWN_THRESH", 540);
        
        put("AUTO_DISTANCE_TO_GOALS", 9250);
        
        put("HOLDPOSITION_P", 0.0008);
        put("HOLDPOSITION_TURN_P", 0.0008);
        
        try {
            FileConnection fc = (FileConnection)Connector.open(PATH);
            if ( fc.exists() )
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(fc.openInputStream()));
                boolean valueEntered = false;
                String key = "";
                String value = "";
                while ( true )
                {
                    char[] b = new char[1];
                    int c = in.read();
                    if ( c == -1 )
                        break;
                    else
                        b[0] = (char)c;
                    
                    if ( b[0] == '\r' ) {} // ignore \r
                    else if ( b[0] == '\n' )
                    {
                        if ( valueEntered )
                        {
                            put(key, Double.parseDouble(value));
                        }
                        valueEntered = false;
                        key = "";
                        value = "";
                        
                    }
                    else if ( b[0] == '=' )
                    {
                        valueEntered = true;
                    }
                    else
                    {
                        String s = new String(b);
                        if ( valueEntered )
                            value += s;
                        else
                            key += s;
                    }
                }
            }
            else
                System.out.println("No constants file exists!");
        } catch (IOException ex) {
            System.out.println("Failed to load constants from file! Hard-coded defaults will be used");
            ex.printStackTrace();
        }
    }
    
    public boolean save()
    {
        try
        {
            FileConnection fc = (FileConnection)Connector.open(PATH);
            if ( fc.exists() )
                fc.delete();
            fc.create();
            OutputStream out = fc.openOutputStream();
            Enumeration keys = keys();
            while ( keys.hasMoreElements() )
            {
                String key = (String)keys.nextElement();
                double value = get(key);
                String str = key+"="+value+"\n";
                out.write(str.getBytes());
            }
            out.flush();
            out.close();
            fc.close();
            return true;
        } catch (Exception e) {
            System.out.println("Failed to write constants");
            e.printStackTrace();
            return false;
        }
    }
    
    public static Constants getConstants()
    {
        if ( constants != null )
            return constants;
        
        constants = new Constants();
        return constants;
    }
}
