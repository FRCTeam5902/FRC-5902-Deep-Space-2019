package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.driveStraight;

public class driveStraight extends Command {
  public driveStraight() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // puts power to each motor separately
    Robot.driveTrain.driveStraightAdjust(.5, .5); // Adjust for our Drift.
    setTimeout(1);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();

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
