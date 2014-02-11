/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.Constants;

/**
 *
 * @author Andrew
 */
public class Collect extends CommandGroup {
    public Collect()
    {
        addSequential(new SetRollers(true));
        addSequential(new MoveArm(Constants.ARM_OUT));
    }
}
