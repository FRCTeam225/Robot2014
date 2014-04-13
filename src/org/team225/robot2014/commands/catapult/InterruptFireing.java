/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

/**
 *
 * @author Andrew
 */
public class InterruptFireing extends CatapultCommandSafetyWrapper {

    public InterruptFireing()
    {
        requires(catapult);
        setTimeout(0.3);
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
    }
    
}
