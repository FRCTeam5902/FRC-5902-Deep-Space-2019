package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.commands.hatchServoUp;
import frc.robot.commands.hatchServoDown;
import frc.robot.commands.hatchServoCenter;
public class hatchSystem extends Subsystem {
  public final Servo hatchGrabber = RobotMap.hatchGrabber;
  //servo that picks up the hathches
  
  public void turn(double angle) {
    hatchGrabber.set(angle);
  }
  @Override
  public void initDefaultCommand() {
  }
}
