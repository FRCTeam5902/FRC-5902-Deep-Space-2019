package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class cargoIntake extends Command {

  public double speed;

  public cargoIntake(double speed) {
    // Use requires() here to declare subsystem dependencies
    this.speed = speed;
    requires(Robot.cargoSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.cargoIntakeFollow.setInverted(true);
    RobotMap.cargoIntakeFollow.follow(RobotMap.cargoIntakeLead);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (RobotMap.compressor.enabled() == true) {
      RobotMap.compressor.stop();
      Robot.cargoSystem.intake(this.speed);
      Robot.lightSystem.getAllianceColorMovement();
    } else {
      Robot.cargoSystem.intake(this.speed);
      Robot.lightSystem.getAllianceColorMovement();
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
    RobotMap.compressor.start();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.cargoSystem.stop();
  }
}