/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.coprocessors;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team225.robot2014.PortMap;

/**
 *
 * @author awoln_000
 */
public class ArduinoCommunications {
    DigitalOutput statePin1 = new DigitalOutput(PortMap.LIGHTS_STATE_PIN_1);
    DigitalOutput statePin2 = new DigitalOutput(PortMap.LIGHTS_STATE_PIN_2);
    
    public static final int OFF = 0;
    public static final int IDLE = 1;
    public static final int SHOOTING = 2;
    public static final int NOTIFY = 3;
    
    public ArduinoCommunications()
    {
        
    }
    
    public void set(int state)
    {
        statePin1.set((state&1)>0);
        statePin2.set((state&2)>0);
    }

}
