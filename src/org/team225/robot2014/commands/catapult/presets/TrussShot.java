package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.Launch;

/**
 *
 * @author Andrew
 */
public class TrussShot extends CommandGroup {
    public TrussShot()
    {
        addSequential(new Launch(false, true, 0.225));
    }
}
