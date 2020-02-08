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
import frc.robot.Constants.PCMConstants;

public class Cylinder extends SubsystemBase {

  private final DoubleSolenoid CylinderSol = new DoubleSolenoid(PCMConstants.PCM, PCMConstants.CylinderSol[0], PCMConstants.CylinderSol[1]);

  public Cylinder() {
  }

  public void CylinderForward() {
    CylinderSol.set(Value.kForward);
  }

  public void CylinderBackward() {
    CylinderSol.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
