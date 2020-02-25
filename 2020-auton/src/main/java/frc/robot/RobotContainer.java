/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.NormDrive;
import frc.robot.commands.liftDown;
import frc.robot.commands.liftStop;
import frc.robot.commands.liftUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.lift;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Joystick joy = new Joystick(Constants.joyID);
  public final DriveTrain S_drive = new DriveTrain();
  public final NormDrive C_drive = new NormDrive(S_drive, joy);
  private final lift S_lift = new lift();
  private final liftStop C_liftS = new liftStop(S_lift);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    S_drive.setDefaultCommand(C_drive);
    S_lift.setDefaultCommand(C_liftS);
    joy.setXChannel(Constants.joyX);
    joy.setYChannel(Constants.joyY);
    joy.setZChannel(Constants.joyZ);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
}


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
