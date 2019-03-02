package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.commands.*;
import frc.robot.commands.arcadeDrive;

//This is the robot's drive train for the kit of parts drive base. Two lead controllers and two follow controllers. 
// Using this with arcadeDrive allows us to drive the robot.
public class driveTrain extends Subsystem {

    // public final WPI_TalonSRX leftDriveLead = RobotMap.driveTrainleftDriveLead;
    // public final WPI_TalonSRX rightDriveLead = RobotMap.driveTrainrightDriveLead;
    // public final WPI_TalonSRX leftDriveFollow =
    // RobotMap.driveTrainleftDriveFollow;
    // public final WPI_TalonSRX rightDriveFollow =
    // RobotMap.driveTrainrightDriveFollow;
    // public ADXRS450_Gyro gyro;
    // private double angle;

    // public final DifferentialDrive robotDrive = RobotMap.driveTrainrobotDrive;
    @Override
    public void initDefaultCommand() {

        RobotMap.driveTrainLeftDriveFollow.follow(RobotMap.driveTrainLeftDriveLead);
        RobotMap.driveTrainRightDriveFollow.follow(RobotMap.driveTrainRightDriveLead);
        setDefaultCommand(new arcadeDrive());
        // RobotMap.driveTrainrightDriveLead.configOpenloopRamp(5);
        // RobotMap.driveTrainleftDriveLead.configOpenloopRamp(5);
        // setDefaultCommand(new MySpecialCommand());
    }

    public void getDistance() {
        //ultraSonicMaxbotix.setAutomaticMode(true);
        //System.out.println(RobotMap.ultrasonic.getRangeInches());
        //double distance = (1) * RobotMap.ultrasonic.getRangeInches();
        //SmartDashboard.putNumber("Distance", distance);
    }

    public void arcadeDrive(double move, double rotate, double speed) {
        RobotMap.driveTrainRobotDrive.arcadeDrive(move * speed, rotate * speed);
    }

    public void curvatureDrive(double forward, double rotate, boolean quickTurn) {
        RobotMap.driveTrainRobotDrive.curvatureDrive(forward, rotate, quickTurn);
    }

    public void arcadeDriveBackwards(double move, double rotate, double speed) {
        RobotMap.driveTrainRobotDrive.arcadeDrive(-move * speed, rotate * speed);
    }

    public double changeSpeed(double multiplier) {
        return multiplier;
    }

    public void autoDrive(double speedL, double speedR) {
        //RobotMap.driveTrainLeftDriveLead.set(speedL);
        //RobotMap.driveTrainLeftDriveFollow.set(speedL);
        //RobotMap.driveTrainRightDriveLead.set(-speedR);
        //RobotMap.driveTrainRightDriveFollow.set(-speedR);
        RobotMap.driveTrainRobotDrive.tankDrive(speedL, speedR);
    }

    public void driveStraight(double speed) {
        RobotMap.driveTrainRobotDrive.tankDrive(speed, speed);
    }

    public void driveStraightAdjust(double speedL, double speedR) {
        RobotMap.driveTrainRobotDrive.tankDrive(speedL, speedR);
    }

    @Override
    public void periodic() {
    }
}