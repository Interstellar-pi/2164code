/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BallCollecterD;
import frc.robot.commands.BallCollecterI;
import frc.robot.commands.BallCollectorIOS;
import frc.robot.commands.BallCollectorO;
import frc.robot.commands.BallCollectorS;
import frc.robot.commands.BallCollectorU;
import frc.robot.commands.Drive10Feet;
import frc.robot.commands.DriveTrainReset;
import frc.robot.commands.Pnuematics2In;
import frc.robot.commands.Pnuematics2out;
import frc.robot.commands.PnuematicsC;
import frc.robot.commands.Pnuematics_default;
import frc.robot.commands.liftDown;
import frc.robot.commands.liftStop;
import frc.robot.commands.liftUp;
import frc.robot.commands.normalDrive;
import frc.robot.subsystems.BallCollector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Pnuematics;
import frc.robot.subsystems.Pnuematics2;
import frc.robot.subsystems.lift;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static Joystick joy = new Joystick(Constants.JoystickID);
  // The robot's subsystems and commands are defined here...
  private static JoystickButton InButton = new JoystickButton(joy, 3);
  private static JoystickButton OutButton = new JoystickButton(joy, 4);
  public final static DriveTrain S_Drive = new DriveTrain();
  private final normalDrive C_Drive = new normalDrive(S_Drive, joy);
  private final Pnuematics pnuematics = new Pnuematics();
  private final PnuematicsC HighGear = new PnuematicsC(pnuematics);
  private final Pnuematics_default LowGear = new Pnuematics_default(pnuematics);
  public final static lift S_lift = new lift();
  public final static liftStop C_liftS = new liftStop(S_lift);
  public final static liftUp C_liftU = new liftUp(S_lift, joy);
  public final static liftDown C_liftD = new liftDown(S_lift);
  public final static BallCollector Ball = new BallCollector();
  public final static BallCollector Ball2 = new BallCollector();
  public final static BallCollectorU C_Ball = new BallCollectorU(Ball);
  public static final BallCollectorS S_Ball = new BallCollectorS(Ball);
  public static final BallCollecterD D_Ball = new BallCollecterD(Ball);
  public static final BallCollecterI I_Ball = new BallCollecterI(Ball2);
  public static final BallCollectorIOS SIO_Ball = new BallCollectorIOS(Ball2);
  public static final BallCollectorO O_Ball = new BallCollectorO(Ball2);
  public static final Pnuematics2 PNUEMATICS2 = new Pnuematics2();
  public static final Pnuematics2In PM_in = new Pnuematics2In(PNUEMATICS2);
  public static final Pnuematics2out PM_out = new Pnuematics2out(PNUEMATICS2);
  public static final JoystickButton Solenoid = new JoystickButton(joy, 5);
  public final static Drive10Feet TenF = new Drive10Feet(S_Drive);
  public static final JoystickButton TenFB = new JoystickButton(joy,2);
  public static final DriveTrainReset Reset = new DriveTrainReset(S_Drive);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    S_lift.setDefaultCommand(C_liftS);
    S_Drive.setDefaultCommand(C_Drive);
    Ball.setDefaultCommand(S_Ball);
    Ball2.setDefaultCommand(SIO_Ball);
    PNUEMATICS2.setDefaultCommand(PM_in);
    // Configure the button bindings
    pnuematics.setDefaultCommand(LowGear);
    configureButtonBindings();
    
    CameraServer cam = CameraServer.getInstance();
    cam.startAutomaticCapture(0);
    SmartDashboard.putNumber("POV", joy.getPOV());
    InButton.whileActiveContinuous(I_Ball);
    OutButton.whileActiveContinuous(O_Ball);
    Solenoid.toggleWhenPressed(PM_out);
    //TenFB.toggleWhenPressed(TenF);
  }
 

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
     JoystickButton shift = new JoystickButton(joy, 1);
    shift.toggleWhenPressed(HighGear);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
