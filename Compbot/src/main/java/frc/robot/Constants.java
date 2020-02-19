/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


public final class Constants {

    public static class DriveConstants {
        public static final int rF = 6; //TalonSRX
        public static final int rR = 7; //VictorSPX
        public static final int lF = 2; //TalonSRX
        public static final int lR = 3; //VictorSPX
        public static final int[] driveEncoderA = new int[] {0,1};
        public static final int[] driveEncoderB= new int[] {2,3};
    }

    public static class CollectorConstants  {
        public static final int rollermotor = 1; //TalonSRX
            public static final boolean rollerinverted = false;
        public static final int pitchmotor = 9; //TalonSRX
            public static final boolean pitchinverted = false;
        public static final int[] sensorPorts = new int[] {4,5};

    }

    public static class LiftConstants   {
        public static final int extensionmotor = 4; //TalonSRX
            public static final boolean extensioninverted = false;
        public static final int winchmotor = 8; //TalonSRX
            public static final boolean winchinverted = false;
    }

    public static class WOFConstants    {
        public static final int spinner = 5; //Spark Max
            public static final boolean spinnerinverted = false;
        public static final int pCM = 10;
        public static final int[] arm = new int[]{0,7};
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

    public static class PIDConstants    {
        public static final int[] startSetPoints = new int[] {0,10,0}; //Left,Center,Right
        public static final int[] collectorSetPoints = new int[] {0,0};//Up,Down
        public static final int[] bailLeftSetpoints = new int[] {0,0,0};
        public static final int[] bailCenterSetpoints = new int[] {0,0,0};
        public static final int[] bailRightSetpoints = new int[] {0,0,0};
        public static final int[] turnSetpointd = new int[] {90,-90};
    }


}
