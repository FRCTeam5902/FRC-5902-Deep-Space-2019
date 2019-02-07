package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class hatchArmServoToggle extends Command {
  public String armPosition = "Center";
  //servo angles for up and center positions
  double center = 35;
  double up = 90;
  public hatchArmServoToggle() {
    requires(Robot.hatchSystem);
  }


  // Called just before this Command runs the first time
  //initialize servo in the center position
  @Override
  protected void initialize() {
    if (armPosition == "Up"){
      Robot.hatchSystem.turn(center,"triangle");
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if statement to check which servo is being used
    if (armPosition == "Up"){
      Robot.hatchSystem.turn(center,"triangle");
    } else if (armPosition == "Center"){
      Robot.hatchSystem.turn(up,"triangle");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (armPosition == "Up")
    {
      armPosition = "Center";
      SmartDashboard.putString("Arm Postition","center");
    }
    else if (armPosition == "Center")
    {
      armPosition = "Up";
      SmartDashboard.putString("Arm Postition","up");
    }
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