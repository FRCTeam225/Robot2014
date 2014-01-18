/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Catapult extends Subsystem {
    
    Solenoid left = new Solenoid(PortMap.LEFT_CATAPULT_PISTON);
    Solenoid right = new Solenoid(PortMap.RIGHT_CATAPULT_PISTON);
    Solenoid shift = new Solenoid(PortMap.SHIFT_CATAPULT_ANGLE);
    Solenoid release = new Solenoid(PortMap.ARM_RELEASE);
    
    public boolean pressurized = false;
    public boolean lockedIn = false;
    public int position = 1;

    protected void initDefaultCommand() {
    }
    
    public void setPressurized(boolean on){
        left.set(on);
        right.set(on);
    }
    
    public void setAngle(boolean high){
        shift.set(high);
    }
    
    public void setLock(boolean on){
        release.set(on);
    }
    
    
    
}
