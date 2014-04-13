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
public class DriveArc extends SimplePIDCommand {
    double angle = 0;
    double maxSpeed = 0;
    double arc = 0;
    public DriveArc(double distance, double arc)
    {
        this(distance, arc, 1);
        setTimeout(5);
    }
    
    public boolean isFinished()
    {
        return super.isFinished() || isTimedOut();
    }
    
    public DriveArc(double distance, double arc, double maxSpeed)
    {
        super(Constants.getConstants().get("DRIVETRAIN_P"), Constants.getConstants().get("DRIVETRAIN_I"), Constants.getConstants().get("DRIVETRAIN_D"));
        requires(drivetrain);
        this.maxSpeed = maxSpeed;
        this.arc = arc;
        pid.setOutputConstraints(1, -1);
        pid.setTarget(distance);
    }
    
    protected double getCurrent() {
        return drivetrain.getLeftDistance();
    }

    protected void setOutput(double value) {
        
        if ( value > maxSpeed )
            value = maxSpeed;
        
        if ( value < -maxSpeed )
            value = -maxSpeed;
        
        double left = value;
        double right = value;
        
        double offset = arc;
        if ( value > 0 )
            arc = -arc;
        offset *= Math.abs(value);
        
        left += offset;
        right -= offset;
        drivetrain.setMotorSpeeds(-left, -right);
    }
}
