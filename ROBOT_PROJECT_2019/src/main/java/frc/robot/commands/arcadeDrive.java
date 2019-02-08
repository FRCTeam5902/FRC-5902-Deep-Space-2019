package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class arcadeDrive extends Command {

  

   

    public arcadeDrive() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { 
    //Ramp up Speed

    }
        public double RSpeedZ;
        public double RSpeedY;
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double driveSpeed = 1;
        //forward and backward sensitivity, y value of joystick
        double driveSensitivity = .5;
        
        //turning sensitivity, z value of joystick
        double turnSensitivity = .5;
        double gety = Robot.oi.getlogitechJoy().getY();
        double getz = Robot.oi.getlogitechJoy().getZ();
        for (double IY = 100; IY > 0; IY--) {
            RSpeedY = (gety / IY);
        }
        for (double IZ = 100; IZ > 0; IZ--) {
            RSpeedZ = (gety / IZ);
        }

        Robot.speed = (driveSpeed);
        SmartDashboard.putNumber("Robot.speed", Robot.speed);
        // added minimum getz and gety so that small adjustments don't power the motors
        if (getz < .2 && getz > -.2)
        {
            if(gety<-.1)
            {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*RSpeedY, 0, Robot.speed);
            }
            else
            {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*RSpeedY, 0, Robot.speed);
            }
        }
        else
        {
            if (gety < -.1)
            {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*RSpeedY, RSpeedZ*(turnSensitivity/driveSensitivity), Robot.speed);
            }
            else
            {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*RSpeedY, RSpeedZ*(turnSensitivity/driveSensitivity), Robot.speed);
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