package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class AutoRunningShot extends CommandGroup {
    public class AutoRunningShot_run extends CommandBase
    {
        double driveDistance = 0;
        double preLength = 0;
        double angle = 0;
        public AutoRunningShot_run(double preShotLength, double postShotLength, double angle)
        {
            requires(drivetrain);
            requires(catapult);
            this.driveDistance = preShotLength+postShotLength;
            this.preLength = preShotLength;
            this.angle = angle;
        }

        protected void initialize() {
            catapult.setLock(true);
            catapult.setPressurized(true);
        }

        protected void execute() {
           double offset = Constants.getConstants().get("DRIVETRAIN_DRIVESTRAIGHT_P")*(drivetrain.getAngle()-angle);
           drivetrain.setMotorSpeeds(-(1+offset), -(1+offset));
           if ( drivetrain.getAverageDistance() >= preLength )
           {
               catapult.setLock(false);
           }
        }

        protected boolean isFinished() {
           return drivetrain.getAverageDistance() >= driveDistance;
        }

        protected void end() {
            drivetrain.setMotorSpeeds(0, 0);
            catapult.setPressurized(false);
        }
    }
    
    public AutoRunningShot(double preShotLength, double postShotLength, double targetAngle)
    {
        addSequential(new LockCatapult());
        addSequential(new AutoRunningShot_run(preShotLength, postShotLength, targetAngle));
    }
    
}
