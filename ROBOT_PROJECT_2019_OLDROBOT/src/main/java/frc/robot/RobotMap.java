package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;

public class RobotMap {
  public static AnalogAccelerometer sensorBaseAAccelerometer;
  public static WPI_TalonSRX driveTrainLeftDriveLead;
  public static WPI_TalonSRX driveTrainRightDriveLead;
  public static WPI_VictorSPX driveTrainLeftDriveFollow;
  public static WPI_TalonSRX driveTrainRightDriveFollow;
  public static DifferentialDrive driveTrainRobotDrive;

  public static void init() {
    //sensorBaseAAccelerometer = new AnalogAccelerometer(0);
    //sensorBaseAAccelerometer.setSensitivity(0.0);
    //sensorBaseAAccelerometer.setZero(2.5);

    // Create Left Motors
    driveTrainLeftDriveLead = new WPI_TalonSRX(3);
    driveTrainLeftDriveFollow = new WPI_VictorSPX(4);

    // Create Right Motors
    driveTrainRightDriveLead = new WPI_TalonSRX(1);
    driveTrainRightDriveFollow = new WPI_TalonSRX(2);

    // Create driveTrain
    driveTrainRobotDrive = new DifferentialDrive(driveTrainLeftDriveLead, driveTrainRightDriveLead);
    driveTrainRobotDrive.setSafetyEnabled(true);
    driveTrainRobotDrive.setExpiration(0.1);
    driveTrainRobotDrive.setMaxOutput(1.0);
    driveTrainRobotDrive.setDeadband(.02);
    driveTrainRightDriveLead.configOpenloopRamp(1);
    driveTrainLeftDriveLead.configOpenloopRamp(1);
    driveTrainRightDriveFollow.configOpenloopRamp(1);
    driveTrainRightDriveFollow.configOpenloopRamp(1);
  }
}
