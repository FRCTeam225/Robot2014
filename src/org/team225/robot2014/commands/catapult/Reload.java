/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author KageRa
 */
public class Reload extends CommandGroup{
    
    public Reload(){
        addSequential(new Depressurize());
        addSequential(new WaitForArmDown());
        addSequential(new Pressurize());
    }
    
    
}
