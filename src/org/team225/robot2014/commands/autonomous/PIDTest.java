/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.drivetrain.arc.DriveArc;
import org.team225.robot2014.commands.drivetrain.arc.DriveArcWhileCollecting;
import org.team225.robot2014.commands.drivetrain.DriveWhileCollecting;
import org.team225.robot2014.commands.drivetrain.DriveWhileHolding;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class PIDTest extends CommandGroup {
    public PIDTest()
    {
        addSequential(new DriveArc(11000,1,-53));
        addSequential(new HighPowerShot());
        addSequential(new MoveArm(true));
        addSequential(new WaitCommand(1.3));
        addSequential(new DriveArcWhileCollecting(0,1,0));
        addSequential(new DriveWhileCollecting(-2330));
        addSequential(new DriveWhileHolding(5000));
        addSequential(new WaitForBall());
        addSequential(new HighPowerShot());
        
    }
}
