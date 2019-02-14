package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

// Code to make the robot driveable. This code has a drive sensitivity variable that adjusts how sensitive the driving of the robot it. 
// In the drive code it checks for minimum values so to make the controller more responsive.  
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
        double driveSpeed = 1;
        //forward and backward sensitivity, y value of joystick
        double driveSensitivity = .5;
        
        //turning sensitivity, z value of joystick
        double turnSensitivity = .9;
        double gety = Robot.oi.getLogitechJoy().getY();
        double getz = Robot.oi.getLogitechJoy().getZ();

        Robot.speed = (driveSpeed);
        SmartDashboard.putNumber("Robot.speed", Robot.speed);
        // added minimum getz and gety so that small adjustments don't power the motors
        if (getz < .2 && getz > -.2) {
            if (gety<-.1) {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*gety, 0, Robot.speed);
            }
            else {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*gety, 0, Robot.speed);
            }
        }
        else {
            if (gety < -.1) {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*gety, getz*(turnSensitivity*driveSensitivity), Robot.speed);
            }
            else {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*gety, getz*(turnSensitivity*driveSensitivity), Robot.speed);
            }
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