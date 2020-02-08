/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import java.lang.Math;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.EncoderConstants;

public class DriveTrain extends SubsystemBase {

  private final DifferentialDrive MainDrive = new DifferentialDrive
        (new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.CAN_LF), new WPI_TalonSRX(DriveConstants.CAN_LR)),
         new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.CAN_RF), new WPI_TalonSRX(DriveConstants.CAN_RR)));

  private static Encoder LeftEncoder = new Encoder(EncoderConstants.LeftEncoder[0], EncoderConstants.LeftEncoder[1], false, EncodingType.k4X);

  private static Gyro LocalGyro = new ADIS16470_IMU();

  public DriveTrain() {

  }

  public static double GetGyro() {
    return LocalGyro.getAngle();
  }

  public void GyroReset() {
    LocalGyro.reset();
  }

  public void DriveTurn(double z) {
    MainDrive.arcadeDrive(0.0, -z, false);
  }

  public static double Rotation() {
    return Math.IEEEremainder(LocalGyro.getAngle(), 360);
  }

  public static double GetEncoderValue() {
    return LeftEncoder.get()*EncoderConstants.DPT;
  }

  public void StickDrive(double y, double z) {
    MainDrive.arcadeDrive(y,-z,false);
  }

  public void PIDDrive(double y) {
    MainDrive.arcadeDrive(y,0.0,false);
  }

  public void Reset() {
    LeftEncoder.reset();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Raw Gyro Angle", LocalGyro.getAngle());
    SmartDashboard.putNumber("Adjusted Gyro Angle", Rotation());
    // This method will be called once per scheduler run
  }
}
