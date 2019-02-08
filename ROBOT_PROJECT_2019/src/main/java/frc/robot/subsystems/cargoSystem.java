package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
public class cargoSystem extends Subsystem {

  public final WPI_TalonSRX cargoIntakeLead = RobotMap.cargoIntakeLead;
  //public final WPI_TalonSRX cargoIntakeFollow = RobotMap.cargoIntakeFollow;
  @Override
  public void initDefaultCommand() {
    //cargoIntakeFollow.follow(cargoIntakeLead);
  }

  public void arcadeDrive(double move, double rotate, double speed) {
    cargoIntakeLead.set(speed);

}
  public void Intake (double speed){
    cargoIntakeLead.set(speed);
  }

  public void Eject (double speed){
    cargoIntakeLead.set(-speed);
  }

  public void Stop(){
    cargoIntakeLead.set(0);
  }
  public void driverControlledCargo (double speed){
  //Robot.cargoSystem.arcadeDrive(Robot.oi.logitechRight.getY(), 0, Robot.speed);
}


}
