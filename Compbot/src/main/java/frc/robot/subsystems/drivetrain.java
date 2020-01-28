/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase {
  /**
   * Creates a new drivetrain.
   */

  SpeedControllerGroup right = new SpeedControllerGroup(new WPI_TalonSRX(Constants.DriveConstants.rF),new WPI_VictorSPX(Constants.DriveConstants.rR));
  SpeedControllerGroup left = new SpeedControllerGroup(new WPI_TalonSRX(Constants.DriveConstants.lF),new WPI_VictorSPX(Constants.DriveConstants.lR));
    DifferentialDrive drive = new DifferentialDrive(left, right);

  public drivetrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drivectrl(Double x,Double z) {
    drive.arcadeDrive(x, z);
  }  

}
