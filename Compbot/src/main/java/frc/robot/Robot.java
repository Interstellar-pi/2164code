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
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

 ShuffleboardTab autonTab = Shuffleboard.getTab("Autonomous Selection");
 ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");

  private RobotContainer m_robotContainer;
 
  public NetworkTableEntry n_StartLeft;
  public NetworkTableEntry n_StartCenter;
  public NetworkTableEntry n_StartRight;
  public NetworkTableEntry n_Other;
  public NetworkTableEntry n_BailLeft;
  public NetworkTableEntry n_BailCenter;
  public NetworkTableEntry n_BailRight;
  public NetworkTableEntry n_NoBail;
  public NetworkTableEntry n_StartDelay;
  public NetworkTableEntry n_ColorNeeded;
  public NetworkTableEntry n_ColorDetected;

  I2C.Port i2cPort;
  ColorSensorV3 m_colorSensor;
  ColorMatch m_colorMatcher;
  Color kBlueTarget;
  Color kGreenTarget;
  Color kRedTarget;
  Color kYellowTarget;
  boolean ColorSensorConfidence;
  String colorString = "Unknown";


  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
/*
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
*/

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
      .withSize(2, 1)
      .withPosition(1, 3)
      .getEntry();

    
     n_ColorNeeded = mainTab
      .add("Target Color", "Unrecived")
        .withWidget(BuiltInWidgets.kTextView)
        .withSize(1, 1)
        .withPosition(1, 4)
        .getEntry();
    
     n_ColorDetected = mainTab
      .add("Color Detected", "N/A")
        .withWidget(BuiltInWidgets.kTextView)
        .withSize(1, 1)
        .withPosition(2, 4)
        .getEntry();

  }


  @Override
  public void robotPeriodic() {
   
    //   VV VV Ignore this VV VV
    if(RobotBase.isReal()){ 

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

      n_ColorNeeded.setString(gameData);
      n_ColorDetected.setString(colorString);


    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }


  
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
