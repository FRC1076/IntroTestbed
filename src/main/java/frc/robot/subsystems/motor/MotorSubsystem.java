package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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

    /** Get number of rotations */
    public double getRotations() {
        return inputs.rotations;
    }

    /** Returns a command that runs the motor at the desired speed */
    public Command runVolts(double volts) {
        return Commands.runOnce(
            () -> setVoltage(volts),
            this
        );
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Motor", inputs);
    }
}
