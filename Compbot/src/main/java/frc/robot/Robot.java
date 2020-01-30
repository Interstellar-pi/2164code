/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

 ShuffleboardTab autonTab = Shuffleboard.getTab("Autonomous Selection");
 ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");

  private RobotContainer m_robotContainer;
 
  public NetworkTableEntry n_StartLeft;
  public NetworkTableEntry n_StartCenter;
  public NetworkTableEntry n_StartRight;

  I2C.Port i2cPort;
  ColorSensorV3 m_colorSensor;
  ColorMatch m_colorMatcher;
  Color kBlueTarget;
  Color kGreenTarget;
  Color kRedTarget;
  Color kYellowTarget;
  boolean ColorSensorConfidence;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
/*
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
*/

      autonTab
        .add("Starting Left", false)
        .withWidget(BuiltInWidgets.kToggleSwitch)
        .withSize(1, 1)
        .withPosition(1, 1)
        .getEntry();

        autonTab
      .add("Starting Center", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(2, 1)
      .getEntry();

      autonTab
      .add("Starting Right", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(3, 1)
      .getEntry();
    
      autonTab
      .add("Other", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(4, 1)
      .getEntry();

      autonTab
      .add("Bail Left", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(1, 2)
      .getEntry();

      autonTab
      .add("Bail Center", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(2, 2)
      .getEntry();

      autonTab
      .add("Bail Right", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(3, 2)
      .getEntry();

      autonTab
      .add("No Bail", false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withSize(1, 1)
      .withPosition(4, 2)
      .getEntry();
    
      autonTab
      .add("Delay Start", 0)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("Min", 0, "Max", 13))
      .withSize(2, 1)
      .withPosition(1, 3)
      .getEntry();

    
      mainTab
      .add("WOF Target Color", "Unrecived")
        .withWidget(BuiltInWidgets.kTextView)
        .withSize(1, 1)
        .withPosition(1, 4)
        .getEntry();
    
      mainTab
      .add("Color Detected", "N/A")
        .withWidget(BuiltInWidgets.kTextView)
        .withSize(1, 1)
        .withPosition(2, 4)
        .getEntry();

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
   /* if(RobotBase.isReal()){

    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    kBlueTarget = ColorMatch.makeColor(0.16, 0.39, 0.44);
    kGreenTarget = ColorMatch.makeColor(0.19, 0.55, 0.25);
    kRedTarget = ColorMatch.makeColor(0.4, 0.4, 0.17);
    kYellowTarget = ColorMatch.makeColor(.307, 0.547, 0.144);
    ColorSensorConfidence = false;


    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    String colorString = "Unknown";

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    if (match.color == kBlueTarget && match.confidence >= .98) ColorSensorConfidence = true;
    else if (match.color == kBlueTarget && match.confidence <= .979) ColorSensorConfidence = false;
  }
    
    /*  SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    SmartDashboard.putBoolean("Color Accurate", ColorSensorConfidence);
    */
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          break;
        case 'G' :
          break;
        case 'R' :
          break;
        case 'Y' :
          break;
        default :
          break;
      }
    } else {
    }



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
}
