/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.drivetrain.arc;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.catapult.ResetCatapult;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author andrew
 */
public class DriveArcWhileShooting extends CommandGroup {
    
    private class doDriveArcWhileShooting extends DriveArc {
        public doDriveArcWhileShooting(double distance, double maxSpeed, double angle) {
            super(distance, maxSpeed, angle);
        }

        protected void initialize()
        {
            super.initialize();
            catapult.setPressurized(true, true);
            intake.setAngle(true, false);
        }
        
        protected void end()
        {
            catapult.setLock(false);
        }
    }
    
    public DriveArcWhileShooting(double distance, double maxSpeed, double angle)
    {
        addSequential(new LockCatapult());
        addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
        addSequential(new doDriveArcWhileShooting(distance, maxSpeed, angle));
        addSequential(new ResetCatapult());
    }
    
}
