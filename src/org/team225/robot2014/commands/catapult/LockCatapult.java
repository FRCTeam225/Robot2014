package org.team225.robot2014.commands.catapult;

/**
 *
 * @author Andrew
 */
public class LockCatapult extends CatapultCommandSafetyWrapper {

    boolean isAlreadyLocked = false;
    
    public LockCatapult()
    {
        requires(catapult);
        setTimeout(0.1);
    }
    
    protected void initialize() {
        isAlreadyLocked = catapult.isLocked();
        catapult.setLock(true);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut() || isAlreadyLocked;
    }

    protected void end() {
    }
    
}
