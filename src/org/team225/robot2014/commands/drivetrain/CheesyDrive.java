package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.OI;

/**
 *
 * @author Andrew
 */
public class CheesyDrive extends CommandBase {
    
    double turn_gain = 1.1;
    double skim_gain = 0.4; // was 0.4
    double turn_velocity_multiplier_gain = 0.8;
    double quickStopAccumulator = 0;
    
    public CheesyDrive()
    {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {

        double throttle = OI.driver.getRawAxis(2);
        double turnInput = OI.driver.getRawAxis(3);
        double wheelNonLinearity = 0.5;
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        
        if ( Math.abs(turnInput) < 0.07 )
            turnInput = 0;
        
        double turn = 0;
        if ( Math.abs(throttle) < 0.07 )
        {
            throttle = 0;
            turn = turnInput;
        }
        else
            turn = (turnInput*turn_gain)*Math.abs(turn_velocity_multiplier_gain*OI.driver.getRawAxis(2));
        
        double left_orig = throttle-turn;
        double right_orig = throttle+turn;

        double left = left_orig+ skim(right_orig);
        double right = right_orig+skim(left_orig);

        drivetrain.setMotorSpeeds(left, right);
        if ( OI.driver.getRawButton(5) )
            drivetrain.shift(false);
        else if ( OI.driver.getRawButton(7) )
            drivetrain.shift(true);
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.setMotorSpeeds(0, 0);
    }
    
    private double skim(double v) {
        if (v > 1.0)
            return -((v - 1.0) * skim_gain);
        else if (v < -1.0)
            return -((v + 1.0) * skim_gain);
        return 0;
    }
}
