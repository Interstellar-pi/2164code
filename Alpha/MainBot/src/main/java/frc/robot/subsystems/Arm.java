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

  private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(ArmConstants.CAN_Intake);
  private final WPI_TalonSRX PitchMotor = new WPI_TalonSRX(ArmConstants.CAN_Pitch);

  public void Intake(boolean active){
    if(active == true){
      IntakeMotor.set(ControlMode.PercentOutput, 0.5);
    }else if(active != true){
      IntakeMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public void Shoot(boolean active){
    if(active == true){
      IntakeMotor.set(ControlMode.PercentOutput, -0.5);
    }else if(active != true){
      IntakeMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public void ArmUp(boolean active){
    if(active == true){
      PitchMotor.set(ControlMode.PercentOutput, 0.5);
    }else if (active != true){
      PitchMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public void ArmDown(boolean active){
    if(active == true){
      PitchMotor.set(ControlMode.PercentOutput, -0.5);
    }else if (active != true){
      PitchMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public Arm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
