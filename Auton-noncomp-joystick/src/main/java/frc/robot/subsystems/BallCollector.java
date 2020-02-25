/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallCollector extends SubsystemBase {
  //private final CANSparkMax UD = new CANSparkMax(Constants.UDMC, MotorType.kBrushed);
  private final WPI_TalonSRX IO = new WPI_TalonSRX(Constants.IOC);
  private final WPI_TalonSRX UD = new WPI_TalonSRX(Constants.UDMC);
  /**
   * Creates a new BallCollector.
   */
  public BallCollector() {

  }
  public void UD(double speed){
    UD.set(speed);
  }
  public void IO(double speed){
    IO.set(speed);
  }
  public double ED() {
    
    return 0;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
