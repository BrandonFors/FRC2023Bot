// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;



public class HerderOutCom extends CommandBase {
  HerderSub m_subsystem;
  
  public HerderOutCom(HerderSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.driveLeftHerder(-0.5);
    m_subsystem.driveRightHerder(-0.5);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveLeftHerder(0);
    m_subsystem.driveLeftHerder(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
