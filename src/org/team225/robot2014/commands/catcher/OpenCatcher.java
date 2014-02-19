/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class OpenCatcher extends CommandGroup {
    public OpenCatcher()
    {
        addSequential(new SetRollers(false));
        addSequential(new SetCatcher(true));
        addSequential(new MoveArm(Constants.getConstants().getInt("ARM_OUT")));
    }
}
