/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.drivetrain.straight.DriveDistance;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class OneBallHotGoal extends CommandGroup {
    public OneBallHotGoal()
    {
        addSequential(new DriveDistance(5600));
        addSequential(new WaitCommand(0.5));
        addSequential(new WaitForHotGoal());
        addSequential(new HighPowerShot());
        addSequential(new WaitCommand(2.0));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
}
