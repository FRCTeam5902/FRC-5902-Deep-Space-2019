package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class pneumaticSystem extends Subsystem {
  //Declartations
  private final Compressor compressor = RobotMap.pneumaticSystemCompressor;
  //public final Solenoid frontSolenoid = RobotMap.pneumaticSystemFrontSolenoid;
  //public final Solenoid backSolenoid = RobotMap.pneumaticSystemBackSolenoid;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public void onFrontPistons() {
    RobotMap.pneumaticSystemFrontSolenoid.set(true);
    System.out.println("onFrontPiston is ALIVE");
  }
  public void onBackPistons() {
    RobotMap.pneumaticSystemBackSolenoid.set(true);
    System.out.println("onBackPiston is ALIVE");
  }

  public void offAllPistons() {
    RobotMap.pneumaticSystemFrontSolenoid.set(false);
  RobotMap.pneumaticSystemBackSolenoid.set(false);
    }
  public void offFrontPistons(){
    RobotMap.pneumaticSystemFrontSolenoid.set(false);
    System.out.println("offFrontPison is DEAD");
  }
  public void offBackPistons(){
    //backSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new allPistonsOff());
  }
} 