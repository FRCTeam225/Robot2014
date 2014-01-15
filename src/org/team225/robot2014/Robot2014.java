package org.team225.robot2014;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.team225.robot2014.commands.AutonomousWrapper;
import org.team225.robot2014.commands.autonomous.OneBall;
import org.team225.robot2014.commands.autonomous.OneBallHotGoal;
import org.team225.robot2014.commands.autonomous.TwoBall;

public class Robot2014 extends IterativeRobot {
    
    int selectedAutonomous = 0;
    AutonomousWrapper autonomousOptions[] = {
        new AutonomousWrapper(OneBallHotGoal.class, "Wait for hot goal, drive forward and shoot one ball", true),
        new AutonomousWrapper(OneBall.class, "Drive forward and shoot one ball", false),
        new AutonomousWrapper(TwoBall.class, "Shoot preload and other ball behind robot", false),
    };
    
    Command autonomousCommand = null;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
    }

    public void autonomousInit()
    {
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
    
    boolean autoSelectorButtonPress = false;
    public void disabledPeriodic()
    {
        DriverStationLCD dsLCD = DriverStationLCD.getInstance();
        if ( (OI.jsL.getRawButton(5) || OI.jsR.getRawButton(5)) && !autoSelectorButtonPress && selectedAutonomous > 0 )
        {
            dsLCD.clear();
            autoSelectorButtonPress = true;
            selectedAutonomous++;
        }
        if ( (OI.jsL.getRawButton(4) || OI.jsR.getRawButton(4)) && !autoSelectorButtonPress && selectedAutonomous < autonomousOptions.length-1 )
        {
            dsLCD.clear();
            autoSelectorButtonPress = true;
            selectedAutonomous--;
        }
        else
            autoSelectorButtonPress = false;
        
        AutonomousWrapper auto = autonomousOptions[selectedAutonomous];


        dsLCD.println(DriverStationLCD.Line.kUser1, 0, auto.getName());
        dsLCD.println(DriverStationLCD.Line.kUser2, 0, auto.getDescription());
        dsLCD.updateLCD();
            
    }
    
}
