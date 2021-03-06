package org.team225.robot2014;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.commands.DropGoalie;
import org.team225.robot2014.commands.autonomous.Brick;
import org.team225.robot2014.commands.autonomous.DriveForward;
import org.team225.robot2014.commands.autonomous.Goalie;
import org.team225.robot2014.commands.autonomous.GoalieFlipped;
import org.team225.robot2014.commands.autonomous.GoalieStraight;
import org.team225.robot2014.commands.autonomous.OneBall;
import org.team225.robot2014.commands.autonomous.OneBallHotGoal;
import org.team225.robot2014.commands.autonomous.PinGoalie;
import org.team225.robot2014.commands.autonomous.TwoBallHot;
import org.team225.robot2014.commands.autonomous.TwoBallHotRight;
import org.team225.robot2014.commands.autonomous.TwoBallLinear;
import org.team225.robot2014.commands.autonomous.jukes.OneBallJuke;
import org.team225.robot2014.commands.autonomous.jukes.OneBallJukeArc;
import org.team225.robot2014.commands.autonomous.jukes.TwoBallCenterJuke;
import org.team225.robot2014.constants.Constants;

public class Robot2014 extends IterativeRobot {
    public static boolean wasGoalie = false;
    
    int selectedAutonomous = 0;
    AutonomousWrapper autonomousOptions[] = {        
        new AutonomousWrapper(Brick.class, "Do nothing", false),
        new AutonomousWrapper(DriveForward.class, "Drive Forward", false),
        new AutonomousWrapper(OneBallHotGoal.class, "1B Hot Goal", true),
        new AutonomousWrapper(OneBall.class, "1B Any Goal", false),
        new AutonomousWrapper(TwoBallLinear.class, "2B Any Goal", false),
        new AutonomousWrapper(TwoBallHot.class, "2B Hot Goal", true),
        new AutonomousWrapper(TwoBallHotRight.class, "2B Hot RIGHT", false),
        
        // Jukes
        new AutonomousWrapper(TwoBallCenterJuke.class, "2B Center Juke", false),
        new AutonomousWrapper(OneBallJukeArc.class, "1B Juke Arc", true),
        new AutonomousWrapper(OneBallJuke.JukeLeftTenDeg.class, "1B Juke left 10d", false),
        new AutonomousWrapper(OneBallJuke.JukeRightTenDeg.class, "1B Juke right 10d", false),
        new AutonomousWrapper(OneBallJuke.JukeLeftRightTenDeg.class, "1B Juke +/- 10d", false),
        
        // Goalie
        new AutonomousWrapper(Goalie.class, "GoalieDrive", false),
        new AutonomousWrapper(GoalieFlipped.class, "GoalieFlipped", false),
        new AutonomousWrapper(GoalieStraight.class, "GoalieStraight", false),
        new AutonomousWrapper(PinGoalie.class, "PinGoalie", false)
    };
    
    Command autonomousCommand = null;
    
    Relay readyLight = new Relay(PortMap.READY_LIGHT);
    
    GPS gps;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        Constants.getConstants();
        CommandBase.init();
        OI.init();
        gps = new GPS();
        System.out.println("ROBOT READY!");
    }

    public void autonomousInit()
    {
        CommandBase.table.putBoolean("isTeleop", false);
        safeSubsystem(CommandBase.intake);
        safeSubsystem(CommandBase.catapult);
        
        CommandBase.catapult.setLock(false);
        CommandBase.drivetrain.resetAngle();
        CommandBase.drivetrain.resetDistance();
        CommandBase.intake.setRoller(0);
        
        autonomousCommand = autonomousOptions[selectedAutonomous].start();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
        updateReadyLight();
    }

    public void teleopInit()
    {
        CommandBase.table.putBoolean("isTeleop", true);
        CommandBase.catapult.setLock(false);
        CommandBase.catapult.setPressurized(false);
        if ( autonomousCommand != null )
            autonomousCommand.cancel();
        
        if ( wasGoalie )
            new DropGoalie().start();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        OI.poll();
        updateReadyLight();
        
        //gps.update();
        //System.out.println("("+gps.getX()+","+gps.getY()+")");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
    
    public void disabledInit()
    {
        CommandBase.table.putBoolean("isTeleop", false);
        CommandBase.drivetrain.resetDistance();
        CommandBase.drivetrain.resetAngle();
        
        safeSubsystem(CommandBase.catapult);
    }
    
    public void disabledPeriodic()
    {
        updateReadyLight();
        DriverStationLCD dsLCD = DriverStationLCD.getInstance();

        if ( OI.driver.getRawButton(2) && selectedAutonomous < autonomousOptions.length-1 )
        {
            dsLCD.clear();
            selectedAutonomous++;
            Timer.delay(0.5);
        }
        else if ( OI.driver.getRawButton(1) && selectedAutonomous > 0  )
        {
            dsLCD.clear();
            selectedAutonomous--;
            Timer.delay(0.5);
        }
        else if ( OI.driver.getRawButton(3) )
        {
            CommandBase.drivetrain.resetDistance();
            CommandBase.drivetrain.resetGyro();
            dsLCD.clear();
        }
        
        
        AutonomousWrapper auto = autonomousOptions[selectedAutonomous];
        
        dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Auto");
        dsLCD.println(DriverStationLCD.Line.kUser2, 1, auto.getDescription());
        dsLCD.println(DriverStationLCD.Line.kUser3, 1, "D: "+CommandBase.drivetrain.getAverageDistance());
        dsLCD.println(DriverStationLCD.Line.kUser4, 1, "A: "+CommandBase.drivetrain.getAngle());
        
        boolean leftHot = CommandBase.table.getBoolean("leftHot", false);
        boolean rightHot = CommandBase.table.getBoolean("rightHot", false);
        String hot = "none";
        if ( leftHot && rightHot )
            hot = "both";
        else if ( leftHot )
            hot = "left";
        else if ( rightHot )
            hot = "right";
        dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Hot: "+hot);
        
        dsLCD.updateLCD();
            
    }
    
    
    public void safeSubsystem(Subsystem s)
    {
        Command cmd = s.getCurrentCommand();
        if ( cmd != null )
            cmd.cancel();
    }
    
    public void updateReadyLight()
    {
        boolean ready;
        String reason = "Ready";
        
        if ( CommandBase.catapult.isPressurized() )
            reason = "!!Pressurized!!";
        
        ready = CommandBase.intake.hasBall();
        if ( !ready ) reason = "Ball";
        
        if ( ready && CommandBase.intake.getAngle() ) 
        {
            ready = CommandBase.intake.isAbleToFire();
            if ( !ready ) reason = "Intake";
        }
        
        readyLight.set(ready?Relay.Value.kForward:Relay.Value.kOff);
        
        CommandBase.table.putBoolean("ready", ready);
        CommandBase.table.putString("readyText", reason);
    }
}
