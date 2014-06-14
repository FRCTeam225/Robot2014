/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.drivetrain.DriveDistance;

/**
 *
 * @author Andrew
 */
public class OnlyDriveForward extends CommandGroup {
    public OnlyDriveForward()
    {
        addSequential(new DriveDistance(5000));
    }
}
