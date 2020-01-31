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
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  
  private final WPI_TalonSRX RFMotor = new WPI_TalonSRX(DriveConstants.CAN_RF);
  private final WPI_VictorSPX RRMotor = new WPI_VictorSPX(DriveConstants.CAN_RR);
  private final WPI_TalonSRX LFMotor = new WPI_TalonSRX(DriveConstants.CAN_LF);
  private final WPI_VictorSPX LRMotor = new WPI_VictorSPX(DriveConstants.CAN_LR);

  private final SpeedControllerGroup RDrive = new SpeedControllerGroup(RFMotor, RRMotor);
  private final SpeedControllerGroup LDrive = new SpeedControllerGroup(LFMotor, LRMotor);

  private final DifferentialDrive MainDrive = new DifferentialDrive(LDrive, RDrive);

  public void Drive(double y, double z) {

    MainDrive.arcadeDrive(y,z, false);
    
  }

  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
