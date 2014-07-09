package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author Collin
 */
public class Catcher extends Subsystem {
    
    Solenoid catcher;
    DigitalInput hasBallSensor;
    public Catcher()
    {
        hasBallSensor = new DigitalInput(PortMap.CATCHER_BALL_SENSOR);
        catcher = new Solenoid(PortMap.CATCHER_PISTON);
    }
    protected void initDefaultCommand() {
    }
    
    public boolean hasBall()
    {
        return hasBallSensor.get();
    }
    
    public void setDeployed(boolean on){
        catcher.set(on);
    }
}
