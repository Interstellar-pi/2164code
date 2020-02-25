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

    public static class DriveConstants {
        public static final int RFMotor = 6;
        public static final int RRMotor = 7;
        public static final int LFMotor = 2;
        public static final int LRMotor = 3;
        public static final int[] r_encoder = {8,9};
        public static final int[] l_encoder = {0,1};
    }

    public static class EncoderConstants {
        public static final int EncoderPPR = 360; //Encoder's pulse per revolution
        public static final double WDiam = 6; //Inch diameter of the wheel
        public static final int ConvFact = 12; //Conversion factor (12 inches in a foot)
        public static final double DPT = 1.0/EncoderPPR*WDiam*Math.PI/ConvFact;
    }

    public static class OIConstants {
        public static final int LogitechJoy = 0;
        public static final int y_axis = 1;
        public static final int z_axis = 4;
    }
}
