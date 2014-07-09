package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.presets.StowIntake;

/**
 *
 * @author Andrew
 */
public class Catch extends CommandGroup {
    public Catch()
    {
        addSequential(new SetRollers(false));
        addSequential(new SetCatcher(false));
        addSequential(new StowIntake());
    }
}
