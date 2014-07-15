package org.team225.robot2014.commands.intake.presets;

import edu.wpi.first.wpilibj.Timer;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author andrew
 */
public class MoveArmForShooting extends MoveArm {
    Timer t = new Timer();
    
    public MoveArmForShooting()
    {
        super(MoveArm.ARM_SHOOTING, true);
    }
    
    protected void initialize()
    {
        t.reset();
        t.start();
        super.initialize();
    }
    
    protected boolean isFinished()
    {
        return super.isFinished();
    }
    
    protected void end()
    {
        super.end();
        System.out.println("Arm ready for shot in "+t.get());
    }
}
