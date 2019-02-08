package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class arcadeDrive extends Command {

    private static String system;

    public arcadeDrive(String system) {
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
        double turnSensitivity = .5;
        double cargoSensitivity = .5;
        double getly = Robot.oi.getlogitechJoy().getY();
        double getlz = Robot.oi.getlogitechJoy().getZ();
        double getry = Robot.oi.getlogitechJoy2().getY();
        double getrz = Robot.oi.getlogitechJoy2().getZ();
  
        SmartDashboard.putNumber("Robot.speed", driveSpeed);
        Robot.speed = (driveSpeed);
        if (arcadeDrive.system == "Drive") {
            //added minimum getz and gety so that small adjustments don't power the motors
            if (getlz < .2 && getlz > -.2) {
                if (getly<-.1) {
                    Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*getly, 0, Robot.speed);
                }
            else {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*getly, 0, Robot.speed);
                }
            }
        else {
            if(getly<-.1) {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*getly, getlz*(turnSensitivity/driveSensitivity), Robot.speed);
                }
            else {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*getly, getlz*(turnSensitivity/driveSensitivity), Robot.speed);
                }
            }
        }
        else if (arcadeDrive.system == "Cargo") {
            Robot.cargoSystem.arcadeDrive((cargoSensitivity)*getry, 0, Robot.speed);
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