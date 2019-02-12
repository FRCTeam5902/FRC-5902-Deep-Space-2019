package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.arcadeDrive;
import frc.robot.commands.cargoIntake;
import frc.robot.commands.hatchArmServo;
import frc.robot.commands.hatchTriangleServo;
import frc.robot.commands.driveStraight;
import frc.robot.commands.frontPistonToggle;
import frc.robot.commands.backPistonToggle;
import frc.robot.commands.allPistonsOff;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    //left joystick buttons
    public Joystick logitechLeft;
    private JoystickButton joystickButtonL1;
    private JoystickButton joystickButtonL2;
    private JoystickButton joystickButtonL3;
    private JoystickButton joystickButtonL4;
    private JoystickButton joystickButtonL5;
    private JoystickButton joystickButtonL6;
    private JoystickButton joystickButtonL7;
    private JoystickButton joystickButtonL8;
    private JoystickButton joystickButtonL9;
    //right joystick buttons
    public Joystick logitechRight;
    private JoystickButton joystickButtonR1;
    private JoystickButton joystickButtonR2;
    private JoystickButton joystickButtonR3;
    private JoystickButton joystickButtonR4;
    private JoystickButton joystickButtonR5;
    private JoystickButton joystickButtonR6;
    private JoystickButton joystickButtonR7;
    private JoystickButton joystickButtonR8;
    private JoystickButton joystickButtonR9;
    //arcade buttons
    public Joystick AC;
    public JoystickButton joystickButtonAC1;
    public JoystickButton joystickButtonAC2;
    public JoystickButton joystickButtonAC3;
    public JoystickButton joystickButtonAC4;
    public JoystickButton joystickButtonAC5;
    public JoystickButton joystickButtonAC6;
    public JoystickButton joystickButtonAC7;
    public JoystickButton joystickButtonAC8;
    public JoystickButton joystickButtonAC9;
    // public String gameData = Robot.ds.getGameSpecificMessage().substring(0, 1);

    public OI() {
        // Make those Joysticks!
        logitechLeft = new Joystick(0);
        logitechRight = new Joystick(2);
        AC = new Joystick(1);
        String trianglePosition;
        
        //Arcade Controller buttons
        joystickButtonAC1 = new JoystickButton(AC, 1);
        joystickButtonAC2 = new JoystickButton(AC, 2);
        joystickButtonAC3 = new JoystickButton(AC, 3);
        joystickButtonAC4 = new JoystickButton(AC, 4);
        joystickButtonAC5 = new JoystickButton(AC, 5);
        joystickButtonAC6 = new JoystickButton(AC, 6);
        joystickButtonAC7 = new JoystickButton(AC, 7);
        joystickButtonAC8 = new JoystickButton(AC, 8);
        joystickButtonAC9 = new JoystickButton(AC, 9);
        //left joystick buttons
        joystickButtonL1 = new JoystickButton(logitechLeft, 1);
        joystickButtonL2 = new JoystickButton(logitechLeft, 2);
        joystickButtonL3 = new JoystickButton(logitechLeft, 3);
        joystickButtonL4 = new JoystickButton(logitechLeft, 4);
        joystickButtonL5 = new JoystickButton(logitechLeft, 5);
        joystickButtonL6 = new JoystickButton(logitechLeft, 6);
        joystickButtonL7 = new JoystickButton(logitechLeft, 7);
        joystickButtonL8 = new JoystickButton(logitechLeft, 8);
        joystickButtonL9 = new JoystickButton(logitechLeft, 9);
        //right joystick buttons
        joystickButtonR1 = new JoystickButton(logitechRight, 1);
        joystickButtonR2 = new JoystickButton(logitechRight, 2);
        joystickButtonR3 = new JoystickButton(logitechRight, 3);
        joystickButtonR4 = new JoystickButton(logitechRight, 4);
        joystickButtonR5 = new JoystickButton(logitechRight, 5);
        joystickButtonR6 = new JoystickButton(logitechRight, 6);
        joystickButtonR7 = new JoystickButton(logitechRight, 7);
        joystickButtonR8 = new JoystickButton(logitechRight, 8);
        joystickButtonR9 = new JoystickButton(logitechRight, 9);
        
        //arcade drive
        //joystickButtonL1.whileHeld(new arcadeDrive());
        
        //cargo system
        joystickButtonR1.whileHeld(new cargoIntake(.5));
       
        //joystickButtonAC5.whenPressed(new]\[] backPistonToggle());
        //joystickButtonAC6.whenPressed(new allPistonsOff());
    
    // Top Row of Buttons on Arcade Controller

    joystickButtonAC1.toggleWhenPressed(new frontPistonToggle());
    joystickButtonAC2.toggleWhenPressed(new backPistonToggle());
    joystickButtonAC3.whenPressed(new allPistonsOff());
    
    // Middle Row of Buttons on Arcade Controller
    joystickButtonAC4.whileHeld(new cargoIntake(.5));   
    joystickButtonAC5.whileHeld(new cargoIntake(.75));  
    joystickButtonAC6.whileHeld(new cargoIntake(-.6)); 
        
    // Bottom Row of Buttons on Arcade Controller       
    joystickButtonAC7.whenPressed(new cargoIntake(0));
    joystickButtonAC9.toggleWhenPressed(new hatchArmServo());

    SmartDashboard.putData("Drive Straight", new driveStraight());
    SmartDashboard.putData("Front Piston Toggle", new frontPistonToggle());
    SmartDashboard.putBoolean("Front piston status,", RobotMap.pneumaticSystemFrontSolenoid.get());

    }

    public Joystick getlogitechJoy() {
        return logitechLeft;
    }

    public Joystick getlogitechJoy2() {
        return logitechRight;
    }

    public Joystick getarcadeControlller() {
        return AC;
    }

}