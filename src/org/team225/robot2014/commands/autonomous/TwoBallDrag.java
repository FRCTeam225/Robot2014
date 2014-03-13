/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.commands.catapult.LowPowerShot;
import org.team225.robot2014.commands.drivetrain.DriveWhileDragging;
import org.team225.robot2014.commands.intake.Collect;
import org.team225.robot2014.commands.intake.HoldBall;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.StowWithBall;

/**
 *
 * @author Andrew
 */
public class TwoBallDrag extends CommandGroup {
    public TwoBallDrag()
    {  
        addSequential(new DriveWhileDragging(9250, 0.7));

        addSequential(new SetRollers(-0.3));
        addSequential(new WaitCommand(0.1));
        addSequential(new SetRollers(0));
        
        addSequential(new LowPowerShot());
        addSequential(new WaitCommand(1.8));
        
        addSequential(new Collect());
        addSequential(new WaitCommand(1));
        addSequential(new StowWithBall());        
        addSequential(new HoldBall());
        addSequential(new WaitCommand(0.5));
        addSequential(new LowPowerShot());
        addSequential(new MoveArm(false));
    }
}
