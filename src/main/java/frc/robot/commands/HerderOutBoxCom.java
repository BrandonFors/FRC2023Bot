// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;



public class HerderOutBoxCom extends CommandBase {
  HerderSub m_subsystem;
  
  public HerderOutBoxCom(HerderSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
  
    m_subsystem.driveHerders(0.5);
  
    
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
