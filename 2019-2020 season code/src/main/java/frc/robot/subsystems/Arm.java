/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private static CANSparkMax ArmMotor = new CANSparkMax(Constants.ArmCan, MotorType.kBrushed);
  private static CANEncoder ArmEncoder = new CANEncoder(ArmMotor);
  private static CANPIDController PID = new CANPIDController(ArmMotor);
  /**
   * Creates a new Arm.
   */
  public Arm() {
    PID.setP(Constants.kP);
    PID.setI(Constants.kI);
    PID.setD(Constants.kD);
    PID.setIZone(Constants.kIz);
    PID.setFF(Constants.kFF);
    PID.setOutputRange(Constants.kminout, Constants.kmaxout);
  }
  public static void move (double setpoint){
    PID.setReference(setpoint, ControlType.kVelocity);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
