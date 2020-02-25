/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCollector;

public class BallCollectorU extends CommandBase {
  private BallCollector C_subsystem;
  
  /**
   * Creates a new BallCollectorU.
   */
  public BallCollectorU(BallCollector subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    C_subsystem = subsystem;
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double EP = C_subsystem.EP();
    CANPIDController PID = C_subsystem.PID;
    
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
