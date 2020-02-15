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
import frc.robot.Constants.LiftConstants;

public class LiftWincher extends SubsystemBase {

  private final WPI_VictorSPX WinchMotor = new WPI_VictorSPX(LiftConstants.CAN_Winch);

  public void LiftWinch(){
    WinchMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void LiftWinchReverse(){
    WinchMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void LiftWinchIdle(){
    WinchMotor.set(ControlMode.PercentOutput, 0);
  }

  public LiftWincher() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
