/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class Eject extends CommandGroup {
    public Eject()
    {
        addSequential(new SetRollers(true, true));
        addSequential(new MoveArm(false));
    }
}
