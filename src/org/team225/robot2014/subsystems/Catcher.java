/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Collin
 */
public class Catcher extends Subsystem {
    
    Solenoid catcher;
    public Catcher()
    {
        catcher = new Solenoid(PortMap.CATCHER_PISTON);
    }
    protected void initDefaultCommand() {
    }
    
    public void setDeployed(boolean on){
        catcher.set(on);
    }
}
