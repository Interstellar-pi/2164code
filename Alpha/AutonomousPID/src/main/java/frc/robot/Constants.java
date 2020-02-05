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
        public static final int CAN_RF = 1;
        public static final int CAN_RR = 2;
        public static final int CAN_LF = 3;
        public static final int CAN_LR = 4;
    }

    public static class EncoderConstants{
        public static final int[] LeftEncoder = {6,7};
        public static final int EncoderPPR = 280; //Encoder's pulse per revolution
        public static final double WDiam = 3.9; //Inch diameter of the wheel
        public static final double ConvFact = 1/12; //Conversion factor of inches to feet
        public static final double DPT = ((1/EncoderPPR)*(WDiam)*(ConvFact*Math.PI)); //Distance Per Tick calculation
    }
}