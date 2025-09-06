package frc.robot.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.motor.MotorSubsystem;

public class AutonCommandBuilder {
    List<Command> commands = new ArrayList<Command>();











    /** NEW MEMBERS: INSIDE run() IS WHERE YOU WRITE YOUR CODE */
    public void run() {

        setVoltage(2);
        waitSeconds(1);

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
            (Command[]) commands.toArray()
        );
    }

    // Commands
    private void setVoltage(double volts) {
        commands.add(m_motor.runVolts(volts));
    }

    private void waitSeconds(double seconds) {
        commands.add(Commands.waitSeconds(seconds));
    }

    private void waitUntil(BooleanSupplier condition) {
        commands.add(Commands.waitUntil(condition));
    }

    // Conditions
    private BooleanSupplier rotationsTraveledEquals(double rotations) {
        return () -> (m_motor.getRotations() == rotations);
    }

    private BooleanSupplier rotationsTraveledGreaterThan(double rotations) {
        return () -> (m_motor.getRotations() > rotations);
    }

    private BooleanSupplier rotationsTraveledLessThan(double rotations) {
        return () -> (m_motor.getRotations() < rotations);
    }
}