/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Driver1
 */
public class ReportDistance extends CommandBase {

    public ReportDistance()
    {
        requires(drivetrain);
    }
    
    protected void initialize() {
        drivetrain.shift(true);
    }

    protected void execute() {
        System.out.println(drivetrain.getAverageDistance()+" "+drivetrain.getAngle());
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
        drivetrain.shift(false);
    }
    
}
