package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
    private final MotorIO io;
    private final MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();

    public MotorSubsystem(MotorIO io) {
        this.io = io;
    }

    /** Set the voltage of the motor */
    public void setVoltage(double volts) {
        io.setVoltage(volts);
    }

    /** Stop the motor by setting its voltage to zero */
    public void stop() {
        io.setVoltage(0);
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Motor", inputs);
    }
}
