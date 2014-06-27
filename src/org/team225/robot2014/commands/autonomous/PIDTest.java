/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.SimplePID;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catapult.presets.LowPowerShot;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.drivetrain.TurnTo;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.StowIntake;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class PIDTest extends CommandBase {
    SimplePID turnPID;
    public PIDTest()
    {
        requires(drivetrain);
        Constants c = Constants.getConstants();
        turnPID = new SimplePID(c.get("DRIVETRAIN_TURN_P"), c.get("DRIVETRAIN_TURN_I"), c.get("DRIVETRAIN_TURN_D"));
        turnPID.setTarget(0);
        turnPID.okError = 2;
    }

    protected void initialize() {
        Constants c = Constants.getConstants();
        turnPID = new SimplePID(c.get("DRIVETRAIN_TURN_P"), c.get("DRIVETRAIN_TURN_I"), c.get("DRIVETRAIN_TURN_D"));
        turnPID.setTarget(30);
        turnPID.okError = 2;
    }

    protected void execute() {
        
        double speed = turnPID.calculate(drivetrain.getAngle());
        drivetrain.setMotorSpeeds(speed, -speed);
        System.out.println(turnPID.getError());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.setMotorSpeeds(0, 0);
    }
}
