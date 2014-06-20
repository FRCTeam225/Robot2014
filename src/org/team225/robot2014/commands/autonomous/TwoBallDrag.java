/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catapult.presets.LowPowerShot;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.drivetrain.DriveWhileCollecting;
import org.team225.robot2014.commands.drivetrain.DriveWhileHolding;
import org.team225.robot2014.commands.intake.CollectUntilBall;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class TwoBallDrag extends CommandGroup {
    Timer t = new Timer();
    public TwoBallDrag()
    {  
        addSequential(new DriveDistance(4000));
        addSequential(new HighPowerShot());
        addSequential(new MoveArm(true));
        addSequential(new WaitCommand(1.4));
        addSequential(new DriveWhileCollecting(-1830));
        addSequential(new CollectUntilBall());
        addSequential(new SetRollers(false, false));
        addSequential(new MoveArm(false));
        addSequential(new WaitCommand(0.3));
        addSequential(new DriveWhileHolding(4000));
        addSequential(new WaitForBall());
        addSequential(new HighPowerShot());
    }
    
    public void initialize()
    {
        t.reset();
        t.start();
    }
    
    public void end()
    {
        super.end();
        System.out.println("Auto ended at "+t.get());
        CommandBase.intake.setAngle(false);
        CommandBase.intake.setRoller(0);
    }
    
    
    public void interrupted()
    {
        super.interrupted();
        System.out.println("Auto ended at "+t.get());
        CommandBase.intake.setAngle(false);
        CommandBase.intake.setRoller(0);
    }
    
}
