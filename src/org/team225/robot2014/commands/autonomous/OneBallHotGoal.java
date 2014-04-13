/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.commands.AutonomousWrapper;
import org.team225.robot2014.commands.catapult.LowPowerShot;
import org.team225.robot2014.commands.catapult.Launch;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.StowWithBall;

/**
 *
 * @author Andrew
 */
public class OneBallHotGoal extends CommandGroup {
    public OneBallHotGoal()
    {
        addSequential(new DriveDistance(Constants.getConstants().get("AUTO_DISTANCE_TO_GOALS")));
        addSequential(new WaitForHotGoal());
        addSequential(new LowPowerShot());
        addSequential(new WaitCommand(2.0));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
}
