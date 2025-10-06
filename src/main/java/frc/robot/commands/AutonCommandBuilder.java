package frc.robot.commands;

import frc.robot.subsystems.motor.MotorSubsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class AutonCommandBuilder {
    List<Command> commands = new ArrayList<Command>();











    /** NEW MEMBERS: INSIDE run() IS WHERE YOU WRITE YOUR CODE */
    public void run() {
        /*
         * Commands:
         * setVoltage(voltage) - Sets the voltage the motor runs at until stopped
         * waitSeconds(seconds) - Waits for the specified number of seconds
         * waitUntil(condition) - Waits until the condition inside is true (see options below)
         * 
         * Conditions:
         * rotationsTraveledEquals(count) - True if the rotations traveled by the motor equals count
         * rotationsTraveledGreaterThan(count) - True if the rotations traveled by the motor is more than count
         * rotationsTraveledLessThan(count) - True if the rotations traveled by the motor is less than count 
         * 
         * HINT: Rotations traveled goes backward if voltage is negative.
         */

        
    }
    /** NEW MEMBERS: WRITE YOUR CODE IN run() ABOVE */


















    // Other stuff
    MotorSubsystem m_motor;

    public AutonCommandBuilder(MotorSubsystem motor) {
        this.m_motor = motor;
    }

    public Command getAutonCommand() {
        run();

        return Commands.sequence(
            commands.toArray(new Command[0])
        );
    }

    // Commands
    private void setVoltage(double volts) {
        commands.add(m_motor.runVolts(volts));
    }

    /** For people who want to do special things */
    private void setVoltageToSupplierUntil(DoubleSupplier voltage, Command waitCommand) {
        commands.add(
            Commands.run(() -> m_motor.setVoltage(voltage.getAsDouble()), m_motor).raceWith(waitCommand)
        );
    }

    private void waitSeconds(double seconds) {
        commands.add(Commands.waitSeconds(seconds));
    }

    private void waitUntil(BooleanSupplier condition) {
        commands.add(Commands.waitUntil(condition));
    }

    // Get the number of rotations traveled
    private double getRotationsTraveled() {
        return m_motor.getRotations();
    }

    // Conditions
    private BooleanSupplier rotationsTraveledEquals(double rotations) {
        return () -> (getRotationsTraveled() == rotations);
    }

    private BooleanSupplier rotationsTraveledGreaterThan(double rotations) {
        return () -> (getRotationsTraveled() > rotations);
    }

    private BooleanSupplier rotationsTraveledLessThan(double rotations) {
        return () -> (getRotationsTraveled() < rotations);
    }
}