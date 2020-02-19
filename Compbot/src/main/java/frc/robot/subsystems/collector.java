/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class collector extends PIDSubsystem {

  private WPI_TalonSRX m_roller = new WPI_TalonSRX(Constants.CollectorConstants.rollermotor);
  private CANSparkMax m_pitch = new CANSparkMax(Constants.CollectorConstants.pitchmotor, MotorType.kBrushed);
  private Encoder e_PitchEncoder = new Encoder(Constants.CollectorConstants.sensorPorts[0],
                                               Constants.CollectorConstants.sensorPorts[1]);
  
  /**
   * Creates a new collector.
   */
  public collector() {
    super(
        // The PIDController used by the subsystem
        new PIDController(.75, 0, 0));
        getController().setTolerance(3);
        enable();
        
  }

  @Override
  public void useOutput(double output, double setpoint) {
    m_pitch.set(-output);
    SmartDashboard.putNumber("Output", output);
    // Use the output here
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return e_PitchEncoder.get();
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm Position", e_PitchEncoder.getDistance());
  }

  public void ereset(){
    e_PitchEncoder.reset();
  }

  public void collect(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, -1.0);

  }

  public void shoot(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, 1.0);
  }

  public void changeSetpoint(double setpoint) {
    super.getController().setSetpoint(setpoint);
  }
/*
  public void uppos()  {
    super.getController().setSetpoint(-84.75);
  }

  public void dwnpos()  {
    super.getController().setSetpoint(-418.75);
  }
*/

}
