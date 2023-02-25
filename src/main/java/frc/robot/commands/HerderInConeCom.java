// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;



public class HerderInConeCom extends CommandBase {
  HerderSub m_subsystem;
  
  public HerderInConeCom(HerderSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.driveHerders(-0.75);
    SmartDashboard.putString("Herder In", "In");
    
   
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveHerders(0);


    
  }

  @Override
  public boolean isFinished() {
    // if(m_subsystem.getCurrent()>15){
    //   return true;
    // }
    return false;
  }
}
