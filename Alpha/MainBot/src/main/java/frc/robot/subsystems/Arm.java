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
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {

  private final WPI_TalonSRX PitchMotor = new WPI_TalonSRX(ArmConstants.CAN_Pitch);

  public void ArmUp(){
    PitchMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void ArmDown(){
    PitchMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void ArmIdle(){
    PitchMotor.set(ControlMode.PercentOutput, 0);
  }

  public Arm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
