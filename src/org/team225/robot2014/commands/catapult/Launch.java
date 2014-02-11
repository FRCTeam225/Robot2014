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
public class Launch extends CommandGroup {
    public Launch(boolean latch, boolean bothCylinders)
    {
        setInterruptible(false);
        if ( latch )
            addSequential(new LockCatapult());
        addSequential(new ReleaseCatapult(bothCylinders));
        addSequential(new ResetCatapult());
    }
}
