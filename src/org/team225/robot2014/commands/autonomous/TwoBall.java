/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.Constants;
import org.team225.robot2014.commands.catapult.FarShot;
import org.team225.robot2014.commands.catapult.Launch;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.Collect;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.StowWithBall;

/**
 *
 * @author Andrew
 */
public class TwoBall extends CommandGroup {
    public TwoBall()
    {
        addSequential(new StowWithBall());
        addSequential(new WaitCommand(0.5)); // Settle the ball
        
        addSequential(new SetRollers(true, false, true));
        addSequential(new MoveArm(Constants.ARM_OUT));
        addSequential(new WaitCommand(0.5));
        addSequential(new SetRollers(false));
        addSequential(new DriveDistance(Constants.AUTO_DISTANCE_TO_GOALS));
        addSequential(new StowWithBall());
        addSequential(new WaitCommand(0.6));
        addSequential(new FarShot());
        addSequential(new WaitCommand(2));
        addSequential(new Collect());
        
        addSequential(new DriveDistance(Constants.AUTO_DISTANCE_TO_GOALS-500));
        addSequential(new StowWithBall());
        addSequential(new DriveDistance(Constants.AUTO_DISTANCE_TO_GOALS));
        addSequential(new WaitCommand(1));
        addSequential(new FarShot());
        
    }
}
