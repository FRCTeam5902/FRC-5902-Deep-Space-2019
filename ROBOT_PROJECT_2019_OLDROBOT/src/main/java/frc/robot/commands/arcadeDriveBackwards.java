package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

// Code to make the robot driveable. This code has a drive sensitivity variable that adjusts how sensitive the driving of the robot it. 
// In the drive code it checks for minimum values so to make the controller more responsive.  
public class arcadeDriveBackwards extends Command {
    public double multiplier;
    public arcadeDriveBackwards() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        SmartDashboard.putString("Drive Mode", "Cargo Front");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double driveSpeed = 1;
        double multiplier = 1;
        double throttle = 1;
        throttle = Robot.oi.getLogitechJoy().getThrottle();	
        if (throttle <= 0) {
            multiplier = 1;
        }
        else {
            multiplier = .5;
        }
        // forward and backward sensitivity, y value of joystick
        double driveSensitivity = .85;

        // turning sensitivity, z value of joystick
        double turnSensitivity = .55;
        double gety = Robot.oi.getLogitechJoy().getY();
        double getz = Robot.oi.getLogitechJoy().getZ();

        double z = getz * turnSensitivity * multiplier;
        double y = gety * driveSensitivity * multiplier;


        Robot.speed = (driveSpeed);
        // added minimum getz and gety so that small adjustments don't power the motors
        
        
        if (getz < .2 && getz > -.2) {
            Robot.driveTrain.arcadeDriveBackwards(y, 0, Robot.speed);
        } else {
            Robot.driveTrain.arcadeDriveBackwards(y, z, Robot.speed);
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