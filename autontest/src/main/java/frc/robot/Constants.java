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

    public static final class DriveConstants   {
        public static final int rF = 1; //TalonSRX
        public static final int rR = 2; //TalonSRX
        public static final int lF = 3; //TalonSRX
        public static final int lR = 4; //TalonSRX
        public static final int[] driveEncoderA = new int[] {0,1};
        public static final int[] driveEncoderB= new int[] {6,7};
    }


    public static final class OIConstsants {
        public static final int stick1 = 0;
        public static final int hibtn = 2;
        public static final int lowbtn = 4;
        public static final int xChannel = 5;
        public static final int yChannel =  1;
        public static final int zChannel = 0;
    }

    public static class PIDConstants    {

        public static final double tick2feet = 1.0/280*4*Math.PI/12;

        public static final double[] startSetPoints = new double[] {0,10,0}; //Left,Center,Right
        public static final double[] collectorSetPoints = new double[] {0,0};//Up,Down
        public static final double[] bailLeftSetpoints = new double[] {0,0,0};
        public static final double[] bailCenterSetpoints = new double[] {0,0,0};
        public static final double[] bailRightSetpoints = new double[] {0,0,0};
        public static final double[] turnSetpointd = new double[] {90,-90};
    }

    public static final class PneumaticsConstants {
        public static final int[] shifterPorts = new int[]{0,1};
    }


}
