package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.AutonomousWrapper;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.presets.HighPowerShot;
import org.team225.robot2014.commands.catcher.WaitForBall;
import org.team225.robot2014.commands.drivetrain.straight.DriveWhileCollecting;
import org.team225.robot2014.commands.drivetrain.turning.TurnTo;
import org.team225.robot2014.commands.drivetrain.arc.DriveArc;
import org.team225.robot2014.commands.drivetrain.arc.DriveArcWhileCollecting;
import org.team225.robot2014.commands.drivetrain.arc.DriveArcWhileHolding;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class TwoBallHotRight extends CommandGroup {
    Timer t = new Timer();
    
    public class do_RightHotFirst extends CommandGroup
    {
        public do_RightHotFirst()
        {
            addSequential(new DriveArcWhileHolding(4400, 1, -5));
            addSequential(new HighPowerShot());
            addSequential(new MoveArm(true));
            addSequential(new TurnTo(0) {
                public boolean isFinished()
                {
                    return this.timeSinceInitialized() > 1.3;
                }
            });
            addSequential(new DriveWhileCollecting(-2730));
            addSequential(new WaitCommand(0.35));
            addSequential(new DriveArcWhileHolding(11000,1,-48));
            addSequential(new WaitForBall());
            addSequential(new HighPowerShot());
        }
    }
    
    public class do_LeftHotFirst extends CommandGroup
    {
        public do_LeftHotFirst()
        {
            addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
            addSequential(new DriveArc(11000,1,-53));
            addSequential(new HighPowerShot());
            addSequential(new MoveArm(true));
            addSequential(new WaitCommand(1.3));
            addSequential(new DriveArcWhileCollecting(0,1,0));
            addSequential(new DriveWhileCollecting(-2330));
            addSequential(new DriveArcWhileHolding(4400, 1, -5));
            addSequential(new WaitForBall());
            addSequential(new HighPowerShot());
        }
    }
    
    
    public TwoBallHotRight()
    {
        if ( AutonomousWrapper.leftIsHot )
          addSequential(new do_LeftHotFirst());
        else
        addSequential(new do_RightHotFirst());
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
        System.out.println("Auto interrupted at "+t.get());
        CommandBase.intake.setAngle(false);
        CommandBase.intake.setRoller(0);
        CommandBase.catapult.setLock(false);
        CommandBase.catapult.setPressurized(false);
    }
}
