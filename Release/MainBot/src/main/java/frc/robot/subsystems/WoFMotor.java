/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WoFConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class WoFMotor extends SubsystemBase {

  private final WPI_TalonSRX SpinMotor = new WPI_TalonSRX(WoFConstants.CAN_Spin);

  public void WoFSpin(){
    SpinMotor.set(ControlMode.PercentOutput, 0.5);
    //SpinMotor.set(0.5);
  }

  public void WoFIdle(){
    SpinMotor.set(ControlMode.PercentOutput, 0.0);
    //SpinMotor.set(0);
  }

  public WoFMotor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
