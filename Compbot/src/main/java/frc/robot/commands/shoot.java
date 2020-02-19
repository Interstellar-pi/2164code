/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.collector;

public class shoot extends CommandBase {
  private final collector collector;

  public shoot(collector subsystem) {
    
    collector = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() { 
    collector.shoot(Constants.CollectorConstants.rollerinverted);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
