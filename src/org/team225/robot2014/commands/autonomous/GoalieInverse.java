package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.drivetrain.turning.TurnTo;

/**
 *
 * @author Andrew
 */
public class GoalieInverse extends CommandGroup {   
    public GoalieInverse()
    {
        addSequential(new TurnTo(180));
        addSequential(new FlippedGoalieDrive());
    }
    
    public class FlippedGoalieDrive extends Goalie 
    {
        protected void execute() {
            intake.setRoller(true, true);
            drivetrain.shift(true);
            boolean left = CommandBase.table.getBoolean("leftHot");
            boolean right = CommandBase.table.getBoolean("rightHot");

            double speed = constants.get("GOALIE_SPEED");
            double offset = constants.get("DRIVETRAIN_DRIVESTRAIGHT_P")*(drivetrain.getAngle()-180);
            offset *= speed;
            double lspeed = speed+offset;
            double rspeed = speed-offset;

            if ( left && !right )
                drivetrain.setMotorSpeeds(-lspeed, -rspeed);
            else if ( !left && right )
                drivetrain.setMotorSpeeds(lspeed, rspeed);
            else
                drivetrain.setMotorSpeeds(0, 0);
        }
    }
}
