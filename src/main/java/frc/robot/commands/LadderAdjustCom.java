// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LadderSub;

public class LadderAdjustCom extends CommandBase {
  LadderSub m_subsystem;
  private double location;
  public LadderAdjustCom(LadderSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
   location = m_subsystem.getLiftEncoder();
  }

  
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_subsystem.getLiftEncoder()<location){
      m_subsystem.driveLift(0.05);
    }else{
      m_subsystem.driveLift(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
