package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.driveTrain;

public class autonomousHABOff extends CommandGroup {
  /**
   * Add your docs here.
   */
  public autonomousHABOff() {
    requires(Robot.driveTrain);
  }

  public void execute() {
    Robot.driveTrain.arcadeDrive(1, 1, 1);
  }

}
