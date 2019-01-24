/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.cargoSystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.hatchSystem;
import edu.wpi.first.wpilibj.Servo;

//Camera Imports
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends TimedRobot {
  public static OI oi;
  public static double speed;
  public static driveTrain driveTrain;
  public static hatchSystem hatchSystem;
  public static Servo hatchGrabber;
  public static cargoSystem cargoSystem;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
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

    //newcamera Code 2019
    new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
      
      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
      
      Mat source = new Mat();
      Mat output = new Mat();
      
      while(!Thread.interrupted()) {
          cvSink.grabFrame(source);
          Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
          outputStream.putFrame(output);
      }
  }).start();

  //END 2019 Camera Code
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

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
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
    SmartDashboard.putNumber("Logitech1 Y", Robot.oi.getlogitechJoy().getY());
    SmartDashboard.putNumber("leftDriveLead Volt", Robot.driveTrain.leftDriveLead.getMotorOutputVoltage());
    SmartDashboard.putNumber("leftDriveFollow Volt", Robot.driveTrain.leftDriveFollow.getMotorOutputVoltage());
    SmartDashboard.putNumber("rightDriveLead Volt", Robot.driveTrain.rightDriveLead.getMotorOutputVoltage());
    SmartDashboard.putNumber("rightDriveFollow Volt", Robot.driveTrain.rightDriveFollow.getMotorOutputVoltage());  

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
