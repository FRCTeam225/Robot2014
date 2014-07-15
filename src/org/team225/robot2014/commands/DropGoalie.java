/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author andrew
 */
public class DropGoalie extends CommandBase {

    public DropGoalie()
    {
        setTimeout(0.3);
    }
    
    protected void initialize() {
        drivetrain.setAntiTbone(true);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drivetrain.setAntiTbone(false);
    }
}
