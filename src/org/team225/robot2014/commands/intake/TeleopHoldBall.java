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
public class TeleopHoldBall extends CommandBase {

    public TeleopHoldBall()
    {
        requires(intake);
    }
    
    protected void initialize() {
        intake.setAngle(false);
    }

    protected void execute() {
            if ( !intake.hasBall() )
                intake.setRoller(-0.5);
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
