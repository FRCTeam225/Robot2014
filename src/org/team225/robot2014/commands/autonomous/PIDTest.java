/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.presets.LowPowerShot;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.StowWithBall;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class PIDTest extends CommandGroup {
    public PIDTest()
    {
        addSequential(new StowWithBall());
        addSequential(new DriveDistance(5000));
    }
}
