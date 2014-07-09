package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.intake.AutoCenter;

/**
 *
 * @author Andrew
 */
public class PrepFire extends CommandGroup {

    private class WatchBall extends AutoCenter.CenterBall {
        int loopsHas = 0;
        boolean has = true;
        boolean newState = false;
        public WatchBall() {
            requires(intake);
        }

        protected void initialize() {
           
        }

        protected void execute() {
            super.execute();
            
            if ( newState == intake.hasBall() )
            {
                loopsHas++;
            }
            else
            {
                newState = intake.hasBall();
                loopsHas = 0;
            }
            
            if ( (loopsHas > 5 && newState) || (loopsHas > 15 && !newState) )
                has = newState;

            intake.setAngle(has, false);
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
        //addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
        addSequential(new AutoCenter(true));
        addSequential(new LockCatapult());
        setInterruptible(false);
        //addSequential(new WatchBall());
    }
    
    protected void end()
    {
        super.end();
        CommandBase.catapult.setPressurized(true, true);
    }

}
