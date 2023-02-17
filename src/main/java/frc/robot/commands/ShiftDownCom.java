// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShifterSub;

public class ShiftDownCom extends CommandBase {
  /** Creates a new ShiftDownCom. */
  private final ShifterSub m_subsystem;
  public ShiftDownCom(ShifterSub subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  public void shift(){
    m_subsystem.shiftForward();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
