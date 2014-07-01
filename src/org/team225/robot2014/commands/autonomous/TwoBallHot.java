/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.commands.catapult.ResetCatapult;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.drivetrain.DriveDistance;
import org.team225.robot2014.commands.drivetrain.DriveWhileCollecting;
import org.team225.robot2014.commands.drivetrain.DriveWhileHolding;
import org.team225.robot2014.commands.drivetrain.TurnAndFire;
import org.team225.robot2014.commands.drivetrain.TurnTo;
import org.team225.robot2014.commands.intake.AutoCenter;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;
import org.team225.robot2014.commands.intake.StowIntake;

/**
 *
 * @author Andrew
 */
public class TwoBallHot extends CommandGroup {
    Timer t = new Timer();
    public TwoBallHot()
    {
        addSequential(new DriveDistance(5600));
        addSequential(new TurnAndFire(AutonomousWrapper.leftIsHot?-13:13));
        addSequential(new ResetCatapult());
        addSequential(new TurnTo(0));
        addSequential(new MoveArm(true));
        addSequential(new WaitCommand(1.3));

        addSequential(new DriveWhileCollecting(-1650));
        addSequential(new WaitCommand(0.35));
        addSequential(new StowIntake());
        
        addSequential(new DriveWhileHolding(5900));
        addSequential(new AutoCenter());
        addSequential(new WaitForBall());
        addSequential(new TurnAndFire(AutonomousWrapper.leftIsHot?13:-13));
        addSequential(new ResetCatapult());
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
        CommandBase.catapult.setLock(false);
        CommandBase.catapult.setPressurized(false);
    }
    
    
    public void interrupted()
    {
        super.interrupted();
        System.out.println("Auto ended at "+t.get());
        CommandBase.intake.setAngle(false);
        CommandBase.intake.setRoller(0);
        CommandBase.catapult.setLock(false);
        CommandBase.catapult.setPressurized(false);
    }
    
}
