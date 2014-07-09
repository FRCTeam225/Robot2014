package org.team225.robot2014.commands.catcher;

import org.team225.robot2014.commands.intake.AutoCenter;

/**
 *
 * @author Andrew
 */
public class PowerCatch extends AutoCenter.CenterBall {

    boolean alreadyCentered = false;
    
    public PowerCatch()
    {
        super();
        requires(catcher);
    }
    
    protected void initialize()
    {
        alreadyCentered = intake.hasBall();
    }
    
    protected void execute()
    {
        if ( !alreadyCentered )
        {
            super.execute();
            catcher.setDeployed(!catcher.hasBall());
        }
        else
        {
            catcher.setDeployed(true);
        }
    }
    
    protected boolean isFinished()
    {
        if ( alreadyCentered )
            return false;
        else
            return super.isFinished();
    }
    
    protected void end()
    {
        super.end();
        catcher.setDeployed(false);
    }
}
