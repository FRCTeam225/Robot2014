package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.intake.AutoCenter;

/**
 *
 * @author Andrew
 */
public class PowerCatch extends CommandGroup {

    public PowerCatch()
    {
       addSequential(new AutoCatch());
       addSequential(new WaitCommand(0.3));
       addSequential(new AutoCenter());
    }
    
   
}
