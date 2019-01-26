package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class gyroSystem extends Subsystem {
  public ADXRS450_Gyro myGyro;
  private double angle;


 public void myGyro() {
  myGyro = new ADXRS450_Gyro();
  myGyro.reset();
  myGyro.calibrate();
 }

  @Override
  public void initDefaultCommand() {
  }

  public void run(gyroSystem myGyro) {
    angle = myGyro.myGyro.getAngle();
  }

  public void reset(gyroSystem myGyro) {
	myGyro.myGyro.reset();
  }

  public void calibrate(gyroSystem myGyro) {
    myGyro.myGyro.calibrate();
  }
  public double getAngle() {
    return angle;
  }

}
