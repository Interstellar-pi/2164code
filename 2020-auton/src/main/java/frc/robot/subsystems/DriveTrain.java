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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class DriveTrain extends SubsystemBase {
  private double L_speed;
  private double R_speed;
  private final static DifferentialDrive MainDrive = new DifferentialDrive(
    new SpeedControllerGroup(new WPI_TalonSRX(Constants.FLC),new WPI_TalonSRX(2)),
    new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(4)) );
    private final Encoder ER = new Encoder(0, 1);
    private final Encoder EL = new Encoder(8, 9);
     
    /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    ER.setDistancePerPulse(Constants.EDPP);
    EL.setDistancePerPulse(Constants.EDPP);
  }
  public static void Drive(double Speed, double Turn){
    MainDrive.arcadeDrive(Speed, -Turn);
  }
  public double ERD () {
    
    double ERP = ER.getDistance();
    return ERP;
  }public double ELD () {
    double ELD = EL.getDistance();
    return ELD;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
