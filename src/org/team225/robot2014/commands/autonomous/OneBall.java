/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.StowIntake;

/**
 *
 * @author Andrew
 */
public class OneBall extends CommandGroup {
    public OneBall()
    {
        addSequential(new StowIntake());
        addSequential(new DriveDistance(5600));
        addSequential(new HighPowerShot());
        addSequential(new WaitCommand(2.0));
        addSequential(new MoveArm(false));
    }
}
