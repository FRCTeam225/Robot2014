/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.constants;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.io.Connector;

/**
 *
 * @author Andrew
 */
public class Constants extends DoubleTable {
    public static Constants constants = null;
    public boolean isPracticeBot = false;
    public Constants()
    {
        put("DRIVETRAIN_P", 0.0006);
        put("DRIVETRAIN_I", 0);
        put("DRIVETRAIN_D", 0);
        
        put("DRIVETRAIN_DRIVESTRAIGHT_P", -0.05);
        
        put("DRIVETRAIN_TURN_P", 0);
        put("DRIVETRAIN_TURN_I", 0);
        put("DRIVETRAIN_TURN_D", 0);
        
        put("ARM_P", 0.01);
        put("ARM_I", 0);
        put("ARM_D", 0.01);
        
        put("ARM_DOWN_THRESH", 540);
        
        put("AUTO_DISTANCE_TO_GOALS", 9250);
    }
    
    public boolean isPracticeBot()
    {
        return isPracticeBot;
    }
    
    public static Constants getConstants()
    {
        if ( constants != null )
            return constants;
        
        
        boolean isPracticeRobot = false;
        try {
            FileConnection fc = (FileConnection)Connector.open("file:///isPracticeRobot");
            isPracticeRobot = fc.exists();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if ( isPracticeRobot )
        {
            constants = new PracticeRobotConstants();
            
            System.out.println("I AM A PRACTICE ROBOT!");

        }
        else
        {
            constants = new Constants();
            System.out.println("I AM A COMPETITION ROBOT");
        }
        constants.isPracticeBot = isPracticeRobot;
        return constants;
    }
}
