package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 * @author KageRa
 */
public class Catapult extends Subsystem {
        
    DoubleSolenoid left;
    DoubleSolenoid right;

    Solenoid lock;

    boolean flipCylinder= false;
    public Catapult()
    {
        left = new DoubleSolenoid(PortMap.LEFT_CATAPULT_PISTON_A, PortMap.LEFT_CATAPULT_PISTON_B);
        right = new DoubleSolenoid(PortMap.RIGHT_CATAPULT_PISTON_A, PortMap.RIGHT_CATAPULT_PISTON_B);
        lock = new Solenoid(PortMap.CATAPULT_LATCH);
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
    
    public void setLock(boolean on)
    {
        lock.set(on);
    }
    
    public boolean isLocked()
    {
        return lock.get();
    }
    
    public boolean isPressurized()
    {
        return (left.get() == DoubleSolenoid.Value.kForward) || (right.get() == DoubleSolenoid.Value.kForward);
    }
}
