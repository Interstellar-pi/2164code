/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooter extends SubsystemBase {
  private WPI_TalonSRX m_roller = new WPI_TalonSRX(Constants.CollectorConstants.rollermotor);
  
  public shooter() {

  }

  @Override
  public void periodic() {
  }

  public void collect(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, -1.0);

  }

  public void idle()  {
    m_roller.set(0);
  }

  public void shoot(boolean inverted) {
    m_roller.setInverted(inverted);
    m_roller.set(ControlMode.PercentOutput, 1.0);
  }

}
