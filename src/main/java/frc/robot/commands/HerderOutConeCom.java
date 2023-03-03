// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;



public class HerderOutConeCom extends CommandBase {
  HerderSub m_subsystem;
  
  public HerderOutConeCom(HerderSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.driveHerders(3);
    SmartDashboard.putString("Herder Out", "Out");

    
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveHerders(0);
  
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
