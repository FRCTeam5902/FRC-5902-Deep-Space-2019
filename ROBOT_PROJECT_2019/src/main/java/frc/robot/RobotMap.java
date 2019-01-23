/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
    public static Servo hatchGrabber;
    public static WPI_VictorSPX cargoIntake;
    public static SpeedController lights;
    public static DifferentialDrive driveTrainrobotDrive;
    public static Servo cameraControlpanServo;
    public static DigitalOutput limSwitch;
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
        
        // Create Drive Train
        driveTrainrobotDrive = new DifferentialDrive(driveTrainleftDriveLead, driveTrainrightDriveLead);
        driveTrainrobotDrive.setSafetyEnabled(true);
        driveTrainrobotDrive.setExpiration(0.1);
      driveTrainrobotDrive.setMaxOutput(1.0);

      //Create hatchSystem
      hatchGrabber = new Servo(0);

      //Create cargoIntake
      cargoIntake = new WPI_VictorSPX(1);
    }
  }

