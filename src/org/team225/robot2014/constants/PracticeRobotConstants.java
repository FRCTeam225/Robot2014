/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2014.constants;

/**
 *
 * @author Andrew
 */
public class PracticeRobotConstants extends Constants{
    
    public PracticeRobotConstants()
    {
        super();
        
        put("DRIVETRAIN_P", 0.0009);
        
        //put("ARM_STOW", 300);
        //put("ARM_UP", 250);
        put("ARM_OUT", 550);
        put("ARM_SHOOT", 630);
        put("ARM_UP", 750);
        put("ARM_STOW", 800);
        
        
        put("ARM_P", 0.005);
        put("ARM_I", 0);
        put("ARM_D", 0);
        
        put("DRIVETRAIN_DRIVESTRAIGHT_P", 0);
        put("AUTO_DISTANCE_TO_GOALS_2BALL", 9000);
    }
}
