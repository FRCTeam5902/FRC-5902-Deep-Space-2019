package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.driveStraight;
import frc.robot.commands.drivent;
import frc.robot.subsystems.cargoSystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.hatchSystem;
import frc.robot.subsystems.lightSystem;
import frc.robot.subsystems.pneumaticSystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Ultrasonic;

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
  SendableChooser chooser;
  Command autonomousCommand;
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
    oi = new OI();
    gyro.reset();
    gyro.calibrate();
    // Operator Interface
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // Autonomous Chooser Code
    chooser = new SendableChooser();
    chooser.setDefaultOption("Driven't", new drivent());
    chooser.addOption("Drive Straight", new driveStraight());
    SmartDashboard.putData("Auto mode", chooser);
    System.out.println("Robot Init");
    //RobotMap.ultrasonic.setAutomaticMode(true);
    RobotMap.init();
  }

  @Override
  public void robotPeriodic() {
    // SmartDashboard.putBoolean("Gyro Connected", gyro.isConnected());
    // SmartDashboard.putNumber("Robot Gyro Value", gyro.getAngle());
    SmartDashboard.putBoolean("F Pistons", RobotMap.frontSolenoid.get());
    SmartDashboard.putBoolean("B Pistons", RobotMap.backSolenoid.get());
    SmartDashboard.putBoolean("PSI", RobotMap.compressor.getPressureSwitchValue());
    //SmartDashboard.putNumber("Distance", RobotMap.ultra.getRangeInches());

    //SmartDashboard.putNumber("Get Y", Robot.oi.getLogitechJoy().getY());
    //SmartDashboard.putNumber("Get Z", Robot.oi.getLogitechJoy().getZ());
    //SmartDashboard.putNumber("Get X", Robot.oi.getLogitechJoy().getX());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = (Command) chooser.getSelected();
    Robot.lightSystem.getAllianceColor();
    RobotMap.hatchTriangle.setAngle(100); // 100 is down
    RobotMap.hatchArm.setAngle(0); // 0 is 
    RobotMap.compressor.stop();
    //
    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    Robot.lightSystem.getAllianceColor();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    RobotMap.compressor.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}