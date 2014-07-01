/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.intake.AutoCenter;

/**
 *
 * @author Andrew
 */
public class PowerCatch extends AutoCenter {

    public PowerCatch()
    {
        super();
        requires(catcher);
    }
    
    protected void execute()
    {
        super.execute();
        catcher.setDeployed(!catcher.hasBall());
    }
    
    protected void end()
    {
        super.end();
        catcher.setDeployed(false);
    }
}
