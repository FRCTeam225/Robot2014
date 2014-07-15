package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.Robot2014;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class GoalieStraight extends Goalie {    

    protected void execute() {
        intake.setRoller(true, true);
        drivetrain.shift(true);
        boolean left = CommandBase.table.getBoolean("leftHot");
        boolean right = CommandBase.table.getBoolean("rightHot");
        
        double speed = constants.get("GOALIE_SPEED");
        double offset = constants.get("DRIVETRAIN_DRIVESTRAIGHT_P")*drivetrain.getAngle();
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
}
