/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.intake;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class DragBall extends CommandBase {

    public DragBall()
    {
        requires(intake);
    }
    
    protected void initialize() {
        intake.setAngle(true);
    }

    protected void execute() {
        if ( !intake.isDraggingBall() )
            intake.setRoller(true, false);
        else
            intake.setRoller(false, false);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        intake.setRoller(false, false);
        intake.setAngle(false);
    }
    
}
