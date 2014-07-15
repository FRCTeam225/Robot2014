/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.drivetrain.straight.DriveDistance;

/**
 *
 * @author andrew
 */
public class DriveForward extends CommandGroup {
    public DriveForward()
    {
        addSequential(new DriveDistance(6000));
    }
}
