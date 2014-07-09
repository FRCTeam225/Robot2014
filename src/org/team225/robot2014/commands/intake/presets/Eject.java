package org.team225.robot2014.commands.intake.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class Eject extends CommandGroup {
    public Eject()
    {
        addSequential(new SetRollers(true, true));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
}
