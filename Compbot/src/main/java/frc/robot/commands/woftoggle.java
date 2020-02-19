/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.wofarm;

public class woftoggle extends CommandBase {
  private final wofarm wofarm;
  /**
   * Creates a new woftoggle.
   */
  public woftoggle(wofarm subsystem) {
    
    wofarm = subsystem;
    addRequirements(subsystem);
  }
  
  @Override
  public void initialize() {
    wofarm.armmovement();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
