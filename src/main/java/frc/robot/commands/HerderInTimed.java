// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;



public class HerderInTimed extends CommandBase {
  HerderSub m_subsystem;
  private final double time;
  private Timer timer = new Timer();
  
  public HerderInTimed(HerderSub subsystem, double time ) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    this.time = time;
    
    
  }

  @Override
  public void initialize() {
    //reset the timer
    timer.reset();

    //start timer
    timer.start();
  }

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
    if(timer.get()>time){
       return true;
    }
    return false;
  }
}
