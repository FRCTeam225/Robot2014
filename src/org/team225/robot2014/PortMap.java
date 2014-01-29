/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

/**
 *
 * @author Andrew
 */
public class PortMap {
    public static final int AIR_SWITCH = 1; // Digital
    public static final int COMPRESSOR = 1; // Relay
    
    public static final int LEFT_DRIVE1 = 1; // PWM
    public static final int LEFT_DRIVE2 = 2; // PWM
    public static final int LEFT_DRIVE3 = 3; // PWM
    public static final int LEFT_ENCODERA = 2; // Digital
    public static final int LEFT_ENCODERB = 3; // Digital
    
    public static final int RIGHT_DRIVE1 = 4; // PWM
    public static final int RIGHT_DRIVE2 = 5; // PWM
    public static final int RIGHT_DRIVE3 = 6; // PWM
    public static final int RIGHT_ENCODERA = 4; // Digital
    public static final int RIGHT_ENCODERB = 5; // Digital
    
    public static final int SHIFT_PISTON_A = 7;
    public static final int SHIFT_PISTON_B = 8;
    
    public static final int GYRO = 1; // Analog
    
    public static final int LEFT_CATAPULT_PISTON = 1;//Solenoid
    public static final int RIGHT_CATAPULT_PISTON = 2;//Solinoid
    public static final int SHIFT_CATAPULT_ANGLE = 3;//Solenoid
    public static final int ARM_RELEASE = 4;//Solenoid
    
    public static final int ARM_DOWN_LIMIT = 5;//Digital
    
    public static final int CATCHER_LEFT = 5;//Solenoid
    public static final int CATCHER_RIGHT = 6;//Solenoid
    
    public static final int COLLECTOR_ROLLER = 7;
    public static final int COLLECTOR_ANGLE = 8;
    public static final int COLLECTOR_ANGLE_POT = 9;
    
}
