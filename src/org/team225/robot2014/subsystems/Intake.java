/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {

    Talon roller = new Talon(PortMap.COLLECTOR_ROLLER);
    
    public Intake()
    {
        
    }
    
    public void setRoller(boolean state)
    {
        if (state)
        {
            roller.set(1);
        }
        else
        {
            roller.set(0);
        }

    }
    
    protected void initDefaultCommand() {
    }
    
}
