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
 * @author KageRa
 */
public class ReleaseCatapult extends CatapultCommandSafetyWrapper{

    boolean bothCylinders;
    public ReleaseCatapult(boolean bothCylinders, double timeDelay){
        requires(catapult);
        this.bothCylinders = bothCylinders;
        setTimeout(timeDelay);
    }
    
    protected void initialize() {
        catapult.setPressurized(true, bothCylinders);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        catapult.setLock(false);
    }
    
}
