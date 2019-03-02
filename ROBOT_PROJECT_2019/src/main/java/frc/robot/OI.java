package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.allPistonsOff;
import frc.robot.commands.arcadeDriveBackwards;
import frc.robot.commands.backPistonToggle;
import frc.robot.commands.cargoIntake;
import frc.robot.commands.frontPistonToggle;
import frc.robot.commands.half;
import frc.robot.commands.hatchArmServo;
import frc.robot.commands.hatchTriangleServo;

public class OI {
    // left joystick buttons
    public Joystick logitechLeft;
    private JoystickButton joystickButtonL1;
    private JoystickButton joystickButtonL2;
    // right joystick buttons
    public Joystick logitechRight;
    private JoystickButton joystickButtonR1;
    private JoystickButton joystickButtonR3;
    // arcade buttons
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

    public OI() {
        // Make those Joysticks!
        logitechLeft = new Joystick(0);
        logitechRight = new Joystick(2);
        AC = new Joystick(1);

        // Arcade Controller buttons
        joystickButtonAC1 = new JoystickButton(AC, 1);
        joystickButtonAC2 = new JoystickButton(AC, 2);
        joystickButtonAC3 = new JoystickButton(AC, 3);
        joystickButtonAC4 = new JoystickButton(AC, 4);
        joystickButtonAC5 = new JoystickButton(AC, 5);
        joystickButtonAC6 = new JoystickButton(AC, 6);
        joystickButtonAC7 = new JoystickButton(AC, 7);
        joystickButtonAC8 = new JoystickButton(AC, 8);
        joystickButtonAC9 = new JoystickButton(AC, 9);

        // left joystick buttons
        joystickButtonL1 = new JoystickButton(logitechLeft, 1);
        joystickButtonL2 = new JoystickButton(logitechLeft, 2);

        joystickButtonR1 = new JoystickButton(logitechRight, 1);
        joystickButtonR3 = new JoystickButton(logitechRight, 3);
        joystickButtonR1.whileHeld(new cargoIntake(-.95));
        joystickButtonR3.whileHeld(new cargoIntake(.9));
        // Top Row of Buttons on Arcade Controller
        joystickButtonAC1.toggleWhenPressed(new frontPistonToggle());
        joystickButtonAC2.toggleWhenPressed(new backPistonToggle());
        joystickButtonAC3.whenPressed(new allPistonsOff());

        // Middle Row of Buttons on Arcade Controller
        joystickButtonAC4.whenPressed(new hatchArmServo(0)); // 0 Angle for arm is down
        joystickButtonAC5.whenPressed(new hatchArmServo(45)); // 45 is Angle for arm is part up
        joystickButtonAC6.whenPressed(new hatchArmServo(60)); // 90 is Angle for arm is fully up
        // Button 6 Unused
        // joystickButtonAC6.whileHeld(new cargoIntake(.6));

        // Bottom Row of Buttons on Arcade Controller
        joystickButtonAC7.whenPressed(new hatchTriangleServo(10)); // 0 Angle Up
        joystickButtonAC8.whenPressed(new hatchTriangleServo(100)); // 100 Angle Down
        joystickButtonL1.toggleWhenPressed(new arcadeDriveBackwards());
        // button 9 unused
        // joystickButtonAC9.whenPressed(new hatchArmServo(0));
    }

    public Joystick getLogitechJoy() {
        return logitechLeft;
    }

    public Joystick getLogitechJoy2() {
        return logitechRight;
    }

    public Joystick getArcadeControlller() {
        return AC;
    }
}