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
        
    DoubleSolenoid left = new DoubleSolenoid(PortMap.LEFT_CATAPULT_PISTON_A, PortMap.LEFT_CATAPULT_PISTON_B);
    DoubleSolenoid right = new DoubleSolenoid(PortMap.RIGHT_CATAPULT_PISTON_A, PortMap.RIGHT_CATAPULT_PISTON_B);

    DoubleSolenoid lock = new DoubleSolenoid(PortMap.CATAPULT_LATCH_A, PortMap.CATAPULT_LATCH_B);
    
    //DigitalInput armDownLimit = new DigitalInput(PortMap.ARM_DOWN_LIMIT);

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
                left.set(DoubleSolenoid.Value.kForward);
            right.set(DoubleSolenoid.Value.kForward);
        }
        else
        {
            left.set(DoubleSolenoid.Value.kReverse);
            right.set(DoubleSolenoid.Value.kReverse);
        }
    }
    
    
    public void setAngle(boolean high){
        //shift.set(high);
    }
    
    public void setLock(boolean on)
    {
        if ( on )
            lock.set(DoubleSolenoid.Value.kForward);
        else
            lock.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    public boolean armIsDown(){
        return false;
     //   return armDownLimit.get();
    }
    
    
    public void debug()
    {
        if ( OI.driver.getRawButton(1) )
            left.set(DoubleSolenoid.Value.kForward);
        else
            left.set(DoubleSolenoid.Value.kReverse);
        
        if ( OI.driver.getRawButton(2) )
            right.set(DoubleSolenoid.Value.kForward);
        else
            right.set(DoubleSolenoid.Value.kReverse);
         
         if ( OI.driver.getRawButton(3) )
            lock.set(DoubleSolenoid.Value.kForward);
        else
            lock.set(DoubleSolenoid.Value.kReverse);
    }
    
    
}
