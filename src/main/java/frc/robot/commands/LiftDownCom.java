// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.LadderSub;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LiftDownCom extends CommandBase {
  private final LadderSub m_subsystem;

  private final PIDController m_PIDController;
  private double limiter;

  // private final double speed;
  
  public LiftDownCom(LadderSub subsystem, double limiter) {
    this.m_PIDController = new PIDController(Constants.liftPVal, Constants.liftIVal, Constants.liftDVal);
    m_PIDController.setSetpoint(Constants.liftBotSetpoint);
    // this.speed = speed;
    this.limiter = limiter;
    
    
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    // double speed = m_PIDController.calculate(m_subsystem.getLiftEncoder());
    m_subsystem.driveLift(-1);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveLift(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_subsystem.getLiftEncoder()<limiter){
      return true;
    }else{
      return false;}
  }
}
