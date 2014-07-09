/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.intake;

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
