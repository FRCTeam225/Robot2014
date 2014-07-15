package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;
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

    protected void initialize() {
        drivetrain.setMotorSpeeds(0, 0);
    }

    protected void execute() {
        intake.setRoller(true, true);
        drivetrain.shift(true);
        boolean left = CommandBase.table.getBoolean("leftHot");
        boolean right = CommandBase.table.getBoolean("rightHot");
        double speed = 50;
        double offset = Constants.getConstants().get("DRIVETRAIN_DRIVESTRAIGHT_P")*(drivetrain.getAngle());
        offset *= speed;
        double lspeed = speed+offset;
        double rspeed = speed-offset;
        
        if ( left && !right )
            drivetrain.setMotorSpeeds(lspeed, rspeed);
        else if ( !left && right )
            drivetrain.setMotorSpeeds(-lspeed, -rspeed);
        else
            drivetrain.setMotorSpeeds(0, 0);
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
