/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.intake.AutoCenter;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class PrepFire extends CommandGroup {

    private class WatchBall extends AutoCenter {
        int loopsHas = 0;
        boolean has = true;
        boolean newState = false;
        public WatchBall() {
            requires(intake);
        }

        protected void initialize() {
           
        }

        protected void execute() {
            /*
            //super.execute();
            
            if ( newState == intake.hasBall() )
            {
                loopsHas++;
            }
            else
            {
                newState = intake.hasBall();
                loopsHas = 0;
            }
            
            if ( (loopsHas > 5 && newState) || (loopsHas > 10 && !newState) )
                has = newState;

            intake.setAngle(has, false);
            */
        }

        protected boolean isFinished() {
            return false;
        }

        protected void end() {
            super.end();
        }
    }

    public PrepFire() {
        requires(CommandBase.catapult);
        addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
        addSequential(new LockCatapult());
    }

}
