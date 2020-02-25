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
import frc.robot.commands.ArmIdle;
import frc.robot.commands.ArmUp;
import frc.robot.commands.CollectorIdle;
import frc.robot.commands.CollectorIntake;
import frc.robot.commands.CollectorShoot;
import frc.robot.commands.Drive;
import frc.robot.commands.LiftExtend;
import frc.robot.commands.LiftExtenderIdle;
import frc.robot.commands.LiftExtenderRetract;
import frc.robot.commands.LiftWinch;
import frc.robot.commands.LiftWincherIdle;
import frc.robot.commands.LiftWincherLoosen;
import frc.robot.commands.WoFArmToggle;
import frc.robot.commands.WoFMotorIdle;
import frc.robot.commands.WoFMotorSpin;
import frc.robot.subsystems.WoFArm;
import frc.robot.subsystems.WoFMotor;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LiftExtender;
import frc.robot.subsystems.LiftWincher;
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
  public JoystickButton ArmDownButton = new JoystickButton(JS1, OIConstants.ArmDownButton);
  public JoystickButton ArmUpButton = new JoystickButton(JS1, OIConstants.ArmUpButton);
  public JoystickButton CollectorShootButton = new JoystickButton(JS1, OIConstants.CollectorShootButton);
  public JoystickButton CollectorIntakeButton = new JoystickButton(JS1, OIConstants.CollectorIntakeButton);
  public JoystickButton LiftExtendButton = new JoystickButton(JS1, OIConstants.LiftExtendButton);
  public JoystickButton LiftExtenderRetractButton = new JoystickButton(JS1, OIConstants.LiftExtenderRetractButton);
  public JoystickButton LiftWinchButton = new JoystickButton(JS1, OIConstants.LiftWinchButton);
  public JoystickButton LiftWincherLoosenButton = new JoystickButton(JS1, OIConstants.LiftWincherLoosenButton);
  public JoystickButton WoFArmToggleButton = new JoystickButton(JS1, OIConstants.WoFArmToggleButton);
  public JoystickButton WoFMotorSpinButton = new JoystickButton(JS1, OIConstants.WoFMotorSpinButton);

  // The robot's subsystems and commands are defined here...
  private final Arm rc_Arm = new Arm();
  private final ArmDown rc_ArmDown = new ArmDown(rc_Arm);
  private final ArmIdle rc_ArmIdle = new ArmIdle(rc_Arm);
  private final ArmUp rc_ArmUp = new ArmUp(rc_Arm);
  private final Collector rc_Collector = new Collector();
  private final CollectorIdle rc_CollectorIdle = new CollectorIdle(rc_Collector);
  private final CollectorIntake rc_CollectorIntake = new CollectorIntake(rc_Collector);
  private final CollectorShoot rc_CollectorShoot = new CollectorShoot(rc_Collector);
  private final DriveTrain rc_DriveTrain = new DriveTrain();
  private final Drive rc_Drive = new Drive(rc_DriveTrain, JS1);
  private final LiftExtender rc_LiftExtender = new LiftExtender();
  private final LiftExtend rc_LiftExtend = new LiftExtend(rc_LiftExtender);
  private final LiftExtenderIdle rc_LiftExtenderIdle = new LiftExtenderIdle(rc_LiftExtender);
  private final LiftExtenderRetract rc_LiftExtenderRetract = new LiftExtenderRetract(rc_LiftExtender);
  private final LiftWincher rc_LiftWincher = new LiftWincher();
  private final LiftWinch rc_LiftWinch = new LiftWinch(rc_LiftWincher);
  private final LiftWincherIdle rc_LiftWincherIdle = new LiftWincherIdle(rc_LiftWincher);
  private final LiftWincherLoosen rc_LiftWincherLoosen = new LiftWincherLoosen(rc_LiftWincher);
  private final WoFArm rc_WoFArm = new WoFArm();
  private final WoFArmToggle rc_WoFArmToggle = new WoFArmToggle(rc_WoFArm);
  private final WoFMotor rc_WoFMotor = new WoFMotor();
  private final WoFMotorIdle rc_WoFMotorIdle = new WoFMotorIdle(rc_WoFMotor);
  private final WoFMotorSpin rc_WoFMotorSpin = new WoFMotorSpin(rc_WoFMotor);





  

  public RobotContainer() {
    // Default Command
    rc_Arm.setDefaultCommand(rc_ArmIdle);
    rc_Collector.setDefaultCommand(rc_CollectorIdle);
    rc_DriveTrain.setDefaultCommand(rc_Drive);
    rc_LiftExtender.setDefaultCommand(rc_LiftExtenderIdle);
    rc_LiftWincher.setDefaultCommand(rc_LiftWincherIdle);
    rc_WoFMotor.setDefaultCommand(rc_WoFMotorIdle);
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
    ArmDownButton.whileHeld(rc_ArmDown);
    ArmUpButton.whileHeld(rc_ArmUp);
    CollectorIntakeButton.whileHeld(rc_CollectorIntake);
    CollectorShootButton.whileHeld(rc_CollectorShoot);
    LiftExtendButton.whileHeld(rc_LiftExtend);
    LiftExtenderRetractButton.whileHeld(rc_LiftExtenderRetract);
    LiftWinchButton.whileHeld(rc_LiftWinch);
    LiftWincherLoosenButton.whileHeld(rc_LiftWincherLoosen);
    WoFArmToggleButton.whenPressed(rc_WoFArmToggle);
    WoFMotorSpinButton.whileHeld(rc_WoFMotorSpin);
    //JS1.setYChannel(1);
    //JS1.setZChannel(4);
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
