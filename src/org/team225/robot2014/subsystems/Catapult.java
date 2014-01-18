/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Andrew
 */
public class Catapult extends Subsystem {
    
    Solenoid left = new Solenoid(1);
    Solenoid right = new Solenoid(2);
    Solenoid shift = new Solenoid(3);
    Solenoid release = new Solenoid(4);
    
    public boolean pressurized = false;
    public boolean lockedIn = false;
    public int position = 1;

    protected void initDefaultCommand() {
    }
    
}
