/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class lift extends SubsystemBase {
  //private final VictorSPX LM = new VictorSPX(Constants.LC);
  //private final VictorSPX LM2 = new VictorSPX(Constants.LC2);
  private final CANSparkMax LM = new CANSparkMax(Constants.LC, MotorType.kBrushed);
  /**
   * Creates a new lift.
   */
  public lift() {
    
  }
  public void PLU(double speed){
    LM.set( speed);
    //LM2.set(ControlMode.PercentOutput, speed);
  
  }
  public void PLD(double speed){
    LM.set( speed);
    //LM2.set(ControlMode.PercentOutput, speed / Constants.LiftMultiplier);
  }
  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
