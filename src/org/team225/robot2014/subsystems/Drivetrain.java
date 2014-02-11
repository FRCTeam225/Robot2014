/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
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
    
    DoubleSolenoid shifter;
    
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
        
        shifter = new DoubleSolenoid(PortMap.SHIFT_PISTON_A, PortMap.SHIFT_PISTON_B);
    }
    
    public void resetAngle()
    {
        gyro.reset();
    }
    
    public void resetGyro()
    {
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
        if ( lowGear )
            shifter.set(DoubleSolenoid.Value.kForward);
        else
            shifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new CheesyDrive());
    }
    
}
