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
public class MoveArm extends CommandBase {
    boolean position = false;
    boolean waitForMove = false;
    public MoveArm(boolean position, boolean waitForMove)
    {
        requires(intake);
        this.position = position;
        this.waitForMove = waitForMove;
    }
    
    public MoveArm(boolean position)
    {
        this(position, true);
    }

    protected void initialize() {
        intake.setAngle(position);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
        /*
        if ( !waitForMove )
            return false;
        
        if ( position )
            return intake.isDown();
        else
            return !intake.isDown();*/
    }

    protected void end() {
    }
    
}
