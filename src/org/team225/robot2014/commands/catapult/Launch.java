/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author KageRA
 */
public class Launch extends CommandBase{

    public Launch(){
        requires(catapult);
    }
    
    protected void initialize() {
        setTimeout(0.5);
    }

    protected void execute() {
        catapult.setLock(false);
    }

    protected boolean isFinished() {
        return isTimedOut();

    }

    protected void end() {
        catapult.setPressurized(false);
    }
    
}
