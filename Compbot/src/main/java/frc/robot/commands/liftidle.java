/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.lift;

public class liftidle extends CommandBase {
  private final lift s_Lift;

  public liftidle(lift subsystem) {
    
    s_Lift = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    s_Lift.idle();
  }

  @Override
  public void end(boolean interrupted) {
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }
}
