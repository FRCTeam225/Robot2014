 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.SimplePID;

/**
 *
 * @author Andrew
 */
public abstract class SimplePIDCommand extends CommandBase {

    protected SimplePID pid;
    double maxError = 0;
    public SimplePIDCommand(double p, double i, double d)
    {
        super();
        pid = new SimplePID(p, i, d);
    }
    
    protected void initialize() {
        
    }

    protected abstract double getCurrent();
    protected abstract void setOutput(double value);
    
    protected void execute() {
        setOutput(pid.calculate(getCurrent()));
    }

    protected boolean isFinished() {
        //return false;
        return pid.atTarget();
    }

    protected void end() {
        setOutput(0);
    }
    
    protected SimplePID getSimplePID()
    {
        return pid;
    }
    
}
