/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {

    Talon roller;
    Solenoid angle;
    AnalogChannel anglePot;
    
    public Intake()
    {
        roller = new Talon(PortMap.COLLECTOR_ROLLER);
        angle = new Solenoid(PortMap.COLLECTOR_ANGLE);
        anglePot = new AnalogChannel(PortMap.COLLECTOR_ANGLE_POT);
    }
    
    public boolean isDown()
    {
        return anglePot.getValue() > Constants.getConstants().getInt("ARM_DOWN_THRESH");
    }
    
    public void setAngle(boolean down)
    {
        angle.set(down);
    }
    
    public void setRoller(boolean state, boolean reverse)
    {
        setRoller(state, reverse, false);
    }
    
    public void setRoller(boolean state, boolean reverse, boolean slow)
    {
        if (state)
        {
            if ( reverse )
            {
                if ( slow )
                    roller.set(-0.5);
                else
                    roller.set(-1);
            }
            else
            {
                if ( slow )
                    roller.set(0.5);
                else
                    roller.set(1);
            }
                
        }
        else
        {
            roller.set(0);
        }

    }
    
    public double getArmPot()
    {
        return anglePot.getValue();
    }
    
    protected void initDefaultCommand() {
    }
    
}
