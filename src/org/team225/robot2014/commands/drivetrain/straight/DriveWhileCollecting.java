package org.team225.robot2014.commands.drivetrain.straight;


/**
 *
 * @author Andrew
 */
public class DriveWhileCollecting extends DriveDistance {
    public DriveWhileCollecting(double distance, double max)
    {
        super(distance, max);
        requires(intake);
    }
    
    public DriveWhileCollecting(double distance)
    {
        super(distance, 1);
    }
    
    public void initialize()
    {
        super.initialize();
        intake.setAngle(true);
        intake.setRoller(true, false);
    }
    
    public void execute()
    {
        super.execute();
    }
    
    public void end()
    {
        super.end();
    }
}
