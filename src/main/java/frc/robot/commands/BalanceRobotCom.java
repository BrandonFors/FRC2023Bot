// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.math.controller.PIDController;

public class BalanceRobotCom extends CommandBase {
  private final DriveTrainSub m_DriveTrainSubsystem;
  private final PIDController m_PIDController;
  
  
  public BalanceRobotCom(DriveTrainSub m_DriveTrainSubsystem, double setpoint) {
    this.m_DriveTrainSubsystem = m_DriveTrainSubsystem;
    
    this.m_PIDController = new PIDController(Constants.balPVal, Constants.balIVal, Constants.balDVal);
    m_PIDController.setSetpoint(Constants.balSetPoint);
    
    addRequirements(m_DriveTrainSubsystem);

    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double speed = m_PIDController.calculate(m_DriveTrainSubsystem.getPitch());
    m_DriveTrainSubsystem.driveRobot(-speed,0);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
