package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.arcadeDrive;
import frc.robot.commands.tankDrive;

public class driveTrain extends Subsystem {

    public final WPI_TalonSRX leftDriveLead = RobotMap.driveTrainleftDriveLead;
    public final WPI_TalonSRX rightDriveLead = RobotMap.driveTrainrightDriveLead;
    public final WPI_TalonSRX leftDriveFollow = RobotMap.driveTrainleftDriveFollow;
    public final WPI_TalonSRX rightDriveFollow = RobotMap.driveTrainrightDriveFollow;
    //public ADXRS450_Gyro gyro;
	//private double angle;

    public final DifferentialDrive robotDrive = RobotMap.driveTrainrobotDrive;
    @Override
    public void initDefaultCommand() {
    	
    	leftDriveFollow.follow(leftDriveLead);
    	rightDriveFollow.follow(rightDriveLead);
            // set this so it will be back to arcade drive 
        setDefaultCommand(new arcadeDrive());

        // setDefaultCommand(new MySpecialCommand());

    }

    public void arcadeDrive(double move, double rotate, double speed) {

    	  robotDrive.arcadeDrive(move*speed, rotate*speed);

    }
    
    public void autoDrive(double speedL, double speedR) {

    	robotDrive.tankDrive(speedL, speedR);

    }
    
    public void driveStraight(double speed) {

    	robotDrive.tankDrive(speed, speed);

    }

    public void driveStraightAdjust(double speedL, double speedR) {

        robotDrive.tankDrive(speedL, speedR);
        
	}
    
    @Override
    public void periodic() {	
        
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
