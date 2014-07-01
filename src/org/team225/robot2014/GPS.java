/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014;

import org.team225.robot2014.subsystems.Drivetrain;

/**
 *
 * @author andrew
 */
public class GPS {
    Drivetrain drivetrain;
    double x = 0, y = 0;
    double lastDistance = 0;
    public GPS()
    {
        drivetrain = CommandBase.drivetrain;
    }
    
    public double getY()
    {
        return y;
    }
    
    public double getX()
    {
        return x;
    }
    
    public void update()
    {
        double displacement = drivetrain.getAverageDistance()-lastDistance;
        lastDistance = drivetrain.getAverageDistance();
        
        y += displacement * Math.cos(Math.toRadians(drivetrain.getAngle()));
        x += displacement * Math.sin(Math.toRadians(drivetrain.getAngle()));
    }
}
