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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class collector extends SubsystemBase {
  /**
   * Creates a new collector.
   */

   private WPI_TalonSRX m_roller = new WPI_TalonSRX(Constants.CollectorConstants.rollermotor);
   private CANSparkMax m_pitch = new CANSparkMax(Constants.CollectorConstants.pitchmotor, MotorType.kBrushed);
  public collector() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void collect(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, -1.0);

  }

  public void shoot(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, 1.0);
  }

  public void uppos(boolean inverted)  {
    m_pitch.setInverted(inverted);
    m_pitch.set(1);
  }

  public void dwnpos(boolean inverted)  {
    m_pitch.setInverted(inverted);
    m_pitch.set(-1);
  }




}
