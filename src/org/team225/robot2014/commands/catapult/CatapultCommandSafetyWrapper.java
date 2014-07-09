package org.team225.robot2014.commands.catapult;

import org.team225.robot2014.CommandBase;

/**
 *
 * @author Andrew
 */
public abstract class CatapultCommandSafetyWrapper extends CommandBase {
    protected void interrupted() 
    {
        catapult.setPressurized(false);
        catapult.setLock(false);
    }
}
