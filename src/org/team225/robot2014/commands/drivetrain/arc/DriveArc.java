package org.team225.robot2014.commands.drivetrain.arc;

import org.team225.robot2014.commands.drivetrain.straight.DriveDistance;

/**
 *
 * @author andrew
 */
public class DriveArc extends DriveDistance {

    double stepPerTick = 0;
    protected double targetAngle = 0;
    double startingDistance = 0;
    double startingAngle = 0;
    public DriveArc(double distance, double maxSpeed, double angle) {
        super(distance, maxSpeed, angle);
        this.targetAngle = angle;
    }
    
    protected void initialize()
    {
        super.initialize();
        startingDistance = drivetrain.getAverageDistance();
        startingAngle = drivetrain.getAngle();
        double travelDistance = Math.abs(startingDistance-pid.getTarget());
        stepPerTick = (targetAngle-drivetrain.getAngle())/travelDistance;
    }
    
    protected void execute()
    {
        double travelDistance = Math.abs(drivetrain.getAverageDistance()-startingDistance);
        angle = (travelDistance * stepPerTick) + startingAngle;
        super.execute();
    }
    
}
