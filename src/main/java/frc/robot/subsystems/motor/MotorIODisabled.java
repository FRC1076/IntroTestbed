package frc.robot.subsystems.motor;

public class MotorIODisabled implements MotorIO {
    double voltageTarget = 0;

    @Override
    public void setVoltage(double volts) {
        voltageTarget = volts;
    }

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        inputs.appliedVoltage = voltageTarget;
    }
}
