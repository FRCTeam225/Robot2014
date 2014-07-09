package org.team225.robot2014.commands.catapult;

/**
 *
 * @author Andrew
 */
public class InterruptFireing extends CatapultCommandSafetyWrapper {

    public InterruptFireing()
    {
        requires(catapult);
        requires(intake);
        setTimeout(0.2);
    }
    
    protected void initialize() {
        catapult.setPressurized(false);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        catapult.setPressurized(false);
        catapult.setLock(false);
        intake.setAngle(false);
    }
    
}
