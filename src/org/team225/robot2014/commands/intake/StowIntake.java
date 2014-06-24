/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class StowIntake extends CommandGroup {
    public StowIntake()
    {
        requires(CommandBase.catapult);
        addSequential(new SetRollers(false));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
    
    protected void initialize()
    {
        CommandBase.catapult.setPressurized(false);
        super.initialize();
    }
}
