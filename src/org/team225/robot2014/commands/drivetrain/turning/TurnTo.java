package org.team225.robot2014.commands.drivetrain.turning;

import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.commands.SimplePIDCommand;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class TurnTo extends SimplePIDCommand {
    boolean invertIfHot = false;
    double angle = 0;
    public TurnTo(double angle, boolean invertIfHot)
    {
        super(Constants.getConstants().get("DRIVETRAIN_TURN_P"), Constants.getConstants().get("DRIVETRAIN_TURN_I"), Constants.getConstants().get("DRIVETRAIN_TURN_D"));
        pid.setTarget(angle);
        this.angle = angle;
        pid.okError = 2;
        setTimeout(1.0);
        requires(drivetrain);
        this.invertIfHot = invertIfHot;
    }
    
    public TurnTo(double angle)
    {
        this(angle, false);
    }
    
    protected void initialize()
    {
        if ( invertIfHot && AutonomousWrapper.leftIsHot )
            pid.setTarget(-angle);
        super.initialize();
    }
    
    protected double getCurrent() {
        return drivetrain.getAngle();
    }

    protected void setOutput(double value) {
        drivetrain.setMotorSpeeds(value, -value);
    }
    
    public boolean isFinished()
    {
        return super.isFinished() || isTimedOut();
    }
    
}
