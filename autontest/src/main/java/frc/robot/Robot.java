/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Enumeration;
import java.util.Map;

import com.fasterxml.jackson.databind.util.EnumValues;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  ShuffleboardTab autonTab = Shuffleboard.getTab("Autonomous Selection");
  public NetworkTableEntry n_StartLeft;
  public NetworkTableEntry n_StartCenter;
  public NetworkTableEntry n_StartRight;
  public NetworkTableEntry n_Other;
  public NetworkTableEntry n_BailLeft;
  public NetworkTableEntry n_BailCenter;
  public NetworkTableEntry n_BailRight;
  public NetworkTableEntry n_NoBail;
  public NetworkTableEntry n_StartDelay;
  public NetworkTableEntry n_DelayValue;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();


    n_StartLeft = autonTab
    .add("Starting Left", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(1, 1)
    .getEntry();

    n_StartCenter = autonTab
    .add("Starting Center", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(2, 1)
    .getEntry();

    n_StartRight = autonTab
    .add("Starting Right", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(3, 1)
    .getEntry();
  
    n_Other = autonTab
    .add("Other", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(4, 1)
    .getEntry();

    n_BailLeft = autonTab
    .add("Bail Left", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(1, 2)
    .getEntry();

    n_BailCenter = autonTab
    .add("Bail Center", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(2, 2)
    .getEntry();

    n_BailRight = autonTab
    .add("Bail Right", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(3, 2)
    .getEntry();

    n_NoBail = autonTab
    .add("No Bail", false)
    .withWidget(BuiltInWidgets.kToggleSwitch)
    .withSize(1, 1)
    .withPosition(4, 2)
    .getEntry();
  
    n_StartDelay = autonTab
    .add("Delay Start", 0)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("Min", 0, "Max", 13))
    .withSize(3, 1)
    .withPosition(1, 3)
    .getEntry();

    n_DelayValue = autonTab
    .add("Delay Value", n_StartDelay.getString("0"))
    .withWidget(BuiltInWidgets.kTextView)
    .withSize(1, 1)
    .withPosition(4, 3)
    .getEntry();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

/*
  private enum StartCommandSelector {
    SL,SC,SR 
  }

  
  private StartCommandSelector startselector()  {
    StartCommandSelector Selection;

    if(n_StartLeft.getBoolean(false)) {
       Selection = StartCommandSelector.SL;
    } else if (n_StartCenter.getBoolean(false)) {
       Selection = StartCommandSelector.SC;
    } else if(n_StartRight.getBoolean(false))  {
        Selection = StartCommandSelector.SR;
    }

    return Selection;
  }
*/
}
