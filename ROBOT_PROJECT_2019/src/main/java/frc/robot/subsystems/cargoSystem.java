package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class cargoSystem extends Subsystem {

  public final WPI_TalonSRX cargoIntakeLead = RobotMap.cargoIntakeLead;
  public final WPI_TalonSRX cargoIntakeFollow = RobotMap.cargoIntakeFollow;

  @Override
  public void initDefaultCommand() {
    cargoIntakeFollow.setInverted(true);
    cargoIntakeFollow.follow(cargoIntakeLead);
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
    cargoIntakeFollow.set(0);
  }
  public void driverControlledCargo (double speed){
  //Robot.cargoSystem.arcadeDrive(Robot.oi.logitechRight.getY(), 0, Robot.speed);
}


}
