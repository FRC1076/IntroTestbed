package frc.robot.subsystems.motor;

import static frc.robot.Constants.MotorConstants.kFreeSpeedRPM;

public class MotorIODisabled implements MotorIO {
    double voltageTarget = 0;

    @Override
    public void setVoltage(double volts) {
        voltageTarget = volts;
    }

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        inputs.appliedVoltage = voltageTarget;
        inputs.rotations += ((kFreeSpeedRPM / 3000.0) / 12.0) * voltageTarget; // Revolutions per 20 ms per volt
    }
}
