package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

//This code makes the cargo intake motors able to be controlled by one of the joysticks.
public class cargoDrive extends Command {

    public cargoDrive() {
        requires(Robot.cargoSystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { 
    //Ramp up Speed
    }
        public double RSpeedY;
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double driveSpeed = 1;
        //forward and backward sensitivity, y value of joystick
        double driveSensitivity = .85;
        
        double gety = Robot.oi.getLogitechJoy2().getY();
        Robot.speed = (driveSpeed);
        // added minimum gety so that small adjustments don't power the motors
        if (gety < -.1) {
          Robot.cargoSystem.eject(driveSensitivity*gety);
          Robot.lightSystem.rainbowGlitter();
        }
        else if (gety > .1) {
          Robot.cargoSystem.intake(driveSensitivity*gety);
          Robot.lightSystem.rainbowGlitter();
        }
        else {
          Robot.cargoSystem.stop();
          Robot.lightSystem.gray();

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
    	Robot.cargoSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}