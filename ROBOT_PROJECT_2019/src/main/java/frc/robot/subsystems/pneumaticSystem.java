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
  public final DoubleSolenoid doubleSolenoidPusher = RobotMap.pneumaticSystemDoubleSolenoidPusher;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void offActuator(){
    doubleSolenoidPusher.set(DoubleSolenoid.Value.kOff);
  }
  


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


}