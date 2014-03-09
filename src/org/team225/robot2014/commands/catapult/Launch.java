/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class Launch extends CommandGroup {
    public Launch(boolean latch, boolean bothCylinders, double timeDelay)
    {
        addSequential(new MoveArm(Constants.getConstants().getInt("ARM_SHOOT")));
        if ( latch )
            addSequential(new LockCatapult());
        addSequential(new ReleaseCatapult(bothCylinders, timeDelay));
        addSequential(new ResetCatapult());
    }
}
