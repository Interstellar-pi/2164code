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
        public static final int rF = 1; //TalonSRX
        public static final int rR = 2; //VictorSPX
        public static final int lF = 3; //TalonSRX
        public static final int lR = 4; //VictorSPX
    }

    public static class CollectorConstants  {
        public static final int rollermotor = 5; //TalonSRX
            public static final boolean rollerinverted = false;
        public static final int pitchmotor = 6; //TalonSRX
            public static final boolean pitchinverted = false;

    }

    public static class LiftConstants   {
        public static final int extensionmotor = 7; //TalonSRX
            public static final boolean extensioninverted = false;
        public static final int winchmotor = 8; //TalonSRX
            public static final boolean winchinverted = false;
    }

    public static class WOFConstants    {
        public static final int spinner = 9; //Spark Max
            public static final boolean spinnerinverted = false;
        public static final int pCM = 10;
        public static final int[] arm = new int[]{0,1};
    }

    public static class OIConstants {
        public static final int stick1 = 0;
        public static final int xChannel = 0;
        public static final int yChannel = 1;
        public static final int zChannel = 5;
        public static final int shootbtn = 1;
        public static final int collectbtn = 3;
        public static final int collectorup = 2;
        public static final int collectordwn = 4;
        public static final int WOFarmtoggle = 5;
        public static final int WOFspin = 7;
        public static final int liftclimb = 10;
        public static final int liftextend = 9;
    }


}
