/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous.jukes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.SimplePID;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catapult.presets.PrepFire;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.StowIntake;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class OneBallJuke extends CommandGroup {
    
    public static class JukeLeftTenDeg extends CommandGroup
    {
        public JukeLeftTenDeg()
        {
            addSequential(new OneBallJuke(15));
        }
    }
    
    public static class JukeRightTenDeg extends CommandGroup
    {
        public JukeRightTenDeg()
        {
            addSequential(new OneBallJuke(-15));
        }
    }
    
    public static class JukeLeftRightTenDeg extends CommandGroup
    {
        public JukeLeftRightTenDeg()
        {
            addSequential(new OneBallJuke(15, -15));
        }
    }
    
    
    protected class JukeOICommand extends CommandBase {
        SimplePID turnPID;
        double aAngle = 0;
        double bAngle = 0;
        
        public JukeOICommand(double aAngle, double bAngle)
        {
            requires(drivetrain);
            this.aAngle = aAngle;
            this.bAngle = bAngle;
            
            Constants c = Constants.getConstants();
            turnPID = new SimplePID(c.get("DRIVETRAIN_TURN_P"), c.get("DRIVETRAIN_TURN_I"), c.get("DRIVETRAIN_TURN_D"));
            turnPID.setTarget(0);
        }

        protected void initialize() {
            
        }

        protected void execute() {
            
            turnPID.setTarget(table.getBoolean("rightHot")?bAngle:aAngle);
            
            double speed = turnPID.calculate(drivetrain.getAngle());
            drivetrain.setMotorSpeeds(speed, -speed);
        }

        protected boolean isFinished() {
            return table.getBoolean("leftHot");
        }

        protected void end() {
            drivetrain.setMotorSpeeds(0, 0);
        }
    }
    
    public OneBallJuke(double bAngle)
    {
        this(0, bAngle);
    }
    
    public OneBallJuke(double aAngle, double bAngle)
    {
        addSequential(new StowIntake());
        addSequential(new DriveDistance(5600));
        addSequential(new PrepFire());
        addSequential(new JukeOICommand(aAngle, bAngle));
        addSequential(new HighPowerShot());
        addSequential(new WaitCommand(2.0));
        addSequential(new MoveArm(false));
    }
}
