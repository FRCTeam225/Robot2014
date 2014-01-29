/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {

    Talon roller = new Talon(PortMap.COLLECTOR_ROLLER);
    Talon angle = new Talon(PortMap.COLLECTOR_ANGLE);
    AnalogChannel anglePot = new AnalogChannel(PortMap.COLLECTOR_ANGLE_POT);
    PIDController anglePID = new PIDController(0, 0, 0, anglePot, angle);
    
    public Intake()
    {
        anglePID.enable();
    }
    
    public boolean isAtTarget()
    {
        return anglePID.onTarget();
    }
    
    public void setAngle(double setpoint)
    {
        anglePID.setSetpoint(setpoint);
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
