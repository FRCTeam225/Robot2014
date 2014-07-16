
package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.OI;

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
        return !drivetrain.isLowGear() || OI.driver.getRawButton(5) || OI.driver.getRawButton(7);
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
