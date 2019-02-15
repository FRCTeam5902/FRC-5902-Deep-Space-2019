package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.cargoSystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.hatchSystem;
import frc.robot.subsystems.lightSystem;
import frc.robot.subsystems.pneumaticSystem;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends TimedRobot {
  public static OI oi;
  public static double speed;
  public static driveTrain driveTrain;
  public static hatchSystem hatchSystem;
  public static cargoSystem cargoSystem;
  public static pneumaticSystem pneumaticSystem;
  public static lightSystem lightSystem;
  public ADXRS450_Gyro gyro;
  public static Alliance al;
  public static DriverStation ds;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  public final Servo hatchArm = RobotMap.hatchArm;
  public final Servo hatchTriangle = RobotMap.hatchTriangle;
  @Override
  public void robotInit() {
    pneumaticSystem = new pneumaticSystem();
    driveTrain = new driveTrain();
    hatchSystem = new hatchSystem();
    cargoSystem = new cargoSystem();
    lightSystem = new lightSystem();
    gyro = new ADXRS450_Gyro(); 
    gyro.reset();
    gyro.calibrate();
    RobotMap.init();
    System.out.println("Robot Init");
    //Operator Interface
    oi = new OI();
    // Autonomous Chooser Code
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);
}
  @Override
  public void robotPeriodic() {
    //SmartDashboard.putBoolean("Gyro Connected", gyro.isConnected());
    //SmartDashboard.putNumber("Robot Gyro Value", gyro.getAngle());
    SmartDashboard.putBoolean("Front Pistons Out?", RobotMap.frontSolenoid.get());
    SmartDashboard.putBoolean("Back Pistons Out?", RobotMap.backSolenoid.get());
    SmartDashboard.putNumber("Get Y", Robot.oi.getLogitechJoy().getY());
    SmartDashboard.putNumber("Get Z", Robot.oi.getLogitechJoy().getZ());
    SmartDashboard.putNumber("Get X", Robot.oi.getLogitechJoy().getX());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    //SmartDashboard.putString("Light Color", Robot.lightSystem.getLightColor());

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
    /* al = ds.getAlliance();
    System.out.println(al == Alliance.Red);
    lightSystem.strobeYellow();
    if (al == Alliance.Red) {
      System.out.println(1);
      lightSystem.beatRed();
    } 
    if (al == Alliance.Blue) {
      System.out.println(2);
      lightSystem.beatBlue();
    } 
    if (al == Alliance.Invalid){
      System.out.println(3);
      lightSystem.scannerGray();
  } */
  RobotMap.hatchTriangle.setAngle(100); // 100 is down
  RobotMap.hatchArm.setAngle(0); // 0 is down
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}