/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.drivetrain.DriveDistance;

/**
 *
 * @author Andrew
 */
public class OneBall extends CommandGroup {
    public OneBall()
    {
        addSequential(new DriveDistance(10000));
    }
}
