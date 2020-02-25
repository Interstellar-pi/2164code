/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  //private final WPI_TalonSRX LF = new WPI_TalonSRX(1);
  //private final WPI_TalonSRX LR = new WPI_TalonSRX(2);
  //private final WPI_TalonSRX RF = new WPI_TalonSRX(3);
  //private final WPI_TalonSRX RR = new WPI_TalonSRX(4);

  public final static DifferentialDrive MainDrive = new DifferentialDrive(
      new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(4)),
      new SpeedControllerGroup(new WPI_TalonSRX(1), new WPI_TalonSRX(2)));
  private static final Encoder EncR = new Encoder(Constants.ERC, Constants.ERC2);
  private static final Encoder EncL = new Encoder(Constants.ELC, Constants.ELC2);
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    EncL.setDistancePerPulse((4* Math.PI) / 280);
    EncL.setReverseDirection(true);
  }
  
  public static void drive(double Speed, double Turn) {
    MainDrive.arcadeDrive(Speed, -Turn);
  }

  public void PIDDrive(double speed) {
    MainDrive.arcadeDrive(speed, 0.0, false);
  }
  
  public double EncoderLeftGet(){
  double Value = EncL.getDistance();
    return Value;
  }
  public void reset(){
    EncL.reset();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
