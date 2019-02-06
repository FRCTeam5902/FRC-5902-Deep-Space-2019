package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class hatchTriangleServoCenter extends Command {
  public hatchTriangleServoCenter() {
    requires(Robot.hatchSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if statement to check which servo is being used
<<<<<<< HEAD:ROBOT_PROJECT_2019/src/main/java/frc/robot/commands/hatchTriangleServoCenter.java
    
    Robot.hatchSystem.turn(0,"triangle");
=======
    if (trianglePosition == "Up"){
      Robot.hatchSystem.turn(35,"triangle");
    } else if (trianglePosition == "Center"){
      Robot.hatchSystem.turn(90,"triangle");
    }
>>>>>>> 85973766d325d027d608c3d88356dcc84b8aa97d:ROBOT_PROJECT_2019/src/main/java/frc/robot/commands/hatchTriangleServoToggle.java
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
<<<<<<< HEAD:ROBOT_PROJECT_2019/src/main/java/frc/robot/commands/hatchTriangleServoCenter.java
=======
    if (trianglePosition == "Up")
    {
      trianglePosition = "Center";
      SmartDashboard.putString("Triangle Postition","center");
    }
    else if (trianglePosition == "Center")
    {
      trianglePosition = "Up";
      SmartDashboard.putString("Triangle Postition","up");
    }
>>>>>>> 85973766d325d027d608c3d88356dcc84b8aa97d:ROBOT_PROJECT_2019/src/main/java/frc/robot/commands/hatchTriangleServoToggle.java
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