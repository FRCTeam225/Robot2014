/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team225.robot2014.commands.catapult.Launch;
import org.team225.robot2014.commands.intake.Collect;
import org.team225.robot2014.commands.intake.Eject;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.Stow;

/**
 *
 * @author Andrew
 */
public class OI {
    public static Joystick driver = new Joystick(1); // Driver gamepad
    public static Joystick operator = new Joystick(2);
    
    public static void init()
    {
        new JoystickButton(driver, 1).whenPressed(new SetRollers(true));
        new JoystickButton(driver, 3).whenPressed(new SetRollers(false));
        new AxisButton(driver, 6, 0.5).whenPressed(new Collect());
        new AxisButton(driver, 6, -0.5).whenPressed(new Stow());
        new AxisButton(driver, 5, -0.5).whenPressed(new Eject());
        //new JoystickButton(driver, 1).whenPressed(new Launch(true, true));
        //new JoystickButton(driver, 2).whenPressed(new Launch(false, true));
        //new JoystickButton(driver, 3).whenPressed(new Launch(true, false));
        //new JoystickButton(driver, 4).whenPressed(new Launch(false, false));
    }
}
