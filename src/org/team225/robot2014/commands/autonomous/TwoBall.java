/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.HighPowerShot;
import org.team225.robot2014.commands.catcher.SetCatcher;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.Collect;
import org.team225.robot2014.commands.intake.HoldBall;

/**
 *
 * @author Andrew
 */
public class TwoBall extends CommandGroup {
    public TwoBall()
    {
        addSequential(new HoldBall());
        addSequential(new DriveDistance(6640));
        addSequential(new HighPowerShot());
        addSequential(new WaitCommand(1));
        addSequential(new Collect());
        addSequential(new SetCatcher(true));
        addSequential(new DriveDistance(-2000));
        addSequential(new HoldBall());
        addSequential(new SetCatcher(false));
        addSequential(new DriveDistance(6800));
        addSequential(new HighPowerShot());
        
        /*
        
        addSequential(new SetRollers(true, false, true));
        addSequential(new MoveArm(Constants.getConstants().getInt("ARM_OUT")));
        addSequential(new WaitCommand(0.5));
        addSequential(new SetRollers(false));
        addSequential(new DriveDistance(Constants.getConstants().get("AUTO_DISTANCE_TO_GOALS_2BALL")));
        addSequential(new StowWithBall());
        addSequential(new WaitCommand(0.6));
        addSequential(new FarShot());
        addSequential(new WaitCommand(2));
        addSequential(new Collect());
        
        addSequential(new DriveDistance(Constants.getConstants().get("AUTO_DISTANCE_TO_GOALS_2BALL")-500));
        addSequential(new StowWithBall());
        addSequential(new DriveDistance(Constants.getConstants().get("AUTO_DISTANCE_TO_GOALS_2BALL")));
        addSequential(new WaitCommand(1));
        addSequential(new FarShot());
        */
    }
}
