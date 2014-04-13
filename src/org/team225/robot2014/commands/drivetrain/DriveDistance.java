/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.commands.SimplePIDCommand;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class DriveDistance extends SimplePIDCommand {
    double angle = 0;
    double maxSpeed = 0;
    public DriveDistance(double distance)
    {
        this(distance, 1);
        setTimeout(5);
    }
    
    public boolean isFinished()
    {
        return super.isFinished() || isTimedOut();
    }
    
    public DriveDistance(double distance, double maxSpeed)
    {
        super(Constants.getConstants().get("DRIVETRAIN_P"), Constants.getConstants().get("DRIVETRAIN_I"), Constants.getConstants().get("DRIVETRAIN_D"));
        requires(drivetrain);
        this.maxSpeed = maxSpeed;
        pid.setOutputConstraints(1, -1);
        pid.setTarget(distance);
    }
    
    public void setTargetAngle(double angle)
    {
        this.angle = angle;
    }

    protected double getCurrent() {
        return drivetrain.getAverageDistance();
    }

    protected void setOutput(double value) {
        
        if ( value > maxSpeed )
            value = maxSpeed;
        
        if ( value < -maxSpeed )
            value = -maxSpeed;
        
        double left = value;
        double right = value;
        
        double offset = Constants.getConstants().get("DRIVETRAIN_DRIVESTRAIGHT_P")*(drivetrain.getAngle()-angle);
        offset *= Math.abs(value);
        
        left += offset;
        right -= offset;
        System.out.println(offset);
        drivetrain.setMotorSpeeds(-left, -right);
    }
}
