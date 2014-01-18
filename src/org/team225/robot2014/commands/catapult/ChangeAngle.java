/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.catapult;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author KageRA
 */
public class ChangeAngle extends CommandBase{

    boolean high;
    public ChangeAngle(boolean high){
        requires(catapult);
        this.high=high;
    }
    
    protected void initialize() {
        catapult.setAngle(high);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }
    
}
