/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.Launch;
import org.team225.robot2014.commands.intake.HoldBall;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class HPKick extends CommandGroup {

    public HPKick()
    {
        addSequential(new Launch(false, false, 0, true));
    }
}
