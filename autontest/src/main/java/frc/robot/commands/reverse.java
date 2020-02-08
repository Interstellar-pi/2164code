/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;

public class reverse extends CommandBase {
  private final drivetrain s_Drivetrain;
  private boolean done = false;
  /**
   * Creates a new reverse.
   */
  public reverse(drivetrain drivesystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_Drivetrain = drivesystem;
    addRequirements(drivesystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Drivetrain.drivectrl(1.0, 0.0);
    //Timer.delay(2);
    done = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_Drivetrain.drivectrl(0.0, 0.0); 
  }

  // Returns true when the command should end.
  
  @Override
  public boolean isFinished() {
  return false;
  }
}
