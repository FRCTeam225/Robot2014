package org.team225.robot2014.commands.intake.presets;

import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author andrew
 */
public class MoveArmForShooting extends MoveArm {
    public MoveArmForShooting()
    {
        super(MoveArm.ARM_SHOOTING, true);
    }
    
    protected boolean isFinished()
    {
        return super.isFinished() || (catapult.isPressurized() && intake.isAbleToFire() );
    }
}
