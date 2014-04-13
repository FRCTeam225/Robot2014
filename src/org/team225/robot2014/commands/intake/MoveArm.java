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
    int position = 0;
    boolean waitForMove = false;
    public MoveArm(int position, boolean waitForMove)
    {
        requires(intake);
        this.position = position;
        this.waitForMove = waitForMove;
    }
    
    public MoveArm(boolean position)
    {
        requires(intake);
        this.position = (position?ARM_OUT:ARM_IN);
        this.waitForMove = true;
    }
    
    public MoveArm(int position)
    {
        this(position, true);
    }

    public static int ARM_IN = 0;
    public static int ARM_SHOOTING = 1;
    public static int ARM_OUT = 2;
    
    protected void initialize() {
        if ( position == 0 )
            intake.setAngle(false);
        else if ( position == 1 )
            intake.setAngle(true, false);
        else if ( position == 2 )
            intake.setAngle(true, true);
        else
            System.out.println("MoveArm: position out of range");
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
