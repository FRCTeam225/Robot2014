/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.autonomous.OneBall;

/**
 *
 * @author Andrew
 */
public class AutonomousWrapper {
    Class autonomous = null;
    String description = "";
    boolean caresAboutHotGoal = false;
    static boolean startingGoalIsHot = false;
    
    public AutonomousWrapper(Class autonomous, String description, boolean caresAboutHotGoal)
    {
        this.autonomous = autonomous;
        
        if ( description == null )
            this.description = autonomous.getName();
        else 
            this.description = description;
        
        this.caresAboutHotGoal = caresAboutHotGoal;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Command start()
    {   
        if ( caresAboutHotGoal )
        {
            Timer.delay(0.5);
            AutonomousWrapper.startingGoalIsHot = CommandBase.piComm.getBoolean("hasTarget");
        }
        
        Command command = null;
        try
        {
            command = (Command) autonomous.newInstance(); 
        } catch (Exception e) {
            System.out.println("Failed to start command, falling back to OneBall");
            command = new OneBall();
        }
        command.start();
        return command;
    }
}
