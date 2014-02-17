 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import org.team225.robot2014.OI;
import org.team225.robot2014.PortMap;

/**
 *
 * @author KageRa
 */
public class Catapult extends Subsystem {
        
    DoubleSolenoid left;
    DoubleSolenoid right;

    Solenoid lock;
    Solenoid angle;

    boolean flipCylinder= false;
    public Catapult()
    {
        left = new DoubleSolenoid(1, PortMap.LEFT_CATAPULT_PISTON_A, PortMap.LEFT_CATAPULT_PISTON_B);
        right = new DoubleSolenoid(1, PortMap.RIGHT_CATAPULT_PISTON_A, PortMap.RIGHT_CATAPULT_PISTON_B);
        lock = new Solenoid(2, PortMap.CATAPULT_LATCH);
        angle = new Solenoid(2, PortMap.CATAPULT_ANGLE);
    }
    
    protected void initDefaultCommand() {
    }
    
    public void setPressurized(boolean on)
    {
        this.setPressurized(on, true);
    }
    
    public void setPressurized(boolean on, boolean both)
    {
        if ( on )
        {
            if ( both )
            {
                left.set(DoubleSolenoid.Value.kForward);
                right.set(DoubleSolenoid.Value.kForward);
            }
            else
            {
                if (flipCylinder)
                {
                    right.set(DoubleSolenoid.Value.kForward);
                    flipCylinder = false;
                }
                else
                {
                    left.set(DoubleSolenoid.Value.kForward);
                    flipCylinder = true;
                }
            }
        }
        else
        {
           left.set(DoubleSolenoid.Value.kReverse);
           right.set(DoubleSolenoid.Value.kReverse);
        }
    }
    
    
    public void setAngle(boolean lowArc){
        angle.set(lowArc);
    }
    
    public void setLock(boolean on)
    {
        lock.set(!on);
    }
}
