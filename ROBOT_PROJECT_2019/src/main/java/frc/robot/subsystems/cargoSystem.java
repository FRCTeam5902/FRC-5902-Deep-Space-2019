package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.cargoDrive;
import frc.robot.RobotMap;
//Cargo sytem. This system consists of two large CIM motors on either side of a hex shaft controlled by TALON SRX motor controllers.
//One TALON SRX is lead and the other is follow. The follow motor is inverted to make them work together to turn a hex shaft.
public class cargoSystem extends Subsystem {

  //public final WPI_TalonSRX cargoIntakeLead = RobotMap.cargoIntakeLead;
  //public final WPI_TalonSRX cargoIntakeFollow = RobotMap.cargoIntakeFollow;

  @Override
  public void initDefaultCommand() {
    RobotMap.cargoIntakeFollow.setInverted(true);
    RobotMap.cargoIntakeFollow.follow(RobotMap.cargoIntakeLead);
    setDefaultCommand(new cargoDrive());
  }

  public void intake (double speed){
    RobotMap.cargoIntakeLead.set(speed);
  }
  public void eject (double speed) {
    RobotMap.cargoIntakeLead.set(speed);
  }

  public void stop(){
    RobotMap.cargoIntakeLead.set(0);
    RobotMap.cargoIntakeFollow.set(0);
  }
}
