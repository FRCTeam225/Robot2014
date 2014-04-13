/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.commands.intake.SetRollers;

/**
 *
 * @author Andrew
 */
public class AutoCatch extends CommandGroup {
    
    boolean triggeredAtStart = false;
    
    public AutoCatch()
    {
        this.initialize();
        addSequential(new SetRollers(false));
        addSequential(new SetCatcher(true));
        addSequential(new MoveArm(MoveArm.ARM_OUT));
        addSequential(new WaitForBall());
    }
    
    public void initialize()
    {
        triggeredAtStart = CommandBase.catcher.hasBall();
        super.initialize();
    }
    
    public void end()
    {
        if ( !triggeredAtStart )
        {
            CommandBase.intake.setRoller(0);
            CommandBase.intake.setAngle(false);
            CommandBase.catcher.setDeployed(false);
        }
        super.end();
    }
    
    public void interrupted()
    {
        if ( !triggeredAtStart )
        {
            CommandBase.intake.setRoller(0);
            CommandBase.intake.setAngle(false);
            CommandBase.catcher.setDeployed(false);
        }
        super.interrupted();
    }
    
}
