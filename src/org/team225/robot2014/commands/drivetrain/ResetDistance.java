/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class ResetDistance extends CommandBase {

    public ResetDistance()
    {
        requires(drivetrain);
    }
    
    protected void initialize() {
        drivetrain.resetDistance();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
}
