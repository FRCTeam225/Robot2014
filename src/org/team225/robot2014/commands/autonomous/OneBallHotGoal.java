/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.Constants;
import org.team225.robot2014.commands.AutonomousWrapper;
import org.team225.robot2014.commands.catapult.FarShot;
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
        addSequential(new StowWithBall());
        addSequential(new WaitCommand(0.3));
        addSequential(new DriveDistance(Constants.AUTO_DISTANCE_TO_GOALS));
        if ( !AutonomousWrapper.startingGoalIsHot )
            addSequential(new WaitCommand(5.0));
        
        addSequential(new FarShot());
        addSequential(new WaitCommand(2.0));
        addSequential(new MoveArm(Constants.ARM_STOW));
    }
}
