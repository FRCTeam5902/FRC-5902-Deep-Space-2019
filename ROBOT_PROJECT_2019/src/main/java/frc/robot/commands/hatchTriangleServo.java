package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.hatchArmServo;

// Values
// 0 is UP
// 100 is DOWN
public class hatchTriangleServo extends Command {

  double up = 45;
  double down = 100;

  public double setAngle;

  // sets center and up servo angles
  public hatchTriangleServo(double setAngle) {
    requires(Robot.hatchSystem);
    this.setAngle = setAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.hatchSystem.turn(down,"triangle");
    // set servo triangle to up position
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // set triangle servo to down position
    // Robot.hatchSystem.turn(up,"triangle");
    if (!hatchArmServo.getArm()) {
      RobotMap.hatchTriangle.setAngle(setAngle);
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
    // set triangle servo to up position
  }
}