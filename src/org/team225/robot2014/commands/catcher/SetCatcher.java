/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catcher;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Collin
 */
public class SetCatcher extends CommandBase {
    
    boolean on;
    
    public SetCatcher(boolean on){
        requires(catcher);
        this.on = on;
    }

    protected void initialize() {
        catcher.setDeployed(on);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
}
