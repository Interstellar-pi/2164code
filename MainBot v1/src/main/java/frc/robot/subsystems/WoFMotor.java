/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WoFConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class WoFMotor extends SubsystemBase {

  private final CANSparkMax SpinMotor = new CANSparkMax(WoFConstants.CAN_Spin, MotorType.kBrushed);

  public void WoFSpin(){
    SpinMotor.set(0.5);
  }

  public void WoFIdle(){
    SpinMotor.set(0);
  }

  public WoFMotor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
