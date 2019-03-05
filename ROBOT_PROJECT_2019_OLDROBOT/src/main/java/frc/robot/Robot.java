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
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogInput;

public class Robot extends TimedRobot {
  public static OI oi;
  public static double speed;
  public static driveTrain driveTrain;
  public static Alliance al;
  public static DriverStation ds;
  SendableChooser chooser;
  Command autonomousCommand;
  //Ultrasonic ultra = new Ultrasonic(0,0);
  
  @Override
  public void robotInit() {

//ultra.setAutomaticMode(true);

    driveTrain = new driveTrain();
    oi = new OI();
    // Operator Interface
   // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // Autonomous Chooser Code
    chooser = new SendableChooser();
    chooser.setDefaultOption("Driven't", new drivent());
    chooser.addOption("Drive Straight", new driveStraight());
    SmartDashboard.putData("Auto mode", chooser);
    System.out.println("Robot Init");
    RobotMap.init();
  }

  @Override
  public void robotPeriodic() {
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
    //
    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

  //public double ultrasonic() {
  //  double range = ultra.getRangeInches();
  //  return range;
  //}
}