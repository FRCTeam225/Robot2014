package org.team225.robot2014.commands.catcher;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class WaitForBall extends CommandBase {

    public WaitForBall()
    {
        requires(catcher);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return catcher.hasBall() || intake.hasBall() || disableSensorWaits;
    }

    protected void end() {
    }
    
}
