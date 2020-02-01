/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;

public class Shooter extends CommandBase {

  private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(ArmConstants.CAN_Intake);

  public void Intake(){
    IntakeMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void Shoot(){
    IntakeMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void ShooterIdle(){
    IntakeMotor.set(ControlMode.PercentOutput, 0);
  }

  public Shooter() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
