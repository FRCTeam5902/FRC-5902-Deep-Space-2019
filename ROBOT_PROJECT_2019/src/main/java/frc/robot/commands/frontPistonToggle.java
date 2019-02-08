package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.*;

//Toggles on and off a variable which either makes the front pistons go out or in
// starts as not out (obviously)
public class frontPistonToggle extends Command{
  boolean frontPistonOut = false;
  public frontPistonToggle() {
    requires(Robot.pneumaticSystem);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(frontPistonOut==false){
      Robot.pneumaticSystem.forwardFrontActuator();
    }
    else{
      Robot.pneumaticSystem.offFrontActuator();
    }
    frontPistonOut = !frontPistonOut;
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
    end();
  }
}