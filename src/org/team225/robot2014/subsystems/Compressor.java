package org.team225.robot2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;
import org.team225.robot2014.commands.AutomaticCompressor;

/**
 *
 * @author Andrew
 */
public class Compressor extends Subsystem {
    Relay compressor;
    DigitalInput pressureSwitch;
    
    public Compressor()
    {
        compressor = new Relay(PortMap.COMPRESSOR);
        pressureSwitch = new DigitalInput(PortMap.AIR_SWITCH);
    }
    
    public void set(boolean state)
    {
        compressor.set((state?Relay.Value.kForward:Relay.Value.kOff));
    }
    
    public boolean isLow()
    {
        return !pressureSwitch.get();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new AutomaticCompressor());
    }
}
