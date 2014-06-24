/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class Launch extends CommandGroup {
    
    Timer t = new Timer();
    
    public Launch(boolean latch, boolean bothCylinders, double timeDelay)
    {
        this(latch, bothCylinders, timeDelay, false);
    }
    
    public Launch(boolean latch, boolean bothCylinders, double timeDelay, boolean intakeWait)
    {
        addSequential(new MoveArm(MoveArm.ARM_SHOOTING, true));
        if ( latch )
            addSequential(new LockCatapult());
        addSequential(new ReleaseCatapult(bothCylinders, timeDelay));
        addSequential(new ResetCatapult());
    }
    
    protected void initialize()
    {
        t.reset();
        t.start();
        super.initialize();
    }
    
    protected void end()
    {
        System.out.println("Launch ended in "+t.get());
        super.end();
    }
    
    protected void interrupted()
    {
        System.out.println("Launch interrupted at "+t.get());
        super.interrupted();
    }
}
