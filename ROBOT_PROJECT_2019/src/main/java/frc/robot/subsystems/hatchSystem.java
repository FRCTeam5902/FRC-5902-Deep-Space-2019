package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.commands.hatchArmServo;
public class hatchSystem extends Subsystem {
 // public final Servo hatchArm = RobotMap.hatchArm;
  //public final Servo hatchTriangle = RobotMap.hatchTriangle;
  //servo that picks up the hathches
  
  public void turn(double angle, String servo) {
    /* if (servo == "arm") {
      RobotMap.hatchArm.setAngle(angle);
    }
    else if (servo == "triangle") {
      RobotMap.hatchTriangle.setAngle(angle);
    } */
  }
  @Override
  public void initDefaultCommand() {
  }
}
