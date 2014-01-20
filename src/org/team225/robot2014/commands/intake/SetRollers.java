/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class SetRollers extends CommandBase {
    boolean state = false;
    
    public SetRollers(boolean state)
    {
        this.state = state;
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
}
