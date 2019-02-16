package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

//This code makes the cargo intake motors able to be controlled by one of the joysticks.
public class cargoDrive extends Command {

  public cargoDrive() {
    requires(Robot.cargoSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double driveSpeed = 1;
    // forward and backward sensitivity, y value of joystick
    double driveSensitivity = .65;

    double gety = Robot.oi.getLogitechJoy2().getY();
    Robot.speed = (driveSpeed);
    if (gety * driveSensitivity > .2 || gety * driveSensitivity < -.2) {
      // added minimum gety so that small adjustments don't power the motors
      if (RobotMap.compressor.enabled() == true) {
        RobotMap.compressor.stop();
        Robot.cargoSystem.eject(driveSensitivity * gety);
        Robot.lightSystem.getAllianceColorMovement();
      } else {
        Robot.cargoSystem.eject(driveSensitivity * gety);
        Robot.lightSystem.getAllianceColorMovement();
      }
    } else {
      Robot.cargoSystem.stop();
      RobotMap.compressor.start();
      Robot.lightSystem.getAllianceColor();
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