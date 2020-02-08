/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class lturnpid extends PIDCommand {
private final drivetrain s_Drivetrain;

  /**
   * Creates a new trunpid.
   */
  public lturnpid(drivetrain drivesystem) {
    super(
        // The controller that the command will use
        new PIDController(0.1, 0.5, 0.0125),
        // This should return the measurement
        () -> drivesystem.imu.getAngle(),
        // This should return the setpoint (can also be a constant)
        () -> 90.5,
        // This uses the output
        output -> { drivesystem.drivectrl(0.0, output);
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
        s_Drivetrain = drivesystem;
    addRequirements(drivesystem);
      getController().setTolerance(0.2);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }


  @Override
  public void initialize() {
    s_Drivetrain.imu.reset();
  }

  @Override
  public void end(boolean interrupted) {
  }

}
