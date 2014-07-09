package org.team225.robot2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.team225.robot2014.commands.drivetrain.straight.DriveDistance;

/**
 *
 * @author Andrew
 */
public class OnlyDriveForward extends CommandGroup {
    public OnlyDriveForward()
    {
        addSequential(new DriveDistance(5000));
    }
}
