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
public class Collect extends CommandGroup {
    public Collect()
    {
        addSequential(new MoveArm(MoveArm.ARM_OUT));
        addSequential(new SetRollers(true, false));
    }
}
