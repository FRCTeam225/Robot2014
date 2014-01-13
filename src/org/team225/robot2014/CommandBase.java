/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

import edu.wpi.first.wpilibj.command.Command;
import org.team225.robot2014.subsystems.Drivetrain;

/**
 *
 * @author Andrew
 */
public abstract class CommandBase extends Command {

    public static Drivetrain drivetrain;
    
    public static void init()
    {
        drivetrain = new Drivetrain();
    }

    protected void interrupted() {
        end();
    }
    
}
