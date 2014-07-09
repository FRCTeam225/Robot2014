package org.team225.robot2014.commands.intake;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author andrew
 */
public class WaitForIntake extends CommandBase {

    public WaitForIntake()
    {
        requires(intake);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return intake.isAbleToFire() || disableSensorWaits;
    }

    protected void end() {
        
    }
    
}
