package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;

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
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        intake.setRoller(false,false);
    }
}
