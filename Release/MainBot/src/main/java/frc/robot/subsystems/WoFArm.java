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

public class WoFArm extends SubsystemBase {

  private final DoubleSolenoid WoFSolenoid = new DoubleSolenoid(WoFConstants.CAN_PCM, WoFConstants.PCM_WoFSol[0], WoFConstants.PCM_WoFSol[1]);

  public void WoFSolenoid(){
    if(WoFSolenoid.get() == Value.kForward){
      WoFSolenoid.set(Value.kReverse);
    }else{
      WoFSolenoid.set(Value.kForward);
    }
  }

  public WoFArm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
