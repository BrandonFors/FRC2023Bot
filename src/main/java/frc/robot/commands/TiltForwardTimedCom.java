// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LadderTiltSub;

public class TiltForwardTimedCom extends CommandBase {
  private final LadderTiltSub m_subsystem;
  private final PIDController m_PIDController;
  private final double time;
  private Timer timer = new Timer();
  public TiltForwardTimedCom(LadderTiltSub subsystem, double time) {
    this.m_PIDController = new PIDController(Constants.tiltPVal, Constants.tiltIVal, Constants.tiltDVal);
    m_PIDController.setSetpoint(-Constants.tiltTopSetpoint);
    
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
    // double speed = m_PIDController.calculate(m_subsystem.getTiltEncoder());
    m_subsystem.driveTilt(-0.2);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveTilt(0);
  }

  @Override
  public boolean isFinished() {
    if(timer.get()>time){
      return true;
   }
   return false;
  }
}