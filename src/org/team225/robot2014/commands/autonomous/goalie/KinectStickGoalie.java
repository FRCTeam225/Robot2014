/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.autonomous.goalie;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.SimplePID;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class KinectStickGoalie extends CommandBase {
    
    int targetDistance = 0;
    int targetAngle = 0;
    SimplePID pid;
    AngleMapItem angleMap[];
    
    public KinectStickGoalie()
    {
        this.pid = new SimplePID(Constants.getConstants().get("DRIVETRAIN_P"), Constants.getConstants().get("DRIVETRAIN_I"), Constants.getConstants().get("DRIVETRAIN_D"));
        requires(drivetrain);
        requires(intake);
        
        this.angleMap = new AngleMapItem[] {
            new AngleMapItem(10, 1000),
            new AngleMapItem(15, 2000)
        };
    }


    protected void initialize() {
        intake.setRoller(true, true);
        pid.setTarget(0);
    }

    protected void execute() {
        
        double speed = pid.calculate(drivetrain.getAverageDistance());
        double offset = Constants.getConstants().get("DRIVETRAIN_DRIVESTRAIGHT_P")*(drivetrain.getAngle()-getAngleForCurrentPosition());
        offset *= Math.abs(speed);
        
        double left = speed;
        double right = speed;
        
        left += offset;
        right -= offset;
        drivetrain.setMotorSpeeds(-left, -right);
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        intake.setRoller(0);
    }
    
    private double getAngleForCurrentPosition()
    {
        for ( int i = 0; i < angleMap.length; i++ )
        {
            if ( angleMap[i].upTo > drivetrain.getAverageDistance() )
                return angleMap[i].angle;
        }
        return 0;
    }
}
