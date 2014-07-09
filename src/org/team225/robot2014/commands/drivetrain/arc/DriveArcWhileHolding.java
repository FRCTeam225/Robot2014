/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.drivetrain.arc;

/**
 *
 * @author andrew
 */
public class DriveArcWhileHolding extends DriveArc {

    public DriveArcWhileHolding(double distance, double maxSpeed, double angle) {
        super(distance, maxSpeed, angle);
    }
    
    public void initialize()
    {
        super.initialize();
        intake.setAngle(false);
    }
    
    protected void execute()
    {
        super.execute();
        if ( !intake.hasBall() )
            intake.setRoller(true, true, true);
        else
            intake.setRoller(false, false);
    }
    
    protected void end()
    {
        super.end();
        intake.setRoller(false, false);
    }
    
}
