package org.team225.robot2014.commands.autonomous.jukes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.commands.autonomous.OneBall;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.catapult.presets.LowPowerShot;
import org.team225.robot2014.commands.drivetrain.turning.TurnTo;
import org.team225.robot2014.commands.drivetrain.arc.DriveArc;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author andrew
 */
public class OneBallJukeArc extends CommandGroup {
    
    public OneBallJukeArc()
    {
        if ( AutonomousWrapper.leftIsHot )
        {
            addSequential(new LockCatapult());
            addSequential(new MoveArm(MoveArm.ARM_SHOOTING));

            addSequential(new DriveArc(9000,1,-53));
            addSequential(new TurnTo(0));
            addSequential(new LowPowerShot());
        }
        else
        {
            addSequential(new OneBall());
        }
    }
}
