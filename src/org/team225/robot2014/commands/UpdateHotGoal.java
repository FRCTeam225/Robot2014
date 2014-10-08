
package org.team225.robot2014.commands;

import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author andrew
 */
public class UpdateHotGoal extends CommandBase {

    boolean done = false;
    boolean left = false, right = false;
    
    public UpdateHotGoal()
    {
        setTimeout(0.5);
    }
    
    
    protected void initialize() {
        done = false;
    }

    protected void execute() {
        left = CommandBase.table.getBoolean("leftHot");
        right = CommandBase.table.getBoolean("rightHot");
        if ( (left && !right) || (!left && right) )
            done = true;
    }

    protected boolean isFinished() {
        return done || isTimedOut();
    }

    protected void end() {
        AutonomousWrapper.leftIsHot = left;
    }
    
}
