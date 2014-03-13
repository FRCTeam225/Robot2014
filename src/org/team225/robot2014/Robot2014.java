package org.team225.robot2014;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.commands.AutonomousWrapper;
import org.team225.robot2014.commands.autonomous.OneBall;
import org.team225.robot2014.commands.autonomous.OneBallHotGoal;
import org.team225.robot2014.commands.autonomous.TwoBall;
import org.team225.robot2014.commands.autonomous.TwoBallDrag;

public class Robot2014 extends IterativeRobot {
    
    int selectedAutonomous = 0;
    AutonomousWrapper autonomousOptions[] = {
        new AutonomousWrapper(OneBallHotGoal.class, "One Ball Hot Goal", true),
        new AutonomousWrapper(OneBall.class, "One Ball Any Goal", false),
        new AutonomousWrapper(TwoBallDrag.class, "Two Ball Any Goal", false),
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
        CommandBase.catapult.setLock(false);
        autonomousCommand = autonomousOptions[selectedAutonomous].start();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
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
        CommandBase.drivetrain.resetDistance();
        CommandBase.drivetrain.resetAngle();
        
        safeSubsystem(CommandBase.catapult);
    }
    
    public void disabledPeriodic()
    {
        DriverStationLCD dsLCD = DriverStationLCD.getInstance();
        System.out.println(CommandBase.intake.hasBall());
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
        else if ( OI.driver.getRawButton(4) )
        {
            CommandBase.piComm.updateState();
            Timer.delay(0.5);
        }
        
        AutonomousWrapper auto = autonomousOptions[selectedAutonomous];


        dsLCD.println(DriverStationLCD.Line.kUser1, 1, "--Selected Autonomous--");
        dsLCD.println(DriverStationLCD.Line.kUser2, 1, auto.getDescription());
        dsLCD.println(DriverStationLCD.Line.kUser3, 1, "D: "+CommandBase.drivetrain.getAverageDistance());
        dsLCD.println(DriverStationLCD.Line.kUser4, 1, "A: "+CommandBase.drivetrain.getAngle());
        dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Hot Goal: " + (CommandBase.piComm.hasTarget()?"yes":"no")+" ");
        
        dsLCD.updateLCD();
            
    }
    
    
    public void safeSubsystem(Subsystem s)
    {
        Command cmd = s.getCurrentCommand();
        if ( cmd != null )
            cmd.cancel();
    }
    
}
