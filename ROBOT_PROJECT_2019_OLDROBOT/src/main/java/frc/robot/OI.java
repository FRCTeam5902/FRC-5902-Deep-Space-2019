package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
     // right joystick buttons
     public XboxController xbox;

    public OI() {
        // Make those Joysticks!
        logitechLeft = new Joystick(0);
        logitechRight = new Joystick(2);
        xbox= new XboxController(0);

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
    public XboxController getXbox() {
        return xbox;
    }
    
}