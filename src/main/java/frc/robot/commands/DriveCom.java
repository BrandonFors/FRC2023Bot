// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCom extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSub m_subsystem;

  private final double forward;
  private final double twist;

  
  public DriveCom(DriveTrainSub subsystem, double forward, double twist) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);

    this.forward = forward;
    this.twist = twist;
  }

  
  


  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    m_subsystem.driveRobot(forward, twist);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveRobot(0, 0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
