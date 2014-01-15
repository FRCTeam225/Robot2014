/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class WaitForHotGoal extends CommandBase {

    protected void initialize() {
        setTimeout(5.0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut() || piComm.getBoolean("hasTarget") || (DriverStation.getInstance().getMatchTime() > 5);
    }

    protected void end() {
    }
    
}
