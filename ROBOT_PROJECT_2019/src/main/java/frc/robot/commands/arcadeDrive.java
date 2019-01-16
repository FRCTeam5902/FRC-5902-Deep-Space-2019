/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 *
 */
public class arcadeDrive extends Command {

    public arcadeDrive() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//System.out.println(Robot.driveTrain.leftDriveLead.getSelectedSensorPosition(0));

    	// The code below checks the throttle on the joystick and then adjusts the speed and direction of the drivers joystick
    	if (Robot.oi.getlogitechJoy().getThrottle() < 0) {

    		Robot.speed = Robot.oi.getlogitechJoy().getThrottle();	    	

    		Robot.driveTrain.arcadeDrive(Robot.oi.getlogitechJoy().getY(), Robot.oi.getlogitechJoy().getZ()*.75, Robot.speed);}

    	else {

    		Robot.speed = -Robot.oi.getlogitechJoy().getThrottle();	    	

    	    Robot.driveTrain.arcadeDrive(Robot.oi.getlogitechJoy().getY(), Robot.oi.getlogitechJoy().getZ()*-.75, Robot.speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.driveStraight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}