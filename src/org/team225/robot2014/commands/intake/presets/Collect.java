package org.team225.robot2014.commands.intake.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class Collect extends CommandGroup {
    public Collect()
    {
        addSequential(new MoveArm(MoveArm.ARM_OUT));
        addSequential(new SetRollers(true, false));
    }
}
