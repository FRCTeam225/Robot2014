package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.Robot2014;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class Goalie extends CommandBase {
          
    
    public Goalie()
    {
        requires(drivetrain);
        requires(intake);
        setTimeout(10);
    }
    
    
    
    /*
    protected double getAngleForLocation(double pos)
    {
        for ( int i = 0; i < angleMap.length; i++ )
        {
            if ( (i == 0 && pos <= angleMap[i][0]) || (i == (angleMap.length-1) && pos >= angleMap[i][0]) ) // we are behind/infront the first/last waypoint
            {
                return angleMap[i][1];
            }
            else if ( (i+1) < angleMap.length ) // there is a waypoint in front of this one
            {
                if ( angleMap[i][0] <= pos && angleMap[i+1][0] >= pos ) // between the waypoints
                {
                    double slope = (angleMap[i][1]-angleMap[i+1][1])/(angleMap[i][0]-angleMap[i+1][0]);
                    return slope*pos;
                }
            }
        }
        return 0;
    }*/
    
    
    protected boolean shouldFlip()
    {
        return false;
    }
    
    
    protected double getAngleForLocation(double pos)
    {
        if ( pos < constants.get("GOALIE_PEEK_POS") )
            return constants.get("GOALIE_PEEK_ANGLE");
        return 0;
    }

    protected void initialize() {
        drivetrain.setMotorSpeeds(0, 0);
        Robot2014.wasGoalie = true;
    }

    protected void execute() {
        intake.setRoller(true, true);
        drivetrain.shift(true);
        boolean left = CommandBase.table.getBoolean("leftHot");
        boolean right = CommandBase.table.getBoolean("rightHot");
        double angle;
        double angleError;
        
        if ( shouldFlip() )
        {
            angle = -180;
            angleError = (drivetrain.getAngle()-angle);
            if ( Math.abs(angleError) > 10 )
                left = right = false;
            else
            {
                System.out.println("Flipped");
                boolean tmp = right;
                right = left;
                left = tmp;
            }
        }
        else
        {
            angle = getAngleForLocation(drivetrain.getAverageDistance());
            angleError = (drivetrain.getAngle()-angle);
        }
        
        double speed = constants.get("GOALIE_SPEED");
     
        if ( !left && right )
            speed = -speed;
        else if ( left && right || !left && !right  )
            speed = 0;

        if ( drivetrain.getAverageDistance() <= constants.get("GOALIE_LOW_LIMIT") && right )
            speed = 0;
        
        double offset = -Constants.getConstants().get("HOLDPOSITION_TURN_P")*angleError;
        if ( Math.abs(speed) > 0 )
            offset *= Math.abs(speed);
        double lspeed = speed+offset;
        double rspeed = speed-offset;
        System.out.println(angle+" for "+drivetrain.getAverageDistance());

        drivetrain.setMotorSpeeds(-lspeed, -rspeed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drivetrain.shift(false);
        intake.setRoller(false,false);
        drivetrain.setMotorSpeeds(0, 0);
    }
}
