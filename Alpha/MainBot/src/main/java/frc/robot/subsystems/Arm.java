/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm extends SubsystemBase {

  private final CANSparkMax PitchMotor = new CANSparkMax(ArmConstants.CAN_Pitch, MotorType.kBrushed);

  public void ArmUp(){
    PitchMotor.set(0.5);
    //PitchMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void ArmDown(){
    PitchMotor.set(-0.5);
    //PitchMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void ArmIdle(){
    PitchMotor.set(0.0);
    //PitchMotor.set(ControlMode.PercentOutput, 0);
  }

  public Arm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
