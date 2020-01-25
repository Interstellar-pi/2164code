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

    public static class driveConstants {
        public static final int rF = 1; //TalonSRX
        public static final int rR = 2; //VictorSPX
        public static final int lF = 3; //TalonSRX
        public static final int lR = 4; //VictorSPX
    }

    public static class collectorConstants  {
        public static final int intakemotor = 5; //TalonSRX
        public static final int pitchmotor = 6; //TalonSRX

    }

    public static class liftConstants   {
        public static final int extensionmotor = 7; //TalonSRX
        public static final int winchmotor = 8; //TalonSRX
    }

    public static class wofConstants    {
        public static final int spinner = 9; //Spark Max
        public static final int pCM = 10;
        public static final int[] arm = new int[]{0,1};
    }


}
