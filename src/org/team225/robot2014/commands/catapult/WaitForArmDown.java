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
public class WaitForArmDown extends CommandBase{

    public WaitForArmDown(){
        requires(catapult);
    }
    
    protected void initialize() {

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return catapult.armIsDown();
    }

    protected void end() {

    }
    
}
