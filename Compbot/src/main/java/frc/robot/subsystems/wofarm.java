/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WOFConstants;

public class wofarm extends SubsystemBase {
  /**
   * Creates a new wofarm.
   */

   private DoubleSolenoid armSolenoid = new DoubleSolenoid(WOFConstants.pCM,WOFConstants.arm[0],WOFConstants.arm[1]);
   private CANSparkMax m_spinner = new CANSparkMax(WOFConstants.spinner, MotorType.kBrushed);
  public wofarm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void armmovement() {
  
    if(armSolenoid.get() == Value.kForward){
      armSolenoid.set(Value.kReverse);
    } else if(armSolenoid.get() == Value.kReverse){
      armSolenoid.set(Value.kForward);
    }

  }

}