package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class hatchArmServo extends Command {
  double down = 90;
  double up = 15;
  public hatchArmServo() {
    requires(Robot.hatchSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //set to servo up value
    System.out.println("initialize up arm");
    Robot.hatchSystem.turn(up,"arm");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.hatchSystem.turn(down,"arm");
    System.out.println(Robot.hatchSystem.hatchArm.getAngle());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("Servo up finished");
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Servo up end");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //set servo to up value
    Robot.hatchSystem.turn(up,"arm");
  }
}
