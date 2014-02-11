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
public class ResetCatapult extends CommandBase {

    public ResetCatapult()
    {
        requires(catapult);
        setTimeout(2.0);
        setInterruptible(false);
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
