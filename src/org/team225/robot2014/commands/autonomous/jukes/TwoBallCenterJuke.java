package org.team225.robot2014.commands.autonomous.jukes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.autonomous.UpdateHotGoal;
import org.team225.robot2014.commands.catapult.ResetCatapult;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.drivetrain.straight.DriveDistance;
import org.team225.robot2014.commands.drivetrain.straight.DriveWhileCollecting;
import org.team225.robot2014.commands.drivetrain.straight.DriveWhileHolding;
import org.team225.robot2014.commands.drivetrain.turning.TurnAndFire;
import org.team225.robot2014.commands.drivetrain.turning.TurnTo;
import org.team225.robot2014.commands.intake.AutoCenter;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.presets.StowIntake;

/**
 *
 * @author andrew
 */
public class TwoBallCenterJuke extends CommandGroup {
    public TwoBallCenterJuke()
    {
        addSequential(new DriveDistance(5600));
        addSequential(new UpdateHotGoal());
        addSequential(new TurnAndFire(13, true));
        addSequential(new ResetCatapult());
        addSequential(new TurnTo(0));
        addSequential(new MoveArm(true));
        addSequential(new WaitCommand(1.3));

        addSequential(new DriveWhileCollecting(-1650));
        addSequential(new WaitCommand(0.35));
        addSequential(new StowIntake());
        
        addSequential(new DriveWhileHolding(5900));
        addSequential(new AutoCenter());
        addSequential(new WaitForBall());
        addSequential(new UpdateHotGoal());
        addSequential(new TurnAndFire(13, true));
        addSequential(new ResetCatapult());
    }
}
