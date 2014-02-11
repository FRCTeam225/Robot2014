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

    Talon roller = new Talon(PortMap.COLLECTOR_ROLLER);
    Talon angleA = new Talon(PortMap.COLLECTOR_ANGLE_A);
    Talon angleB = new Talon(PortMap.COLLECTOR_ANGLE_B);
    AnalogChannel anglePot = new AnalogChannel(PortMap.COLLECTOR_ANGLE_POT);
    PIDController anglePID = new PIDController(0.01, 0, 0.01, anglePot, new PIDOutput() 
    {
        public void pidWrite(double value)
        {
            angleA.set(-value);
            angleB.set(value);
        }
    });
    
    public Intake()
    {
        anglePID.enable();
        anglePID.setSetpoint(Constants.ARM_UP);
        SmartDashboard.putData("anglePID", anglePID);
        anglePID.setAbsoluteTolerance(10);
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
        if (state)
        {
            if ( reverse )
                roller.set(-1);
            else
                roller.set(1);
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
