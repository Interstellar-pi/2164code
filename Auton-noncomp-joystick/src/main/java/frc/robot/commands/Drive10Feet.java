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
public class Drive10Feet extends PIDCommand {
  DriveTrain Subsystem;
  /**
   * Creates a new Drive10Feet.
   */
  public Drive10Feet(DriveTrain subsystem) {
    
    super(
        // The controller that the command will use
        new PIDController(0.1, 0.1, .07),
        // This should return the measurement
        () -> subsystem.EncoderLeftGet(),
        // This should return the setpoint (can also be a constant)
        10*12,
        // This uses the output
        output -> {
          // Use the output here
          subsystem.drive(-output,0);
          System.out.println(-output);
          System.out.println(subsystem.EncoderLeftGet());
          System.out.println();
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    // Configure additional PID options by calling `getController` here.
        Subsystem = subsystem;
        getController().setIntegratorRange(8.5*12 , 11*12 );
        getController().setTolerance(.4 );
        
      }
  @Override
  public void initialize() {
    Subsystem.reset();
    // TODO Auto-generated method stub
    super.initialize();
  }
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    super.execute();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
