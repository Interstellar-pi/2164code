/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.ArmConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class PIDArm extends PIDSubsystem {
  
  private final CANSparkMax PitchMotor = new CANSparkMax(ArmConstants.CAN_Pitch, MotorType.kBrushed);

  //private final CANEncoder ArmEncoder = new CANEncoder(PitchMotor);
  //private final CANEncoder ArmEncoder = PitchMotor.getEncoder(EncoderType.kQuadrature, 8192);
  private final Encoder ArmEncoder = new Encoder(ArmConstants.EncoderPorts[0], ArmConstants.EncoderPorts[1], false, EncodingType.k4X);
  private final AnalogInput AbsArmEncoder = new AnalogInput(ArmConstants.AbsEncoderPort);
  //Starting position reset at 0, fully down is -418.75, fully up in game position is -84.75

  public PIDArm() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.5, .1, 0.05));
        setSetpoint(0);
        getController().setTolerance(15);
        //getController().set
        ArmEncoder.reset();
        //enable();
  }

  @Override
  public void useOutput(double output, double setpoint) {
    if(output >= 0.3) {
      output = 0.3;
    }else if(output <= -0.5) {
      output = -0.5;
    }
    if(getController().atSetpoint() == true) {
      output = 0;
    }
    PitchMotor.set(-output);
    SmartDashboard.putNumber("PIDOutput", -output);
    SmartDashboard.putNumber("PIDSetpoint", setpoint);
  }

  @Override
  public double getMeasurement() {
    SmartDashboard.putNumber("EncoderValue", ArmEncoder.getDistance());
    SmartDashboard.putNumber("AbsEncoderValue", AbsArmEncoder.getVoltage());
    // Return the process variable measurement here
    return ArmEncoder.getDistance();
  }

  public void Setpoint(double x) {
    super.setSetpoint(x);
    super.enable();
  }

  public void EncoderReset() {
    ArmEncoder.reset();
    super.disable();
  }

  public void PIDDisable() {
    super.disable();
  }
}