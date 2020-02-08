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
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ForwardTen;
import frc.robot.commands.ForwardTwelve;
import frc.robot.commands.LeftTurn;
import frc.robot.commands.AutonomousLeft;
import frc.robot.commands.AutonomousRight;
import frc.robot.commands.AutonomousSequential;
import frc.robot.commands.BackOne;
import frc.robot.commands.CylinderBack;
import frc.robot.commands.CylinderForward;
import frc.robot.commands.Drive;
import frc.robot.commands.ForwardTwoFive;
import frc.robot.commands.RightTurn;
import frc.robot.commands.ShifterHigh;
import frc.robot.commands.ShifterLow;
import frc.robot.subsystems.Cylinder;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shifter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Define OI here
  public Joystick JS1 = new Joystick(0);
  public JoystickButton PIDTestButton = new JoystickButton(JS1, 2);
  public JoystickButton ToggleOneTest = new JoystickButton(JS1, 3);
  public JoystickButton ToggleTwoTest = new JoystickButton(JS1, 4);
  //public JoystickButton ForwardTenButton = new JoystickButton(JS1, 2);
  //public JoystickButton ShifterHighButton = new JoystickButton(JS1, 1);
  //public JoystickButton RightTurnButton = new JoystickButton(JS1, 4);



  //The robot's subsystems and commands are defined here...
  private final DriveTrain rc_DriveTrain = new DriveTrain();
  private final BackOne rc_BackOne = new BackOne(rc_DriveTrain);
  private final Drive rc_Drive = new Drive(rc_DriveTrain, JS1);
  private final ForwardTen rc_ForwardTen = new ForwardTen(rc_DriveTrain);
  private final ForwardTwelve rc_ForwardTwelve = new ForwardTwelve(rc_DriveTrain);
  private final ForwardTwoFive rc_ForwardTwoFive = new ForwardTwoFive(rc_DriveTrain);
  private final LeftTurn rc_LeftTurn = new LeftTurn(rc_DriveTrain);
  private final RightTurn rc_RightTurn = new RightTurn(rc_DriveTrain);
  private final Shifter rc_Shifter = new Shifter();
  private final ShifterHigh rc_ShifterHigh = new ShifterHigh(rc_Shifter);
  private final ShifterLow rc_ShifterLow = new ShifterLow(rc_Shifter);
  private final Cylinder rc_Cylinder = new Cylinder();
  private final CylinderBack rc_CylinderBack = new CylinderBack(rc_Cylinder);
  private final CylinderForward rc_CylinderForward = new CylinderForward(rc_Cylinder);

  private final AutonomousSequential rc_AutonomousSequential = new AutonomousSequential(rc_DriveTrain, rc_Cylinder);
  private final AutonomousLeft rc_AutonomousLeft = new AutonomousLeft(rc_DriveTrain, rc_Cylinder);
  private final AutonomousRight rc_AutonomousRight = new AutonomousRight(rc_DriveTrain, rc_Cylinder);


  public RobotContainer() {
    rc_DriveTrain.setDefaultCommand(rc_Drive);
    //Default command



    //Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    PIDTestButton.whenPressed(rc_AutonomousRight);
    ToggleOneTest.toggleWhenPressed(rc_ShifterHigh);
    ToggleTwoTest.toggleWhenPressed(rc_ShifterLow);
    //ForwardTenButton.whenPressed(rc_ForwardTen);
    //ShifterLowButton.toggleWhenPressed(rc_ShifterLow);
    //ShifterHighButton.toggleWhenPressed(rc_ShifterHigh);
    //RightTurnButton.whenPressed(rc_RightTurn);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //This command will run in autonomous
    return null;
  }
}
