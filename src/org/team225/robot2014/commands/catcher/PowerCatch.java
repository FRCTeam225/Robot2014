/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.HoldBall;

/**
 *
 * @author Andrew
 */
public class PowerCatch extends CommandGroup {

    public PowerCatch()
    {
        addSequential(new SetCatcher(true));
        addSequential(new HoldBall());
        addSequential(new SetCatcher(false));
    }
}
