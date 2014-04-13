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
public class HighPowerShot extends CommandGroup {
    public HighPowerShot()
    {
        this(false);
    }
    
    public HighPowerShot(boolean waitForIntake)
    {
        addSequential(new Launch(true, true, 0.38, waitForIntake));
    }
}
