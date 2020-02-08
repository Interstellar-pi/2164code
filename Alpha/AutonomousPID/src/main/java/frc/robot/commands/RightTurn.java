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
public class RightTurn extends PIDCommand {

  private final DriveTrain l_drivetrain;

  /**
   * Creates a new RightTurn.
   */
  public RightTurn(DriveTrain subsystem) {

    super(
        // The controller that the command will use
        new PIDController(0.025, 0.01, 0.1),
        // This should return the measurement
        () -> DriveTrain.Rotation(),
        // This should return the setpoint (can also be a constant)
        () -> -90,
        // This uses the output
        output -> {
          subsystem.DriveTurn(-output);
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    l_drivetrain = subsystem;
    addRequirements(subsystem);
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(15);
    getController().setIntegratorRange(-60, -80);
  }

  @Override
  public void initialize() {
    l_drivetrain.GyroReset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
