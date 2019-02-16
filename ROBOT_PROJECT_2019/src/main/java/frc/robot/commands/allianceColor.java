package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class allianceColor extends Command {
  public allianceColor() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lightSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    DriverStation.Alliance color;
    color = DriverStation.getInstance().getAlliance();
    if (color == DriverStation.Alliance.valueOf("Blue")) {
      Robot.lightSystem.blue();

    } else if (color == DriverStation.Alliance.valueOf("Red")) {
      Robot.lightSystem.red();
    } else {
      Robot.lightSystem.scannerGray();
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
