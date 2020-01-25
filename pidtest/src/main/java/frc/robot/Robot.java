/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  private final WPI_TalonSRX rF = new WPI_TalonSRX(1);
  private final WPI_TalonSRX rR = new WPI_TalonSRX(2);
  private final WPI_TalonSRX lF = new WPI_TalonSRX(3);
  private final WPI_TalonSRX lR = new WPI_TalonSRX(4);

  private final SpeedControllerGroup right = new SpeedControllerGroup(rF,rR);
  private final SpeedControllerGroup left = new SpeedControllerGroup(lF,lR);
  private DifferentialDrive drive = new DifferentialDrive(left, right);


  private Joystick joy1 = new Joystick(0);
  private Encoder encoder = new Encoder(0, 1, true);
  private final double kDriveTick2Feet = 1.0/360*Math.PI*4/12;

  final double kP = 0.15;
  final double kI = 0.0;
  final double kD = 0.0;
  final double iLimit = 1;

  double setpoint = 10;
  double errorSum = 0;
  double lastTimestamp = 0;
  double lastError = 0;
  double error;
  double outputSpeed;

  @Override

  public void autonomousInit() {

    encoder.reset();
    //lF.setInverted(true);
    //lR.setInverted(true);
    errorSum = 0; 
    lastError = 0;
    lastTimestamp = Timer.getFPGATimestamp();

  }

  @Override

  public void autonomousPeriodic() {

    if (joy1.getRawButton(1)) {
      setpoint = 10;
    } else if (joy1.getRawButton(2)) {
      setpoint = 0;
    }

    double sensorPosition = encoder.get() * kDriveTick2Feet;
    error = setpoint - sensorPosition;
    double dt = Timer.getFPGATimestamp() - lastTimestamp;

    if (Math.abs(error) < iLimit) {
      errorSum += error * dt;
    }


    double errorRate = (error - lastError) / dt;
    outputSpeed = kP * error + kI * errorSum + kD * errorRate;

    drive.arcadeDrive(-outputSpeed, 0);

    lastTimestamp = Timer.getFPGATimestamp();
    lastError = error;

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("encoder value", encoder.get() * kDriveTick2Feet);
    SmartDashboard.putNumber("Output Speed",outputSpeed);
    SmartDashboard.putNumber("error", error);
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(joy1.getY(), joy1.getZ());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
