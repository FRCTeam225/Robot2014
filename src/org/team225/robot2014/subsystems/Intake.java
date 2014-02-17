/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2014.Constants;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {

    Talon roller;
    Talon angleA;
    Talon angleB;
    AnalogChannel anglePot;
    PIDController anglePID;
    
    public Intake()
    {
        roller = new Talon(PortMap.COLLECTOR_ROLLER);
        angleA = new Talon(PortMap.COLLECTOR_ANGLE_A);
        angleB = new Talon(PortMap.COLLECTOR_ANGLE_B);
        anglePot = new AnalogChannel(PortMap.COLLECTOR_ANGLE_POT);
        
        anglePID = new PIDController(0.01, 0, 0.01, anglePot, new PIDOutput() 
        {
            public void pidWrite(double value)
            {
                angleA.set(-value);
                angleB.set(value);
            }
        });
        
        anglePID.enable();
        anglePID.setSetpoint(Constants.ARM_STOW);
        //SmartDashboard.putData("anglePID", anglePID);
        anglePID.setAbsoluteTolerance(100);
    }
    
    public boolean isAtTarget()
    {
        return anglePID.onTarget();
    }
    
    public void setAngle(double setpoint)
    {
        anglePID.setSetpoint(setpoint);
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
