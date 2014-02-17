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
    boolean reverse = false;
    boolean slow = false;
    
    public SetRollers(boolean state)
    {
        this(state, false);
    }
    
    public SetRollers(boolean state, boolean reverse)
    {
        requires(intake);
        this.state = state;
        this.reverse = reverse;
    }
    
    public SetRollers(boolean state, boolean reverse, boolean slow)
    {
        requires(intake);
        this.state = state;
        this.reverse = reverse;
        this.slow = slow;;
    }

    protected void initialize() {
        intake.setRoller(state, reverse, slow);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
}
