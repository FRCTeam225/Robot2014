package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.Launch;

/**
 *
 * @author Andrew
 */
public class LowPowerShot extends CommandGroup {
    public LowPowerShot()
    {
        this(true);
    }
    
    public LowPowerShot(boolean waitForIntake)
    {
        addSequential(new Launch(true, true, 0.225, waitForIntake));
    }
}
