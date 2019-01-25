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
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //System.out.println(Robot.driveTrain.leftDriveLead.getSelectedSensorPosition(0));
        double driveSpeed = 1;
        double driveSensitivity = .5;
        double turnSensitivity = .5;
        double gety = Robot.oi.getlogitechJoy().getY();
        double getz = Robot.oi.getlogitechJoy().getZ();
  
        SmartDashboard.putNumber("Robot.speed", Robot.speed);
        Robot.speed = (driveSpeed);
        //don't use getz if it is too smol
        if (getz < .2 && getz > -.2)
        {
            if(gety<-.1)
            {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*gety, 0, Robot.speed);
            } else
            {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*gety, 0, Robot.speed);
            }
        }
        else
        {
            if(gety<-.1)
            {
                Robot.driveTrain.arcadeDrive(1.5*-(driveSensitivity)*gety, getz*(turnSensitivity/driveSensitivity), Robot.speed);
            } else
            {
                Robot.driveTrain.arcadeDrive(-(driveSensitivity)*gety, getz*(turnSensitivity/driveSensitivity), Robot.speed);
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