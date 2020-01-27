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
        public static final int CAN_Extension = 7; //TalonSRX
        public static final int CAN_Winch = 8; //TalonSRX
    }

    public static class WoFConstants{
        public static final int CAN_Spin = 9; //SparkMAX
        public static final int PCM_Extend = 0; //Double Solenoid Valve #1
        public static final int PCM_Retract = 1; //Double Solenoid Valve #2
    }
}
