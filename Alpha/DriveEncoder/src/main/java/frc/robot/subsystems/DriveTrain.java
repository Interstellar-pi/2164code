/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.EncoderConstants;

public class DriveTrain extends SubsystemBase {

  public static DifferentialDrive DriveTrain = new DifferentialDrive(
      new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.LFMotor), new WPI_TalonSRX(DriveConstants.LRMotor)),
      new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.RFMotor), new WPI_TalonSRX(DriveConstants.RRMotor)));

  private static final ADIS16470_IMU BotIMU = new ADIS16470_IMU();

  private static final Encoder r_encoder = new Encoder(DriveConstants.r_encoder[0], DriveConstants.r_encoder[1], true);
  private static final Encoder l_encoder = new Encoder(DriveConstants.l_encoder[0], DriveConstants.l_encoder[1], false);
  private final double EncAvg = r_encoder.get() + l_encoder.get();

  public DriveTrain() {

  }

  public void MainDrive(double y, double z) {
    DriveTrain.arcadeDrive(-y, z*.5, false);
  }

  public void DriveTurn(double z) {
    DriveTrain.arcadeDrive(0.0, z, false);
  }

  public void GyroReset() {
    BotIMU.reset();
  }

  public static double GyroRaw() {
    return BotIMU.getAngle();
  }

  public static double GyroAngle() {
    return Math.IEEEremainder(BotIMU.getAngle(), 360);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Right Encoder Raw", r_encoder.getDistance());
    SmartDashboard.putNumber("Right Encoder Dist.", r_encoder.getDistance()*EncoderConstants.DPT);
    SmartDashboard.putNumber("Left Encoder Raw", l_encoder.getDistance());
    SmartDashboard.putNumber("Left Encoder Dist.", l_encoder.getDistance()*EncoderConstants.DPT);
    SmartDashboard.putNumber("Gyro Raw Angle", BotIMU.getAngle());
    SmartDashboard.putNumber("Gyro Rotation", GyroAngle());
    // This method will be called once per scheduler run
  }
}
