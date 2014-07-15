package org.team225.robot2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team225.robot2014.commands.catapult.InterruptFireing;
import org.team225.robot2014.commands.catapult.presets.HPKick;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catapult.presets.LowPowerShot;
import org.team225.robot2014.commands.catapult.presets.PrepFire;
import org.team225.robot2014.commands.catcher.AutoCatch;
import org.team225.robot2014.commands.catcher.Catch;
import org.team225.robot2014.commands.drivetrain.AntiTBone;
import org.team225.robot2014.commands.intake.AutoCenter;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.presets.Collect;
import org.team225.robot2014.commands.intake.presets.Eject;
import org.team225.robot2014.commands.intake.presets.StowIntake;

/**
 *
 * @author Andrew
 */
public class OI {
    public static Joystick driver = new Joystick(1); // Driver gamepad
    public static Joystick operator = new Joystick(2);
        
    public static void init()
    {
        new JoystickButton(driver, 6).whenPressed(new LowPowerShot());
        new JoystickButton(driver, 8).whenPressed(new PrepFire());
        
        new JoystickButton(driver, 10).whenPressed(new PrepFire());
        new JoystickButton(driver, 11).whenPressed(new PrepFire());
        new JoystickButton(driver, 12).whenPressed(new AntiTBone());
        
        
        new JoystickButton(driver, 9).whenPressed(new InterruptFireing());
        
        new JoystickButton(operator, 2).whenPressed(new Eject());
        new JoystickButton(operator, 3).whenPressed(new HPKick());
        
        new JoystickButton(operator, 1).whenPressed(new HighPowerShot());
        new JoystickButton(operator, 4).whenPressed(new LowPowerShot());

        new JoystickButton(operator, 9).whenPressed(new MoveArm(false));
        
        new JoystickButton(operator, 7).whenPressed(new AutoCatch());
        new JoystickButton(operator, 5).whenPressed(new Catch());
        
        
        new JoystickButton(operator, 8).whenPressed(new Collect());
        new JoystickButton(operator, 6).whenPressed(new StowIntake());
        
        new JoystickButton(operator, 11).whenPressed(new AutoCenter(true));
        
        Button tmp;
        tmp = new AxisButton(operator, 2, -0.5);
        tmp.whenPressed(new SetRollers(true, false, false));
        tmp.whenReleased(new SetRollers(false));
        
        tmp = new AxisButton(operator, 2, 0.5);
        tmp.whenPressed(new SetRollers(true, true, false));
        tmp.whenReleased(new SetRollers(false));    
        
        new AxisButton(operator, 5, 0.5).whenPressed(new AutoCatch());
        new AxisButton(operator, 5, -0.5).whenPressed(new AutoCatch());
        new AxisButton(operator, 6, 0.5).whenPressed(new AutoCatch());
        new AxisButton(operator, 6, -0.5).whenPressed(new AutoCatch());
    }
    
    public static void poll()
    {
        if ( driver.getRawButton(1) )
            CommandBase.disableSensorWaits = true;
    }
}
