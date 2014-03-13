/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.drivetrain;


/**
 *
 * @author Andrew
 */
public class DriveWhileDragging extends DriveDistance {
    public DriveWhileDragging(double distance, double max)
    {
        super(distance, max);
        requires(intake);
    }
    
    public DriveWhileDragging(double distance)
    {
        super(distance, 1);
    }
    
    public void initialize()
    {
        super.initialize();
        intake.setAngle(true);
    }
    
    public void execute()
    {
        super.execute();
        if ( !intake.isDraggingBall() )
            intake.setRoller(true, false, true);
        else
            intake.setRoller(false, false);
    }
    
    public void end()
    {
        super.end();
        intake.setRoller(false, false);
    }
}
