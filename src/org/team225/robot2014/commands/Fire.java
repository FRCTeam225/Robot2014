/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.Launch;
import org.team225.robot2014.commands.catapult.Pressurize;
import org.team225.robot2014.commands.catapult.Reload;

/**
 *
 * @author Andrew
 */
public class Fire extends CommandGroup {
    public Fire()
    {
        setInterruptible(false);
        addSequential(new Launch());
        addSequential(new Reload());
    }
}
