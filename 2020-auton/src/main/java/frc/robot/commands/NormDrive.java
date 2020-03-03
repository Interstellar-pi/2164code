/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class NormDrive extends CommandBase {
  private DriveTrain M_Subsystem;
  private Joystick M_Joy;
  /**
   * Creates a new NormDrive.
   */
  public NormDrive(DriveTrain Subsystem, Joystick Joy) {
    M_Subsystem = Subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Subsystem);
    M_Joy = Joy;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    M_Subsystem.Drive(M_Joy.getY() * 0.7, M_Joy.getZ() * 0.3);
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
