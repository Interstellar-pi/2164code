/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

public class pneumatics extends SubsystemBase {
  public pneumatics() {


  }


  private final DoubleSolenoid p_shifter = 
    new DoubleSolenoid(12, Constants.PneumaticsConstants.shifterPorts[0], Constants.PneumaticsConstants.shifterPorts[1]);

  @Override
  public void periodic() {
  }

  public void high(){
    p_shifter.set(kForward);
  }

  public void low(){
    p_shifter.set(kReverse);
  }


}
