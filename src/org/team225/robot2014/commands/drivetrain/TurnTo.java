/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.commands.SimplePIDCommand;

/**
 *
 * @author Andrew
 */
public class TurnTo extends SimplePIDCommand {

    public TurnTo(double angle)
    {
        super(Constants.getConstants().get("DRIVETRAIN_TURN_P"), Constants.getConstants().get("DRIVETRAIN_TURN_I"), Constants.getConstants().get("DRIVETRAIN_TURN_D"));
        pid.setTarget(angle);
        requires(drivetrain);
    }
    
    protected double getCurrent() {
        return drivetrain.getAngle();
    }

    protected void setOutput(double value) {
        drivetrain.setMotorSpeeds(value, -value);
    }
    
}
