/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public class AutomaticCompressor extends CommandBase {

    public AutomaticCompressor()
    {
        requires(compressor);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        compressor.set(compressor.isLow());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        compressor.set(false);
    }
}
