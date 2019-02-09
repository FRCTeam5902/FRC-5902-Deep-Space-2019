package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
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
  public final Solenoid frontSolenoid = RobotMap.pneumaticSystemFrontSolenoid;
  public final Solenoid backSolenoid = RobotMap.pneumaticSystemBackSolenoid;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public void onFrontPistons() {
    frontSolenoid.set(true);
  }
  public void onBackPistons() {
    backSolenoid.set(true);
  }

  public void offAllPistons() {
    frontSolenoid.set(false);
    backSolenoid.set(false);
    }
  public void offFrontPistons(){
    frontSolenoid.set(false);
  }
  public void offBackPistons(){
    backSolenoid.set(false);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new solenoidDoNothing());
  }
} 