/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.Drive;
import frc.robot.commands.LiftExtend;
import frc.robot.commands.LiftWinch;
import frc.robot.commands.WoFArm;
import frc.robot.commands.WoFSpin;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.WoF;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Define OI here
  public Joystick JS1 = new Joystick(OIConstants.JS1);
  public JoystickButton ShootButton = new JoystickButton(JS1, OIConstants.ShootButton);
  public JoystickButton IntakeButton = new JoystickButton(JS1, OIConstants.IntakeButton);
  public JoystickButton ArmUpButton = new JoystickButton(JS1, OIConstants.ArmUpButton);
  public JoystickButton ArmDownButton = new JoystickButton(JS1, OIConstants.ArmDownButton);
  public JoystickButton LiftExtendButton = new JoystickButton(JS1, OIConstants.LiftExtensionButton);
  public JoystickButton LiftWinchButton = new JoystickButton(JS1, OIConstants.LiftWinchButton);
  public JoystickButton WoFArmButton = new JoystickButton(JS1, OIConstants.WoFArmButton);
  public JoystickButton WoFSpinButton = new JoystickButton(JS1, OIConstants.WoFSpinButton);

  // The robot's subsystems and commands are defined here...
  private final DriveTrain rc_DriveTrain = new DriveTrain();
  private final Drive rc_Drive = new Drive(rc_DriveTrain, JS1);
  private final Arm rc_Arm = new Arm();
  private final ArmUp rc_ArmUp = new ArmUp(rc_Arm);
  private final ArmDown rc_ArmDown = new ArmDown(rc_Arm);
  private final Shooter rc_Shooter = new Shooter();
  private final Lift rc_Lift = new Lift();
  private final LiftExtend rc_LiftExtend = new LiftExtend(rc_Lift);
  private final LiftWinch rc_LiftWinch = new LiftWinch(rc_Lift);
  private final WoF rc_WoF = new WoF();
  private final WoFArm rc_WoFArm = new WoFArm(rc_WoF);
  private final WoFSpin rc_WoFSpin = new WoFSpin(rc_WoF);





  

  public RobotContainer() {
    // Default Command
    rc_DriveTrain.setDefaultCommand(rc_Drive);
    // Configure the button bindings
    configureButtonBindings();
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
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
