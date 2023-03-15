// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShifterSub;

public class AutoShiftDown extends CommandBase {
  /** Creates a new ShiftUpCom. */
  private final ShifterSub m_subsystem;
  private final double time;
  private Timer timer = new Timer();
  
  public AutoShiftDown(ShifterSub subsystem, double time) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
    
    this.time = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //reset the timer
    timer.reset();

    //start timer
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.shiftReverse();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.shiftForward();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get()>time){
      return true;
   }
   return false;
    }
    
  }