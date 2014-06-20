/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.catcher.WaitForBall;

/**
 *
 * @author Andrew
 */
public class CollectUntilBall extends CommandGroup {
    public CollectUntilBall()
    {
        addSequential(new MoveArm(MoveArm.ARM_OUT));
        addSequential(new SetRollers(true, false));
        addSequential(new WaitForBall());
    }
}
