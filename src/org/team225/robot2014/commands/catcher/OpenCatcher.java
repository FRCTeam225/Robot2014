package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class OpenCatcher extends CommandGroup {
    public OpenCatcher()
    {
        addSequential(new SetRollers(false));
        addSequential(new SetCatcher(true));
        addSequential(new MoveArm(MoveArm.ARM_OUT));
    }
}
