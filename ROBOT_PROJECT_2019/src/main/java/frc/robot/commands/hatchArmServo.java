package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class hatchArmServo extends Command {
  public double setAngle;
  public static boolean isArmUp;

  public hatchArmServo(double setAngle) {
    requires(Robot.hatchSystem);
    this.setAngle = setAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    isArmUp = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (setAngle > 55) {
      RobotMap.hatchTriangle.setAngle(100);
      isArmUp = true;
    }
    else if (setAngle < 55) {
      isArmUp = false;
    }
    RobotMap.hatchArm.setAngle(setAngle);
  }

  public static boolean getArm() {
    return isArmUp;
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
    // set servo to up value
  }
}