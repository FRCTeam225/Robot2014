package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.Launch;

/**
 *
 * @author Andrew
 */
public class HighPowerShot extends CommandGroup {
    public HighPowerShot()
    {
        this(false);
    }
    
    public HighPowerShot(boolean waitForIntake)
    {
        addSequential(new Launch(true, true, 0.38, waitForIntake));
    }
}
