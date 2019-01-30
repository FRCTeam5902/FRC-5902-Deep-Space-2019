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

public class Robot extends TimedRobot {
  public static OI oi;
  public static double speed;
  public static Servo hatchGrabber;
  public static driveTrain driveTrain;
  public static hatchSystem hatchSystem;
  public static cargoSystem cargoSystem;
  public static pneumaticSystem pneumaticSystem;
  public ADXRS450_Gyro gyro;

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

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
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
