package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author andrew
 */
public class UpdateHotGoal extends CommandBase {

    boolean done = false;
    boolean left = false, right = true;
    
    protected void initialize() {
        done = false;
    }

    protected void execute() {
        left = table.getBoolean("leftHot");
        right = table.getBoolean("rightHot");
        
        done = (left && !right) || (!left && right);
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
        AutonomousWrapper.leftIsHot = left;
    }
    
}
