package org.team225.robot2014;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.commands.AutonomousWrapper;
import org.team225.robot2014.commands.autonomous.Goalie;
import org.team225.robot2014.commands.autonomous.OneBall;
import org.team225.robot2014.commands.autonomous.OneBallHotGoal;
import org.team225.robot2014.commands.autonomous.TwoBallDrag;
import org.team225.robot2014.commands.autonomous.TwoBallHot;
import org.team225.robot2014.commands.autonomous.jukes.OneBallJuke;

public class Robot2014 extends IterativeRobot {
    
    int selectedAutonomous = 0;
    AutonomousWrapper autonomousOptions[] = {
        new AutonomousWrapper(Goalie.class, "Do nothing", false),
        new AutonomousWrapper(OneBallHotGoal.class, "1B Hot Goal", true),
        new AutonomousWrapper(OneBall.class, "1B Any Goal", false),
        new AutonomousWrapper(TwoBallDrag.class, "2B Any Goal", false),
        new AutonomousWrapper(TwoBallHot.class, "2B Hot Goal", true),
        
        // Jukes
        new AutonomousWrapper(OneBallJuke.JukeLeftTenDeg.class, "1B Juke left 10d", false),
        new AutonomousWrapper(OneBallJuke.JukeRightTenDeg.class, "1B Juke right 10d", false),
        new AutonomousWrapper(OneBallJuke.JukeLeftRightTenDeg.class, "1B Juke +/- 10d", false),
    };
    
    Command autonomousCommand = null;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        OI.init();
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
        System.out.println(CommandBase.drivetrain.getAngle());
    }

    public void teleopInit()
    {
        CommandBase.table.putBoolean("isTeleop", true);
        CommandBase.catapult.setLock(false);
        CommandBase.catapult.setPressurized(false);
        if ( autonomousCommand != null )
            autonomousCommand.cancel();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
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
    
}
