
package org.team225.robot2014.commands.drivetrain;

/**
 *
 * @author andrew
 */
public class AntiTBone extends CheesyDrive {
    protected void initialize()
    {
        drivetrain.shift(true);
        drivetrain.setAntiTbone(true);
    }
    
    protected boolean isFinished()
    {
        return !drivetrain.isLowGear();
    }
    
    protected void end()
    {
        super.end();
        drivetrain.setAntiTbone(false);
    }
    
    protected void interrupted()
    {
        super.interrupted();
        drivetrain.setAntiTbone(false);
    }
}
