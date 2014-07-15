package org.team225.robot2014.commands.intake.presets;

import edu.wpi.first.wpilibj.Timer;
import org.team225.robot2014.commands.intake.MoveArm;

/**
 *
 * @author andrew
 */
public class MoveArmForShooting extends MoveArm {
    Timer t = new Timer();
    
    public MoveArmForShooting()
    {
        super(MoveArm.ARM_SHOOTING, true);
    }
}
