/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class OI {
    public static Joystick driver = new Joystick(1); // Driver gamepad
    public static void init()
    {
        new JoystickButton(driver, 1).whenPressed(new SetRollers(true));
        new JoystickButton(driver, 2).whenPressed(new SetRollers(false));
    }
    
}
