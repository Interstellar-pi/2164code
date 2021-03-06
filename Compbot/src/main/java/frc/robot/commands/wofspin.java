/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.wofarm;

public class wofspin extends CommandBase {
  private final wofarm s_WOFArm;
  /**
   * Creates a new wofspin.
   */
  public wofspin(wofarm subsystem) {
    
    s_WOFArm = subsystem;
    addRequirements(s_WOFArm);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    s_WOFArm.spinmotor();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
