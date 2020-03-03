/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pnuematics extends SubsystemBase {
  private static Compressor comp = new Compressor(12);
  private static DoubleSolenoid Shifter = new DoubleSolenoid(12,0,1);
  
  /**
   * Creates a new Pnuematics.
   */
  public Pnuematics() {

  }
    public static void Shifters(){
      Shifter.set(Value.kForward);}
      public static void ShiftersDefault(){
        Shifter.set(Value.kReverse);
      }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
