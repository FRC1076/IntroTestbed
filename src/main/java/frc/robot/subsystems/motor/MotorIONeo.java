package frc.robot.subsystems.motor;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.MotorConstants;

public class MotorIONeo implements MotorIO {
    private final SparkMax m_motor;
    private final SparkMaxConfig m_motorConfig;
    
    public MotorIONeo() {
        m_motor = new SparkMax(MotorConstants.kCanId, MotorType.kBrushless);
        m_motorConfig = new SparkMaxConfig();

        m_motorConfig
            .inverted(MotorConstants.kInverted)
            .idleMode(MotorConstants.kIdleMode)
            .smartCurrentLimit(MotorConstants.kCurrentLimitAmps);

        m_motor.configure(
            m_motorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    @Override
    public void setVoltage(double volts) {
        m_motor.setVoltage(volts);
    }

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        inputs.appliedVoltage = m_motor.getAppliedOutput() * m_motor.getBusVoltage();
        inputs.currentAmps = m_motor.getOutputCurrent();
    }
}
