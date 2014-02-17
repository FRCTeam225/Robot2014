/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class PowerSavingCompressor extends CommandBase {

    Timer t = new Timer();
    
    double avgVoltage = 0;
    boolean isLowVoltageLimited = false;
    int timesVoltageLimited = 0;
    
    Timer evaluateTimer = new Timer();
    double evaluateAfter = 5;
    
    DriverStation ds = DriverStation.getInstance();
    public PowerSavingCompressor()
    {
        requires(compressor);
    }
    
    protected void initialize() {
        avgVoltage = ds.getBatteryVoltage();
    }

    protected void execute() {
        double curVoltage = ds.getBatteryVoltage();
        if ( curVoltage > avgVoltage )
            avgVoltage = curVoltage*0.25+avgVoltage*0.75;
        else
            avgVoltage = curVoltage*0.5+avgVoltage*0.5;
        
        if ( avgVoltage < 10 && !isLowVoltageLimited )
        {
            isLowVoltageLimited = true;
            timesVoltageLimited++;
            evaluateTimer.reset();
            evaluateTimer.start();
        }
        
        if ( timesVoltageLimited > 10 )
            isLowVoltageLimited = false;
            
        
        if ( isLowVoltageLimited && evaluateTimer.get() > evaluateAfter && avgVoltage > 10 )
        {
            evaluateTimer.stop();
            isLowVoltageLimited = false;
        }
        
        if ( drivetrain.isLowGear() || isLowVoltageLimited )
            compressor.set(false);
        else
            compressor.set(compressor.isLow());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        compressor.set(false);
    }
    
}
