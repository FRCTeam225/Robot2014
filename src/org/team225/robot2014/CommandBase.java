/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.team225.robot2014.picomm.ThreadedPiCommunications;
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

    public static Drivetrain drivetrain;
    public static Catapult catapult; 
    public static Intake intake;
    public static Catcher catcher;
    public static Compressor compressor;
    
    public static ThreadedPiCommunications piComm;
    public static NetworkTable table;
    
    public static Timer matchTimer;
    
    public static void init()
    {
        drivetrain = new Drivetrain();
        compressor = new Compressor();
        catapult = new Catapult();
        intake = new Intake();
        catcher = new Catcher();
        
        piComm = new ThreadedPiCommunications();
        table = NetworkTable.getTable("225");
    }

    protected void interrupted() {
        end();
    }
    
}
