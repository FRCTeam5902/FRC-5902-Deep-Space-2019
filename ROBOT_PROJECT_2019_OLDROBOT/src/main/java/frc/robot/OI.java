package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.arcadeDriveBackwards;

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
        
        joystickButtonL1.toggleWhenPressed(new arcadeDriveBackwards());
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