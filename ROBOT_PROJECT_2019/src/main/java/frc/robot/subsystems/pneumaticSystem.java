package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.solenoidDoNothing;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class  pneumaticSystem extends Subsystem {
  //Declartations
  private final Compressor compressor = RobotMap.pneumaticSysteCompressor;
  public final DoubleSolenoid frontSolenoid = RobotMap.pneumaticSystemDoubleSolenoid;
  public final DoubleSolenoid backSolenoid = RobotMap.pneumaticSystemDoubleSolenoid;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void reverseAllActuators() {
    frontSolenoid.set(DoubleSolenoid.Value.kReverse);
    backSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  public void forwardFrontActuator() {
    frontSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void forwardBackActuator() {
    backSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void offAllActuators(){
    frontSolenoid.set(DoubleSolenoid.Value.kOff);
    backSolenoid.set(DoubleSolenoid.Value.kOff);
  }
  public void offFrontActuator(){
    frontSolenoid.set(DoubleSolenoid.Value.kOff);
  }
  public void offBackActuator(){
    backSolenoid.set(DoubleSolenoid.Value.kOff);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new solenoidDoNothing());
  }
} 