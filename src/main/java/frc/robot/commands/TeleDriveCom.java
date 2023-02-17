// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;


public class TeleDriveCom extends CommandBase {
  /** Creates a new TeleDriveCom. */
  private final DriveTrainSub m_subsystem;
  private final Supplier <Double> speedFunction;
  private final Supplier <Double> twistFunction;
  
  public TeleDriveCom(DriveTrainSub subsystem,Supplier<Double> speedFunction,Supplier<Double> twistFunction) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_subsystem = subsystem;
    this.speedFunction = speedFunction;
    this.twistFunction = twistFunction;

    addRequirements(m_subsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTwist = twistFunction.get();
    SmartDashboard.putString("Status", "The Joystick Command is running");
   
    m_subsystem.driveRobot(realTimeSpeed,realTimeTwist);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveRobot(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
