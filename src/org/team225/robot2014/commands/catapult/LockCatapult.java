/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class LockCatapult extends CommandBase {

    public LockCatapult()
    {
        requires(catapult);
        setTimeout(0.5);
        setInterruptible(false);
    }
    
    protected void initialize() {
        catapult.setLock(true);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }
    
}
