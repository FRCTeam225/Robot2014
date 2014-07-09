/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class AutoCenter extends CommandGroup {

    public static class CenterBall extends CommandBase {
        public CenterBall()
        {
            requires(intake);
        }

        protected void initialize() {
            intake.setAngle(false);
        }

        protected void execute() {
                if ( !intake.hasBall() && !intake.isAbleToFire() )
                    intake.setRoller(true, true, true);
                else
                    intake.setRoller(false, false);
        }

        protected boolean isFinished() {
            return intake.hasBall();
        }

        protected void end() {
            intake.setRoller(false, false);
        }
    }
    
    
    
    public AutoCenter(boolean tapDown)
    {
        addSequential(new CenterBall());
        if ( tapDown )
        {
            addSequential(new WaitCommand(0.1));
            addSequential(new SetRollers(true, true, false));
            addSequential(new WaitCommand(0.05));
            addSequential(new SetRollers(false, false, false));
        }
    }
    
    
    public AutoCenter()
    {
        this(false);
    }
    
}
