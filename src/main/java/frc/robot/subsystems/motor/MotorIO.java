package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    @AutoLog
    public static class MotorIOInputs {
        public static double appliedVoltage = 0;
        public static double currentAmps = 0;
    }

    /** Set the voltage of the motor */
    public abstract void setVoltage(double volts);

    public abstract void updateInputs(MotorIOInputs inputs);
}
