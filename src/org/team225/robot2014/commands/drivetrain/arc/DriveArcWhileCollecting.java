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
public class DriveArcWhileCollecting extends DriveArc {

    public DriveArcWhileCollecting(double distance, double maxSpeed, double angle) {
        super(distance, maxSpeed, angle);
    }
    
    protected void execute()
    {
        super.execute();
        intake.setAngle(true);
        intake.setRoller(true, false);
    }
    
}
