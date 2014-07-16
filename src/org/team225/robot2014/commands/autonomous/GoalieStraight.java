package org.team225.robot2014.commands.autonomous;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.Robot2014;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author Andrew
 */
public class GoalieStraight extends Goalie {    
    protected boolean shouldFlip()
    {
        return false;
    }
    
    protected double getAngleForLocation(double pos)
    {
        return 0;
    }
}
