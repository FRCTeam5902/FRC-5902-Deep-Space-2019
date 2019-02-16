package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class pneumaticSystem extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void onFrontPistons() {
    RobotMap.frontSolenoid.set(true);
  }

  public void onBackPistons() {
    RobotMap.backSolenoid.set(true);
  }

  public void offAllPistons() {
    RobotMap.frontSolenoid.set(false);
    RobotMap.backSolenoid.set(false);
  }

  public void offFrontPistons() {
    RobotMap.frontSolenoid.set(false);
  }

  public void offBackPistons() {
    RobotMap.backSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new allPistonsOff());
  }
}