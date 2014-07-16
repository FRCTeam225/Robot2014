/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.team225.robot2014.commands.drivetrain;

import org.team225.robot2014.CommandBase;
import org.team225.robot2014.constants.Constants;

/**
 *
 * @author andrew
 */
public class HoldPosition extends CommandBase
    {
        double pos = 0;
        public HoldPosition(boolean timeout)
        {
            requires(drivetrain);
            if ( timeout )
                setTimeout(10);
        }
        
        
        public HoldPosition()
        {
            this(false);
        }
        
        protected void initialize() {
            drivetrain.shift(true);
            pos = drivetrain.getAverageDistance();
        }

        protected void execute() {
            double speed = drivetrain.getAverageDistance()-pos;
            speed *= Constants.getConstants().get("HOLDPOSITION_P");
            
            double offset = drivetrain.getAngle()*Constants.getConstants().get("HOLDPOSITION_TURN_P");
            
            drivetrain.setMotorSpeeds(speed+offset, speed-offset);
        }

        
        protected boolean isFinished() {
            return false;
        }

        protected void end() {
            drivetrain.shift(false);
        }
    }