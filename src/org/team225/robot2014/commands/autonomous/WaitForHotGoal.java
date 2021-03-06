package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.AutonomousWrapper;

/**
 *
 * @author Andrew
 */
public class WaitForHotGoal extends CommandBase {

    boolean hasHotGoal = false;
    public WaitForHotGoal()
    {
        setTimeout(4.0);
    }
    
    
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut() || !AutonomousWrapper.leftIsHot;
    }

    protected void end() {
    }
    
}
