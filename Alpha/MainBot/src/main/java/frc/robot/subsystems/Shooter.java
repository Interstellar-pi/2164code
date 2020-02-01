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

public class Shooter extends SubsystemBase {

  private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(ArmConstants.CAN_Intake);

  public void Intake(){
    IntakeMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void Shoot(){
    IntakeMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void ShooterIdle(){
    IntakeMotor.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Creates a new Shooter.
   */
  public Shooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
