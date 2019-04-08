package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidWrapper extends Solenoid {

    private boolean lastValue = false;

    SolenoidWrapper(int channel) {
        super(channel);
    }

    public void set(boolean on) {
        lastValue = on;
        super.set(on);
    }

    @Override
    public boolean get() {
        return lastValue;
    }
}