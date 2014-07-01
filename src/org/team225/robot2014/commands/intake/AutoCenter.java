/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class AutoCenter extends CommandBase {

    public AutoCenter()
    {
        requires(intake);
    }
    
    protected void initialize() {
        intake.setAngle(false);
    }

    protected void execute() {
            if ( !intake.hasBall() && !intake.isAbleToFire() )
                intake.setRoller(true, true, true);
            else
                intake.setRoller(false, false);
    }

    protected boolean isFinished() {
        return intake.hasBall();
    }

    protected void end() {
        intake.setRoller(false, false);
    }
    
}
