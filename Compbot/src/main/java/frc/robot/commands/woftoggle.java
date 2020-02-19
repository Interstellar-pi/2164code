/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.wofarm;

public class woftoggle extends CommandBase {
  private final wofarm s_WOFArm;
  /**
   * Creates a new woftoggle.
   */
  public woftoggle(wofarm subsystem) {
    
    s_WOFArm = subsystem;
    addRequirements(subsystem);
  }
  
  @Override
  public void initialize() {
    if(s_WOFArm.armSolenoid.get() == Value.kForward){
    s_WOFArm.armup();
    } else if(s_WOFArm.armSolenoid.get() == Value.kReverse){
      s_WOFArm.armdown();
    }
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
