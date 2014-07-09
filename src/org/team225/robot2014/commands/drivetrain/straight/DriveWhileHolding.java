package org.team225.robot2014.commands.drivetrain.straight;


/**
 *
 * @author Andrew
 */
public class DriveWhileHolding extends DriveDistance {
    public DriveWhileHolding(double distance, double max)
    {
        super(distance, max);
        requires(intake);
    }
    
    public DriveWhileHolding(double distance)
    {
        super(distance, 1);
    }
    
    public void initialize()
    {
        super.initialize();
        intake.setAngle(false);
    }
    
    public void execute()
    {
        super.execute();
        if ( !intake.hasBall() )
            intake.setRoller(true, true, true);
        else
            intake.setRoller(false, false);
    }
    
    public void end()
    {
        super.end();
        intake.setRoller(false, false);
    }
}
