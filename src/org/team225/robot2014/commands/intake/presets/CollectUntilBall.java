package org.team225.robot2014.commands.intake.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class CollectUntilBall extends CommandGroup {
    public CollectUntilBall()
    {
        addSequential(new MoveArm(MoveArm.ARM_OUT));
        addSequential(new SetRollers(true, false));
        addSequential(new WaitForBall());
    }
}
