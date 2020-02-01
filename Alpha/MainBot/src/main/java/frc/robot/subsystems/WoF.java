/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WoFConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class WoF extends SubsystemBase {

  private final CANSparkMax SpinMotor = new CANSparkMax(WoFConstants.CAN_Spin, MotorType.kBrushed);
  private final DoubleSolenoid WoFSolenoid = new DoubleSolenoid(WoFConstants.PCM_Port0, WoFConstants.PCM_Port1);

  public void WoFSpin(){
    SpinMotor.set(0.5);
  }

  public void WoFIdle(){
    SpinMotor.set(0);
  }

  public void WoFSolenoid(){
    if(WoFSolenoid.get() == Value.kForward){
      WoFSolenoid.set(Value.kReverse);
    }else{
      WoFSolenoid.set(Value.kForward);
    }
  }

  public WoF() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
