/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Cylinder;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutonomousRight extends SequentialCommandGroup {
  /**
   * Creates a new AutonomousRight.
   */
  public AutonomousRight(DriveTrain l_drivetrain, Cylinder l_cylinder) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new ForwardTen(l_drivetrain),
          new LeftTurn(l_drivetrain),
          new WaitCommand(0.2),
          new ForwardTwoFive(l_drivetrain),
          new RightTurn(l_drivetrain),
          new WaitCommand(0.2),
          new ForwardTwoFive(l_drivetrain),
          new WaitCommand(0.2),
          new CylinderForward(l_cylinder),
          new WaitCommand(0.2),
          new CylinderBack(l_cylinder),
          new WaitCommand(0.2),
          new BackOne(l_drivetrain),
          new RightTurn(l_drivetrain),
          new WaitCommand(0.2),
          new ForwardTwoFive(l_drivetrain),
          new RightTurn(l_drivetrain),
          new WaitCommand(0.2),
          new ForwardTen(l_drivetrain));
  }
}
