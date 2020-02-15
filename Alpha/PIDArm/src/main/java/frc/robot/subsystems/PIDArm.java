/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.ArmConstants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class PIDArm extends PIDSubsystem {
  
  private final CANSparkMax PitchMotor = new CANSparkMax(ArmConstants.CAN_Pitch, MotorType.kBrushed);

  //private final CANEncoder ArmEncoder = new CANEncoder(PitchMotor);
  //private final CANEncoder ArmEncoder = SpinMotor.getEncoder(EncoderType.kQuadrature, 8192);
  private final Encoder ArmEncoder = new Encoder(4, 5, false, EncodingType.k4X);
  //Starting position reset at 0, fully down is -418.75, fully up in game position is -84.75

  public void ArmUp() {

  }

  public PIDArm() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
  }

  @Override
  public void useOutput(double output, double setpoint) {
    PitchMotor.set(output);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return ArmEncoder.getDistance();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("ArmPosition", ArmEncoder.getDistance());
  }
}
