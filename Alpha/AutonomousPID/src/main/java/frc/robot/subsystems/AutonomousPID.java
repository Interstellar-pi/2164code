/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.DriveConstants;

public class AutonomousPID extends PIDSubsystem {

  private final WPI_TalonSRX RFMotor = new WPI_TalonSRX(DriveConstants.CAN_RF);
  private final WPI_TalonSRX RRMotor = new WPI_TalonSRX(DriveConstants.CAN_RR);
  private final WPI_TalonSRX LFMotor = new WPI_TalonSRX(DriveConstants.CAN_LF);
  private final WPI_TalonSRX LRMotor = new WPI_TalonSRX(DriveConstants.CAN_LR);

  private final SpeedControllerGroup RDrive = new SpeedControllerGroup(RFMotor, RRMotor);
  private final SpeedControllerGroup LDrive = new SpeedControllerGroup(LFMotor, LRMotor);

  private final DifferentialDrive MainDrive = new DifferentialDrive(LDrive, RDrive);

  private Encoder LeftEncoder = new Encoder(6, 7, false, EncodingType.k4X);

  private final double EncoderConversion = 1.0/280 * 3.9 * Math.PI/12;

  double SensorPos = LeftEncoder.get() * EncoderConversion;
  /**
   * Creates a new AutonomousPID.
   */
  public AutonomousPID() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }
}
