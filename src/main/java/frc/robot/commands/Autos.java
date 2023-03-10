// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;


public final class Autos {
  /** Example static factory for an autonomous command. */
  // public static CommandBase exampleAuto(DriveTrainSub subsystem) {
  //   return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  // }
  public static CommandBase defaultAuto(DriveTrainSub subsystem){
    return Commands.sequence(new DriveCom(subsystem, 0.25, 0.00));
  }
  public static CommandBase leftAuto(DriveTrainSub subsystem){
    return Commands.sequence(new DriveCom(subsystem, 0.25, 0));
  }
  public static CommandBase centerAuto(DriveTrainSub subsystem){
    return Commands.sequence(new DriveCom(subsystem, 0.25, 0));
  }
  public static CommandBase rightAuto(DriveTrainSub subsystem){
    return Commands.sequence(new DriveCom(subsystem, 0.25, 0));
  }


  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}