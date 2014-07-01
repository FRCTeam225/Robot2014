/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.team225.robot2014.constants.ConstantServer;
import org.team225.robot2014.subsystems.Catapult;
import org.team225.robot2014.subsystems.Catcher;
import org.team225.robot2014.subsystems.Compressor;
import org.team225.robot2014.subsystems.Drivetrain;
import org.team225.robot2014.subsystems.Intake;

/**
 *
 * @author Andrew
 */

public abstract class CommandBase extends Command {

    public static boolean disableSensorWaits = false;
    
    public static Drivetrain drivetrain;
    public static Catapult catapult; 
    public static Intake intake;
    public static Catcher catcher;
    public static Compressor compressor;
    
    public static ConstantServer constantServer;

    public static NetworkTable table;
    
    public static Timer matchTimer;
    
    public static void init()
    {
        constantServer = ConstantServer.create(225);
        drivetrain = new Drivetrain();
        compressor = new Compressor();
        catapult = new Catapult();
        intake = new Intake();
        catcher = new Catcher();

        table = NetworkTable.getTable("225");
    }

    protected void interrupted() {
        end();
    }
    
}
