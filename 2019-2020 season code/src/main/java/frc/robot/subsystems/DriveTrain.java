/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private static WPI_TalonSRX FrontLeft = new WPI_TalonSRX(Constants.FrontLeftCan);
  private static WPI_TalonSRX RearLeft = new WPI_TalonSRX(Constants.RearLeftCan);
  private static WPI_TalonSRX FrontRight = new WPI_TalonSRX(Constants.FrontRightCan);
  private static WPI_TalonSRX RearRight = new WPI_TalonSRX(Constants.RearRightCan);
  private static Encoder RightEncoder = new Encoder(Constants.RightEncodervalue1, Constants.RightEncodervalue2);
  private static Encoder LeftEncoder = new Encoder(Constants.LeftEncodervalue1, Constants.LeftEncodervalue2);
  private static SpeedControllerGroup Right = new SpeedControllerGroup(FrontRight, RearRight);
  private static SpeedControllerGroup Left = new SpeedControllerGroup(FrontLeft, RearLeft);
  private static DifferentialDrive DriveTrain = new DifferentialDrive(Left, Right);
  private static AnalogGyro Gyro = new AnalogGyro(0);
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    RightEncoder.reset();
    LeftEncoder.reset();
    RightEncoder.setDistancePerPulse(Constants.RightPerPulse);
    LeftEncoder.setDistancePerPulse(Constants.LeftPerPulse);
    Gyro.calibrate();
  }
  public static void NormalDrive (double Speed,double Turn){
    DriveTrain.arcadeDrive(Speed, -Turn);
  }
  public static void DirectDrive(double RightSpeed, double LeftSpeed){
    Right.set(RightSpeed);
    Left.set(LeftSpeed);
  }
  public static double RightDistance(){
    return(RightEncoder.getDistance());
  }
  public static double LeftDistance(){
    return(LeftEncoder.getDistance());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
