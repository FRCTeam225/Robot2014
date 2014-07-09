/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;
import org.team225.robot2014.commands.drivetrain.CheesyDrive;

/**
 *
 * @author Andrew
 */
public class Drivetrain extends Subsystem {

    Talon[] left = {null, null, null};
    Talon[] right = {null, null, null};
    
    Encoder leftEncoder;
    Encoder rightEncoder;
    
    Gyro gyro;
    
    Solenoid shifter;
    Relay antiTbone;
    
    boolean lowGear = false;
    
    public Drivetrain()
    {
        left[0] = new Talon(PortMap.LEFT_DRIVE1);
        left[1] = new Talon(PortMap.LEFT_DRIVE2);
        left[2] = new Talon(PortMap.LEFT_DRIVE3);

        right[0] = new Talon(PortMap.RIGHT_DRIVE1);
        right[1] = new Talon(PortMap.RIGHT_DRIVE2);
        right[2] = new Talon(PortMap.RIGHT_DRIVE3);
        
        gyro = new Gyro(PortMap.GYRO);
        leftEncoder = new Encoder(PortMap.LEFT_ENCODERA, PortMap.LEFT_ENCODERB);
        rightEncoder = new Encoder(PortMap.RIGHT_ENCODERA, PortMap.RIGHT_ENCODERB, true);
        
        leftEncoder.start();
        rightEncoder.start();
        
        shifter = new Solenoid(PortMap.SHIFT_PISTON);
        antiTbone = new Relay(PortMap.ANTI_TBONE);
    }
    
    public void resetAngle()
    {
        gyro.reset();
    }
    
    public void resetGyro()
    {
        gyro.free();
        gyro = new Gyro(PortMap.GYRO);
    }
    
    public double getAngle()
    {
        return gyro.getAngle();
    }
    
    public double getLeftDistance()
    {
        return leftEncoder.getDistance();
    }
    
    public double getRightDistance()
    {
        return rightEncoder.getDistance();
    }
    
    public double getAverageDistance()
    {
        return (getLeftDistance()+getRightDistance())/2;
    }
    
    public void resetDistance()
    {
        rightEncoder.reset();
        leftEncoder.reset();
    }
    
    public void setMotorSpeeds(double left, double right)
    {
        setLeftSpeed(left);
        setRightSpeed(right);
    }
    
    public void setLeftSpeed(double speed)
    {
        for ( int i = 0; i < left.length; i++ )
        {
            left[i].set(speed);
        }
    }
    
    public void setRightSpeed(double speed)
    {
        for ( int i = 0; i < right.length; i++ )
        {
            right[i].set(-speed);
        }
    }
    
    public void shift(boolean lowGear)
    {
        shifter.set(lowGear);
        this.lowGear = lowGear;
    }
    
    public boolean isLowGear()
    {
        return lowGear;
    }
    
    public void setAntiTbone(boolean state)
    {
        antiTbone.set(state?Relay.Value.kForward:Relay.Value.kOff);
    }
    
    public boolean getAntiTboneDown()
    {
        return antiTbone.get() == Relay.Value.kForward;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new CheesyDrive());
    }
    
}
