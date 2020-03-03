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

public class Pnuematics2 extends SubsystemBase {
  private static final DoubleSolenoid UpDown = new DoubleSolenoid(12,2,4);
  /**
   * Creates a new Pnuematics2.
   */
  public Pnuematics2() {

  }
  public void InOut(boolean In){
    if (In){
      UpDown.set(Value.kReverse);
    }else{
      UpDown.set(Value.kForward);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
