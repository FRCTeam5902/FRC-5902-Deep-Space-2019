package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.cargoSystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.hatchSystem;
import frc.robot.subsystems.pneumaticSystem;
import edu.wpi.first.wpilibj.Servo;


//gryo imports
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//Camera Imports
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

//Pneumtic Imports
import frc.robot.subsystems.pneumaticSystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

//Pathfinder Imports
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SpeedController;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Robot extends TimedRobot {
  public static OI oi;
  public static double speed;
  public static Servo hatchGrabber;
  public static driveTrain driveTrain;
  public static hatchSystem hatchSystem;
  public static cargoSystem cargoSystem;
  public static pneumaticSystem pneumaticSystem;
  public ADXRS450_Gyro gyro;
  //Pathfinder Stuff
  private static final int k_ticks_per_rev = 1024;
  private static final double k_wheel_diameter = 6.0 / 12.0;
  private static final double k_max_velocity = 10;
  private static final int k_left_channel = 3;
  private static final int k_right_channel = 1;
  private static final int k_left_encoder_port_a = 0;
  private static final int k_left_encoder_port_b = 1;
  private static final int k_right_encoder_port_a = 2;
  private static final int k_right_encoder_port_b = 3;
  private static final String k_path_name = "LeftPath";
  private TalonSRX m_left_motor;
  private TalonSRX m_right_motor;
  private Encoder m_left_encoder;
  private Encoder m_right_encoder;
  private ADXRS450_Gyro m_gyro;
  private EncoderFollower m_left_follower;
  private EncoderFollower m_right_follower;
  private Notifier m_follower_notifier;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    pneumaticSystem = new pneumaticSystem();

    gyro = new ADXRS450_Gyro(); 
    gyro.reset();
    gyro.calibrate();

    RobotMap.init();
    driveTrain = new driveTrain();
    //servo that grabs the hatches
    hatchSystem = new hatchSystem();
    // cargo intake
    cargoSystem = new cargoSystem();
    //Operator Interface
    oi = new OI();
    // Autonomous Chooser Code
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);
    m_left_motor = new TalonSRX(k_left_channel);
    m_right_motor = new TalonSRX(k_right_channel);
    m_left_encoder = new Encoder(k_left_encoder_port_a, k_left_encoder_port_b);
    m_right_encoder = new Encoder(k_right_encoder_port_a, k_right_encoder_port_b);
    m_gyro = new ADXRS450_Gyro();
}

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Logitech1 Y", Robot.oi.getlogitechJoy().getY());
    SmartDashboard.putNumber("Logitech1 Z", Robot.oi.getlogitechJoy().getZ());
    SmartDashboard.putNumber("Logitech1 X", Robot.oi.getlogitechJoy().getX());

  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    //Pathfinder Trajectory and PID
    Trajectory left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");
    Trajectory right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
    m_left_follower = new EncoderFollower(left_trajectory);
    m_right_follower = new EncoderFollower(right_trajectory);
    m_left_follower.configureEncoder(m_left_encoder.get(), k_ticks_per_rev, k_wheel_diameter);
    // You must tune the PID values on the following line!
    m_left_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
    m_right_follower.configureEncoder(m_right_encoder.get(), k_ticks_per_rev, k_wheel_diameter);
    // You must tune the PID values on the following line!
    m_right_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
    m_follower_notifier = new Notifier(this::followPath);
    m_follower_notifier.startPeriodic(left_trajectory.get(0).dt);

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  private void followPath() {
    if (m_left_follower.isFinished() || m_right_follower.isFinished()) {
      m_follower_notifier.stop();
    } else {
      double left_speed = m_left_follower.calculate(m_left_encoder.get());
      double right_speed = m_right_follower.calculate(m_right_encoder.get());
      double heading = m_gyro.getAngle();
      double desired_heading = Pathfinder.r2d(m_left_follower.getHeading());
      double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
      double turn =  0.8 * (-1.0/80.0) * heading_difference;
      m_left_motor.set(ControlMode.PercentOutput, left_speed + turn);
      m_right_motor.set(ControlMode.PercentOutput, right_speed - turn);
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    Robot.hatchSystem.turn(0,"triangle");
    //Stop Pathfinder
    m_follower_notifier.stop();
    m_left_motor.set(ControlMode.PercentOutput, 0);
    m_right_motor.set(ControlMode.PercentOutput, 0);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    //Smartdashboard Driver Stuff
    SmartDashboard.putNumber("Throttle", Robot.oi.getlogitechJoy().getThrottle());  
    SmartDashboard.putNumber("Robot Speed", Robot.speed);

    //Smartdashboard Debug Code
    //SmartDashboard.putNumber("leftDriveLead Volt", Robot.driveTrain.leftDriveLead.getMotorOutputVoltage());
    //SmartDashboard.putNumber("leftDriveFollow Volt", Robot.driveTrain.leftDriveFollow.getMotorOutputVoltage());
    //SmartDashboard.putNumber("rightDriveLead Volt", Robot.driveTrain.rightDriveLead.getMotorOutputVoltage());
    //SmartDashboard.putNumber("rightDriveFollow Volt", Robot.driveTrain.rightDriveFollow.getMotorOutputVoltage());  
    //SmartDashboard.putNumber("leftDriveLead Amperage", Robot.driveTrain.leftDriveLead.getOutputCurrent());
    //SmartDashboard.putNumber("leftDriveFollow Amperage", Robot.driveTrain.leftDriveFollow.getOutputCurrent());
    //SmartDashboard.putNumber("rightDriveLead Amperage", Robot.driveTrain.rightDriveLead.getOutputCurrent());
    //SmartDashboard.putNumber("rightDriveFollow Amperage", Robot.driveTrain.rightDriveFollow.getOutputCurrent());
      SmartDashboard.putBoolean("Gyro Connected", gyro.isConnected());
      SmartDashboard.putNumber("Robot Gyro Value", gyro.getAngle());
  
  }

  @Override
  public void testPeriodic() {
  }
}
