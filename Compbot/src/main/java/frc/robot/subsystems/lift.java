/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class lift extends SubsystemBase {
  private WPI_VictorSPX m_extend = new WPI_VictorSPX(Constants.LiftConstants.extensionmotor);
  private WPI_VictorSPX m_winch = new WPI_VictorSPX(Constants.LiftConstants.winchmotor);

  public lift() {

  }

  @Override
  public void periodic() {
  
  }

  public void extend(Boolean inverted){
    m_extend.setInverted(inverted);
    m_extend.set(ControlMode.PercentOutput, 1);
  }

  public void retract(Boolean extendinverted, Boolean winchinverted){
    m_extend.setInverted(extendinverted);
    m_winch.setInverted(winchinverted);
    m_extend.set(ControlMode.PercentOutput, -1);
    m_winch.set(ControlMode.PercentOutput, 1);
  }

  public void idle(){
    m_winch.stopMotor();
    m_extend.stopMotor();
  }

}
