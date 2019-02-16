package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static AnalogAccelerometer sensorBaseAAccelerometer;
    public static WPI_TalonSRX driveTrainleftDriveLead;
    public static WPI_TalonSRX driveTrainrightDriveLead;
    public static WPI_TalonSRX driveTrainleftDriveFollow;
    public static WPI_TalonSRX driveTrainrightDriveFollow;
    public static WPI_TalonSRX cargoIntakeLead;
    public static WPI_TalonSRX cargoIntakeFollow;
    public static Servo hatchArm;
    public static Servo hatchTriangle;
    public static DifferentialDrive driveTrainrobotDrive;

    //Lights
    public static SpeedController lightsR;
    public static SpeedController lightsL;
    
    //Pneumatics
    public static Compressor compressor;
    public static Solenoid frontSolenoid;
    public static Solenoid backSolenoid;

    
    public static void init() {
      sensorBaseAAccelerometer = new AnalogAccelerometer(0);
      sensorBaseAAccelerometer.setSensitivity(0.0);
      sensorBaseAAccelerometer.setZero(2.5);

      //Create Left Motors
      driveTrainleftDriveLead = new WPI_TalonSRX(3);
      driveTrainleftDriveFollow = new WPI_TalonSRX(4);
        
      //Create Right Motors
      driveTrainrightDriveLead = new WPI_TalonSRX(1);
      driveTrainrightDriveFollow = new WPI_TalonSRX(2);
        
      // Create driveTrain
      driveTrainrobotDrive = new DifferentialDrive(driveTrainleftDriveLead, driveTrainrightDriveLead);
      driveTrainrobotDrive.setSafetyEnabled(true);
      driveTrainrobotDrive.setExpiration(0.1);
      driveTrainrobotDrive.setMaxOutput(1.0);
      driveTrainrobotDrive.setDeadband(.02);
      

      //Create hatchSystem
      hatchArm = new Servo(1);
      hatchTriangle = new Servo(2); 

      //Create cargoIntake
      cargoIntakeLead = new WPI_TalonSRX(5);
      cargoIntakeFollow = new WPI_TalonSRX(6);

      //Create pneumaticSystem
      compressor = new Compressor(0);
      frontSolenoid = new Solenoid(1);
      backSolenoid = new Solenoid(0);
      frontSolenoid.set(false);
      backSolenoid.set(false);

      // Create Lights
      lightsR = new Spark(0);
      lightsL = new Spark(3);

    }
  }
