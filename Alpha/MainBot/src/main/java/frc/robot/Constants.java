/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class DriveConstants{
        public static final int CAN_RF = 1; //TalonSRX
        public static final int CAN_RR = 2; //VictorSPX
        public static final int CAN_LF = 3; //TalonSRX
        public static final int CAN_LR = 4; //VictorSPX
    }

    public static class ArmConstants{
        public static final int CAN_Intake = 5; //TalonSRX
        public static final int CAN_Pitch = 6; //TalonSRX
    }
    
    public static class LiftConstants{
        public static final int CAN_Extend = 7; //TalonSRX
        public static final int CAN_Winch = 8; //TalonSRX
    }

    public static class WoFConstants{
        public static final int CAN_Spin = 9; //SparkMAX
        public static final int PCM_Port0 = 0; //Double Solenoid Valve #1
        public static final int PCM_Port1 = 1; //Double Solenoid Valve #2
        public static final int[] PCM_WoFSol = new int[2]; //WoF Solenoid
    }

    public static class OIConstants{
        public static final int JS1 = 0; //Joystick 1 Port
        public static final int ArmUpButton = 2; //Joystick 1 ArmUp
        public static final int ArmDownButton = 4; //Joystick 1 ArmDown
        public static final int CollectorIntakeButton = 3; //Joystick 1 CollectorIntake
        public static final int CollectorShootButton = 1; //Joystick 1 CollectorShoot
        public static final int LiftExtendButton = 9; //Joystick 1 LiftExtend
        public static final int LiftWinchButton = 10; //Joystick 1 LiftWinch
        public static final int WoFArmToggleButton = 5; //Joystick 1 WoFArmToggle
        public static final int WoFSpinButton = 7; //Joystick 1 WoFSpin
    }
}
