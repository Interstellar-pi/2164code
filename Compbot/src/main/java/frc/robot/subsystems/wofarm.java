/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WOFConstants;

public class wofarm extends SubsystemBase {

   public DoubleSolenoid armSolenoid = new DoubleSolenoid(WOFConstants.pCM,WOFConstants.arm[0],WOFConstants.arm[1]);
   private WPI_TalonSRX m_spinner = new WPI_TalonSRX(WOFConstants.spinner);
  public wofarm() {

  }

  @Override
  public void periodic() {

  }

  public void stop()  {
    m_spinner.set(0);
  }
  
  public void armup() {
     armSolenoid.set(Value.kReverse);
   }
  
  public void armdown() {
    armSolenoid.set(Value.kForward);
  }

  public void spinmotor()  {
    m_spinner.set(1);
  }

  

}
