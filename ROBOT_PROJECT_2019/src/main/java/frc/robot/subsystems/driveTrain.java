package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.arcadeDrive;
import frc.robot.commands.arcadeDriveBackwards;
import frc.robot.commands.tankDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//This is the robot's drive train for the kit of parts drive base. Two lead controllers and two follow controllers. 
// Using this with arcadeDrive allows us to drive the robot.
public class driveTrain extends Subsystem {

    //public final WPI_TalonSRX leftDriveLead = RobotMap.driveTrainleftDriveLead;
    //public final WPI_TalonSRX rightDriveLead = RobotMap.driveTrainrightDriveLead;
    //public final WPI_TalonSRX leftDriveFollow = RobotMap.driveTrainleftDriveFollow;
    //public final WPI_TalonSRX rightDriveFollow = RobotMap.driveTrainrightDriveFollow;
    //public ADXRS450_Gyro gyro;
	//private double angle;

    //public final DifferentialDrive robotDrive = RobotMap.driveTrainrobotDrive;
    @Override
    public void initDefaultCommand() {
    	
        RobotMap.driveTrainleftDriveFollow.follow(RobotMap.driveTrainleftDriveLead);
    	RobotMap.driveTrainrightDriveFollow.follow(RobotMap.driveTrainrightDriveLead);
        setDefaultCommand(new arcadeDrive());
        //RobotMap.driveTrainrightDriveLead.configOpenloopRamp(5);
        //RobotMap.driveTrainleftDriveLead.configOpenloopRamp(5);
        // setDefaultCommand(new MySpecialCommand());
    }

    public void arcadeDrive(double move, double rotate, double speed) {

        RobotMap.driveTrainrobotDrive.arcadeDrive(move*speed, rotate*speed);

    }
    public void arcadeDriveBackwards(double move, double rotate, double speed) {

        RobotMap.driveTrainrobotDrive.arcadeDrive(move * speed, rotate * speed);

    }
    
    public void autoDrive(double speedL, double speedR) {

    	RobotMap.driveTrainrobotDrive.tankDrive(speedL, speedR);

    }
    
    public void driveStraight(double speed) {

    	RobotMap.driveTrainrobotDrive.tankDrive(speed, speed);

    }

    public void driveStraightAdjust(double speedL, double speedR) {

        RobotMap.driveTrainrobotDrive.tankDrive(speedL, speedR);
        
	}
    
    @Override
    public void periodic() {	
        
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
