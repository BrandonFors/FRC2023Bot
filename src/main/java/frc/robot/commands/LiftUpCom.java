// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.LadderSub;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;



public class LiftUpCom extends CommandBase {
  private final LadderSub m_subsystem;
  private final PIDController m_PIDController;
  // private final double speed;
  private double limiter;

  /** Creates a new LiftUpCom. */
  public LiftUpCom(LadderSub subsystem, double limiter) {
    this.limiter = limiter;
    
    
    this.m_PIDController = new PIDController(Constants.liftPVal, Constants.liftIVal, Constants.liftDVal);
    m_PIDController.setSetpoint(Constants.liftTopSetpoint);
    // this.speed = speed;
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
    
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    // double speed = m_PIDController.calculate(m_subsystem.getLiftEncoder());
    m_subsystem.driveLift(1.5);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveLift(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_subsystem.getLiftEncoder()>limiter){
      return true;
    }else{
      return false;}
  }
}
