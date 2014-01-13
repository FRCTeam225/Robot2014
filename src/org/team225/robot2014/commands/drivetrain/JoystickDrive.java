/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.OI;

/**
 *
 * @author Andrew
 */
public class JoystickDrive extends CommandBase {

    public JoystickDrive()
    {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        drivetrain.setMotorSpeeds(OI.jsL.getY(), OI.jsR.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.setMotorSpeeds(0, 0);
    }
    
}
