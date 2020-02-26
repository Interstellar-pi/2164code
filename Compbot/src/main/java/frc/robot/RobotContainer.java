/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.autoncommand;
import frc.robot.commands.climb;
import frc.robot.commands.collect;
import frc.robot.commands.collectoridle;
import frc.robot.commands.collectordown;
import frc.robot.commands.collectorup;
import frc.robot.commands.extendhook;
import frc.robot.commands.liftidle;
import frc.robot.commands.shoot;
import frc.robot.commands.wofidle;
import frc.robot.commands.wofspin;
import frc.robot.commands.woftoggle;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.lift;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.wofarm;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final autoncommand ac_Autoncommand = new autoncommand();
  private final drivetrain s_Drivetrain = new drivetrain();
  private final collector s_Collector = new collector();
    private final collectorup c_Collectorup = new collectorup(s_Collector);
    private final collectordown c_Collectordown = new collectordown(s_Collector);
  private final shooter s_Shooter = new shooter();
  private final collect c_Collect = new collect(s_Shooter);
  private final shoot c_Shoot = new shoot(s_Shooter);
  private final collectoridle c_Collectoridle = new collectoridle(s_Shooter);
  private final lift s_Lift = new lift();
    private final liftidle c_Liftidle = new liftidle(s_Lift);
    private final climb c_Climb = new climb(s_Lift);
    private final extendhook c_Extendhook = new extendhook(s_Lift);
  private final wofarm s_Wofarm = new wofarm();
    private final woftoggle c_Woftoggle = new woftoggle(s_Wofarm);
    private final wofspin c_Wofspin = new wofspin(s_Wofarm);
    private final wofidle c_Wofidle = new wofidle(s_Wofarm);


  public Joystick drivestick = new Joystick(Constants.OIConstants.stick1);
  public JoystickButton b_shoot = new JoystickButton(drivestick, Constants.OIConstants.shootbtn);
  public JoystickButton b_collect = new JoystickButton(drivestick, Constants.OIConstants.collectbtn);
  public JoystickButton b_collectorup = new JoystickButton(drivestick, Constants.OIConstants.collectorup);
  public JoystickButton b_collectordwn = new JoystickButton(drivestick, Constants.OIConstants.collectordwn);
  public JoystickButton b_wofarmtoggle= new JoystickButton(drivestick, Constants.OIConstants.WOFarmtoggle);
  public JoystickButton b_wofspin =  new JoystickButton(drivestick, Constants.OIConstants.WOFspin);
  public JoystickButton b_extend = new JoystickButton(drivestick, Constants.OIConstants.liftextend);
  public JoystickButton b_climb = new JoystickButton(drivestick, Constants.OIConstants.liftclimb);
  
  

  public RobotContainer() {
    s_Drivetrain.setDefaultCommand(new RunCommand(() -> s_Drivetrain.drivectrl(drivestick.getY(), -drivestick.getZ()), s_Drivetrain));
    s_Lift.setDefaultCommand(c_Liftidle);
    s_Wofarm.setDefaultCommand(c_Wofidle);
    s_Shooter.setDefaultCommand(c_Collectoridle);
    s_Collector.ereset();



    drivestick.setXChannel(Constants.OIConstants.xChannel);
    drivestick.setYChannel(Constants.OIConstants.yChannel);
    drivestick.setZChannel(Constants.OIConstants.zChannel);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    b_shoot.whenHeld(c_Shoot);
    b_collect.whenHeld(c_Collect);
    b_collectordwn.whenActive(c_Collectordown);
    b_collectorup.whenActive(c_Collectorup);
    b_wofarmtoggle.whenPressed(c_Woftoggle);
    b_wofspin.whenHeld(c_Wofspin);
    b_extend.whenHeld(c_Extendhook);
    b_climb.whenHeld(c_Climb);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return ac_Autoncommand;
  }
}
