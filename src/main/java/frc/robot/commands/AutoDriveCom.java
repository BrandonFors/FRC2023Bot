// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class AutoDriveCom extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSub m_subsystem;

  private final double forward;
  private final double twist;
  private final double distance;
  private final double time;
  private Timer timer = new Timer();


  
  public AutoDriveCom(DriveTrainSub subsystem, double forward, double twist, double distance, double time) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);

    this.forward = forward;
    this.twist = twist;
    this.distance = distance;
    this.time = time;
    //this should be in the initialize section
    subsystem.setRightEncoder(0);
    subsystem.setLeftEncoder(0);
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
    m_subsystem.driveRobot(forward, twist);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveRobot(0, 0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(distance<Math.abs(m_subsystem.getRightEncoder())){
      return true;
    }else{
      return false;
    }
    
  }
}
