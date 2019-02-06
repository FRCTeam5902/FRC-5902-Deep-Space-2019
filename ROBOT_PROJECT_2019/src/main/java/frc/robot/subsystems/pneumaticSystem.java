package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
public class pneumaticSystem extends Subsystem {

  public final WPI_VictorSPX cargoIntake = RobotMap.cargoIntake;

<<<<<<< HEAD
  @Override
  public void initDefaultCommand() {
=======
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //public void forwardActuator() {
  //  doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  //  }
  //public void reverseActuator() {
  //  doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  //}
  public void offActuator(){
    doubleSolenoid.set(DoubleSolenoid.Value.kOff);
>>>>>>> 85973766d325d027d608c3d88356dcc84b8aa97d
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
  

}
