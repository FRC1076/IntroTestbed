package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public double appliedVoltage = 0;
        public double currentAmps = 0;

        public double rotations = 0;
    }

    /** Set the voltage of the motor */
    public abstract void setVoltage(double volts);

    public abstract void updateInputs(MotorIOInputs inputs);
}
