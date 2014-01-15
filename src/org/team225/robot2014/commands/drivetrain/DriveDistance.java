/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.Constants;
import org.team225.robot2014.commands.SimplePIDCommand;

/**
 *
 * @author Andrew
 */
public class DriveDistance extends SimplePIDCommand {
    public DriveDistance(double distance)
    {
        this(distance, 1);
        requires(drivetrain);
    }
    
    public DriveDistance(double distance, double maxSpeed)
    {
        super(Constants.DRIVETRAIN_P, Constants.DRIVETRAIN_I, Constants.DRIVETRAIN_D);
        
        pid.setOutputConstraints(maxSpeed, -maxSpeed);
        pid.setTarget(distance);
    }

    protected double getCurrent() {
        return drivetrain.getAverageDistance();
    }

    protected void setOutput(double value) {
        drivetrain.setMotorSpeeds(value, value);
    }
}
