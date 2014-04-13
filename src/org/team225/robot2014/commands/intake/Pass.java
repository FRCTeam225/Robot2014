/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Andrew
 */
public class Pass extends CommandGroup {
    public Pass()
    {
        addSequential(new SetRollers(true, true));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
}
