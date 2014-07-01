/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {

    Talon roller;
    Relay angle;
    Relay fullDeploy;
    AnalogChannel anglePot;
    DigitalInput ballSensor;
    
    public Intake()
    {
        roller = new Talon(PortMap.COLLECTOR_ROLLER);
        
        angle = new Relay(PortMap.COLLECTOR_ANGLE);
        fullDeploy = new Relay(PortMap.COLLECTOR_ANGLE_FULL);
        
        
        anglePot = new AnalogChannel(PortMap.COLLECTOR_ANGLE_POT);
        ballSensor = new DigitalInput(PortMap.COLLECTOR_BALL_SENSOR);
    }
    
    public boolean isDown()
    {
        return (angle.get() == Relay.Value.kForward || fullDeploy.get() == Relay.Value.kForward);
    }
    
    public boolean getAngle()
    {
        return angle.get() == Relay.Value.kForward;
    }
    
    public void setAngle(boolean firstStage, boolean secondStage)
    {
        angle.set((firstStage?Relay.Value.kForward:Relay.Value.kOff));
        fullDeploy.set((secondStage?Relay.Value.kForward:Relay.Value.kOff));
    }
    
    public void setAngle(boolean state)
    {
        setAngle(state, state);
    }
    
    public boolean hasBall()
    {
        return !ballSensor.get();
    }
    
    public void setRoller(double speed)
    {
        roller.set(speed);
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
                    roller.set(-0.3);
                else
                    roller.set(-1);
            }
            else
            {
                if ( slow )
                    roller.set(0.3);
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
    
    public boolean isAbleToFire()
    {
        return getArmPot() <= 713;
    }

    protected void initDefaultCommand() {
    }
    
}
