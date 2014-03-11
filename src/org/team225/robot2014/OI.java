
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014;

import org.team225.robot2014.constants.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team225.robot2014.commands.catapult.CloseShot;
import org.team225.robot2014.commands.catapult.FarShot;
import org.team225.robot2014.commands.catapult.TrussShot;
import org.team225.robot2014.commands.catcher.Catch;
import org.team225.robot2014.commands.catcher.OpenCatcher;
import org.team225.robot2014.commands.intake.Collect;
import org.team225.robot2014.commands.intake.DragBall;
import org.team225.robot2014.commands.intake.HoldBall;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.Pass;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.StowWithBall;
import org.team225.robot2014.coprocessors.ArduinoCommunications;

/**
 *
 * @author Andrew
 */
public class OI {
    public static Joystick driver = new Joystick(1); // Driver gamepad
    public static Joystick operator = new Joystick(2);
        
    public static void init()
    {
        
        
        new JoystickButton(operator, 2).whenPressed(new Pass());
        
        new JoystickButton(operator, 1).whenPressed(new CloseShot());
        new JoystickButton(operator, 4).whenPressed(new FarShot());
        
        new JoystickButton(operator, 3).whenPressed(new TrussShot());
        new JoystickButton(operator, 9).whenPressed(new MoveArm(false));
        
        new JoystickButton(operator, 7).whenPressed(new OpenCatcher());
        new JoystickButton(operator, 5).whenPressed(new Catch());
        
        new JoystickButton(operator, 8).whenPressed(new Collect());
        new JoystickButton(operator, 6).whenPressed(new StowWithBall());
        
        new JoystickButton(operator, 11).whenPressed(new HoldBall());
        
        new JoystickButton(driver, 1).whenPressed(new DragBall());
        
        Button tmp;
        tmp = new AxisButton(operator, 2, -0.5);
        tmp.whenPressed(new SetRollers(true, false, true));
        tmp.whenReleased(new SetRollers(false));
        
        tmp = new AxisButton(operator, 2, 0.5);
        tmp.whenPressed(new SetRollers(true, true, true));
        tmp.whenReleased(new SetRollers(false));
    }
    
    static boolean notifyWasPressed = false;
    
    public static void poll()
    {
        if ( driver.getRawButton(1) )
        {
            CommandBase.arduComm.set(ArduinoCommunications.NOTIFY);
            notifyWasPressed = true;
        }
        else if ( notifyWasPressed )
        {
            CommandBase.arduComm.set(ArduinoCommunications.IDLE);
            notifyWasPressed = false;
        }
    }
}
