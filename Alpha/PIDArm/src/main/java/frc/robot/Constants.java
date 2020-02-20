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

    public static class OIConstants {
        public static final int DriveJS = 0;
        public static final int x_axis = 0;
        public static final int y_axis = 1;
        public static final int z_axis = 5;
        public static final int EncoderResetButton = 8;
        public static final int ArmDownButton = 1;
        public static final int ArmUpButton = 4;
    }

    public static class ArmConstants {
        public static final int CAN_Pitch = 9;
        public static final int[] EncoderPorts = {4,5};
    }
}
