/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2014.CommandBase;
import org.team225.robot2014.constants.Constants;
import org.team225.robot2014.commands.intake.MoveArm;
import org.team225.robot2014.coprocessors.ArduinoCommunications;

/**
 *
 * @author Andrew
 */
public class Launch extends CommandGroup {
    public Launch(boolean latch, boolean bothCylinders, double timeDelay)
    {
        addSequential(new MoveArm(true));
        addSequential(new WaitCommand(0.5));
        if ( latch )
            addSequential(new LockCatapult());
        addSequential(new ReleaseCatapult(bothCylinders, timeDelay));
        addSequential(new ResetCatapult());
    }
    
    public void initialize()
    {
        CommandBase.arduComm.set(ArduinoCommunications.SHOOTING);
        super.initialize();
    }
    
    public void end()
    {
        CommandBase.arduComm.set(ArduinoCommunications.IDLE);
        super.end();
    }
    
    public void interrupted()
    {
        CommandBase.arduComm.set(ArduinoCommunications.IDLE);
        super.interrupted();
    }
}
