package org.team225.robot2014.commands.drivetrain.turning;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Andrew
 */
public class TurnAndFire extends TurnTo {

    public TurnAndFire(double angle, boolean invertIfHot)
    {
        super(angle, invertIfHot);
        requires(catapult);
        setTimeout(0.5);
    }
    
    public TurnAndFire(double angle)
    {
        this(angle, false);
    }
    
    public void initialize()
    {
        super.initialize();
        catapult.setLock(true);
        intake.setAngle(true, false);
        Timer.delay(0.1); // this should be removed at some point
        catapult.setPressurized(true);
    }
    
    protected double getCurrent() {
        return drivetrain.getAngle();
    }

    protected void setOutput(double value) {
        drivetrain.setMotorSpeeds(value, -value);
    }
    
    public boolean isFinished()
    {
        return super.isFinished() && isTimedOut();
    }
    
    public void end()
    {
        super.end();
        catapult.setLock(false);
    }
    
}
