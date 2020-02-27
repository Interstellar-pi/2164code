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
public class Turn_R extends PIDCommand {

  private final DriveTrain m_drivetrain;
  /**
   * Creates a new Turn_R.
   */
  public Turn_R(DriveTrain subsystem) {
    super(
        // The controller that the command will use
        new PIDController(0.05, 0.005, 0.011),
        // This should return the measurement
        () -> DriveTrain.GyroRaw(),
        // This should return the setpoint (can also be a constant)
        () -> -89,
        // This uses the output
        output -> {
          subsystem.DriveTurn(-output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = subsystem;
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(0.5);
  }

  @Override
  public void initialize() {
    m_drivetrain.GyroReset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
