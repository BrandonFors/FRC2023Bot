// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
//sticks
  public static int DriveStickChannel = 0;
  public static int IntakeStickChannel = 1;
//drive
  public static int FrontRightMotorChannel = 3;
  public static int FrontLeftMotorChannel = 2;
  public static int BackRightMotorChannel = 5;
  public static int BackLeftMotorChannel = 4;

  


  


  public static int SolFwdChannel = 1;
  public static int SolBwdChannel = 0;  


  //PID
  public static double balPVal = 0.03;
  public static double balIVal = 0.003;
  //0.005
  public static double balDVal = 0.005;
  public static double balSetPoint = 0;


  //elevator
  public static int elevatorTiltMotorChannel = 7;
  public static int elevatorLiftMotorChannel = 8;
  //el PID
  public static double liftPVal = 0.02;
  public static double liftIVal = 0;
  public static double liftDVal = 0;
  public static double liftMidSetpoint = 5.353271;
  public static double liftTopSetpoint = 7.35;
  public static double liftBotSetpoint = 1;

  public static double tiltPVal = 0.0025;
  public static double tiltIVal = 0;
  public static double tiltDVal = 0;
  public static double tiltTopSetpoint = 20;
  public static double tiltBotSetpoint = 0;
  //claw
  public static int clawLeftMotorChannel = 23;
  public static int clawRightMotorChannel = 10;


  

 
}
