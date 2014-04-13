/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Andrew
 */
public class StowWithBall extends CommandGroup {
    public StowWithBall()
    {
        addSequential(new SetRollers(false));
        addSequential(new MoveArm(MoveArm.ARM_IN));
    }
}
