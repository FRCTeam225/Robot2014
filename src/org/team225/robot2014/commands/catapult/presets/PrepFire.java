package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.intake.AutoCenter;

/**
 *
 * @author Andrew
 */
public class PrepFire extends CommandGroup {

    public PrepFire() {
        requires(CommandBase.catapult);
        addSequential(new AutoCenter(true));
        addSequential(new LockCatapult());
    }
    
    protected void end()
    {
        super.end();
        CommandBase.catapult.setPressurized(true, true);
    }

}
