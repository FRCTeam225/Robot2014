/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

/**
 *
 * @author Andrew
 */
public class ResetCatapult extends CatapultCommandSafetyWrapper {

    public ResetCatapult()
    {
        requires(catapult);
        setTimeout(0.4);
    }
    
    protected void initialize() {
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
