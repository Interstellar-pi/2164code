/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ForwardTwoFive extends PIDCommand {

  private final DriveTrain l_drivetrain;
  /**
   * Creates a new ForwardFiveHalf.
   */
  public ForwardTwoFive(DriveTrain subsystem) {
    super(
        // The controller that the command will use
        new PIDController(1.0, 0.07, 0.1),
        // This should return the measurement
        () -> DriveTrain.GetEncoderValue(),
        // This should return the setpoint (can also be a constant)
        () -> 1.5,
        // This uses the output
        output -> {
          subsystem.PIDDrive(-output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    l_drivetrain = subsystem;
    addRequirements(subsystem);
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(0.1);
    getController().setIntegratorRange(0.5, 2.0);
  }

  @Override
  public void initialize() {
    l_drivetrain.Reset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
