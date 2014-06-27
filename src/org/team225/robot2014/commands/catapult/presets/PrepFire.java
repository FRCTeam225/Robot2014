/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.catapult.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.commands.catapult.LockCatapult;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author Andrew
 */
public class PrepFire extends CommandGroup {
    public PrepFire()
    {
        requires(CommandBase.catapult);
        addSequential(new MoveArm(MoveArm.ARM_SHOOTING));
        addSequential(new LockCatapult());
    }
    
    protected void end()
    {
        CommandBase.catapult.setPressurized(true, true);
        super.end();
    }
}
