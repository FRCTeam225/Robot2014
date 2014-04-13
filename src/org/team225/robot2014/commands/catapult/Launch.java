/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class Launch extends CommandGroup {
    
    public Launch(boolean latch, boolean bothCylinders, double timeDelay)
    {
        this(latch, bothCylinders, timeDelay, false);
    }
    
    public Launch(boolean latch, boolean bothCylinders, double timeDelay, boolean intakeWait)
    {
        addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
        if ( intakeWait )
            addSequential(new WaitCommand(0.4));
         //addSequential(new WaitCommand(0.1));
        if ( latch )
            addSequential(new LockCatapult());
        addSequential(new ReleaseCatapult(bothCylinders, timeDelay));
        addSequential(new ResetCatapult());
    }
}
