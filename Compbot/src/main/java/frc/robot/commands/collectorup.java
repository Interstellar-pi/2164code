/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector;

public class collectorup extends CommandBase {
  private final collector s_Collector;

  public collectorup(collector subsystem) {
    s_Collector = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    //s_Collector.changeSetpoint(-84.75);
    s_Collector.uppos();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;//s_Collector.getController().atSetpoint();
  }
}
