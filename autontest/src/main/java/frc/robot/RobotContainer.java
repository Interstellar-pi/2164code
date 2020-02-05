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
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.higear;
import frc.robot.commands.lowgear;
import frc.robot.commands.startcenter;
import frc.robot.commands.startleft;
import frc.robot.commands.startright;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.pneumatics;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final drivetrain s_Drivetrain = new drivetrain();
    private final startleft ac_Startleft = new startleft(s_Drivetrain);
    private final startcenter ac_Startcenter = new startcenter(s_Drivetrain);
    private final startright ac_StartRight = new startright(s_Drivetrain);


  private final pneumatics s_Pneumatics = new pneumatics();
    private final higear c_Higear = new higear(s_Pneumatics);
    private final lowgear c_Lowgear = new lowgear(s_Pneumatics);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */  
  public Joystick drivestick = new Joystick(Constants.OIConstsants.stick1);
  public JoystickButton b_hi = new JoystickButton(drivestick, Constants.OIConstsants.hibtn);
  public JoystickButton b_low = new JoystickButton(drivestick, Constants.OIConstsants.lowbtn);
  public RobotContainer() {
    // Configure the button bindings
    drivestick.setXChannel(Constants.OIConstsants.xChannel);
    drivestick.setYChannel(Constants.OIConstsants.yChannel);
    drivestick.setZChannel(Constants.OIConstsants.zChannel);
    configureButtonBindings();
    
    s_Drivetrain.setDefaultCommand(new RunCommand(() -> s_Drivetrain.drivectrl(drivestick.getY(), -drivestick.getX()), s_Drivetrain));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    b_hi.whenPressed(c_Higear);
    b_low.whenPressed(c_Lowgear);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return ac_Startcenter;
  }
}
