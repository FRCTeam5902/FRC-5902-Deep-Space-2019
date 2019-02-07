package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
public class cargoSystem extends Subsystem {

  public final WPI_VictorSPX cargoIntake = RobotMap.cargoIntake;
  Robot.speed = ;
  @Override
  public void initDefaultCommand() {
  }

  public void Intake (double speed){
    cargoIntake.set(speed);
  }

  public void Eject (double speed){
    cargoIntake.set(-speed);
  }

  public void Stop(){
    cargoIntake.set(0);
  }
  public void driverControlledCargo (double speed){
  Robot.cargoSystem.arcadeDrive(Robot.oi.logitechRight.getY(), 0, Robot.speed);
}


}
