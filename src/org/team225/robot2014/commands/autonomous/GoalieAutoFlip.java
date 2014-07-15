package org.team225.robot2014.commands.autonomous;

/**
 *
 * @author Andrew
 */
public class GoalieAutoFlip extends Goalie {
    protected boolean shouldFlip()
    {
        return drivetrain.getAverageDistance() <= angleMap[0][0];
    }
    
}
