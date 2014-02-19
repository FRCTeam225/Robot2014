/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Andrew
 */
public class SuperShot extends CommandGroup {
    public SuperShot()
    {
        addSequential(new Launch(true, true, 0.5));
    }
}
