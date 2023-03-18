// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.HerderSub;
import frc.robot.subsystems.LadderSub;
import frc.robot.subsystems.LadderTiltSub;
import frc.robot.subsystems.ShifterSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;


public final class Autos {
  /** Example static factory for an autonomous command. */
  // public static CommandBase exampleAuto(DriveTrainSub subsystem) {
  //   return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  // }
  public static CommandBase TestAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub, ShifterSub ShiftSub){
    return Commands.sequence(
   
    new AutoDriveCom(m_DriveTrainSub, -1, 0, 20, 0),
      new BalanceRobotCom(m_DriveTrainSub, 0)
    );
  }
  public static CommandBase centerConeAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub, ShifterSub ShiftSub){
    return Commands.sequence(
    new AutoShiftUp(ShiftSub, 0.1),
    new HerderInTimed(m_HerderSub, 0.1),
    new LiftUpCom(m_LadderSub, Constants.liftTopSetpoint),
    new TiltForwardTimedCom(m_LadderTiltSub,3.5),
   
    new LiftDownCom(m_LadderSub, Constants.liftMidSetpoint),
    new HerderOutTimed(m_HerderSub,0.5),
    new TiltBackwardTimedCom(m_LadderTiltSub, 4),
    new AutoDriveCom(m_DriveTrainSub, -1, 0, 70, 0),
      new BalanceRobotCom(m_DriveTrainSub, 0)
    );
  }
  public static CommandBase defConeAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub, ShifterSub ShiftSub){
    return Commands.sequence(
      new AutoShiftUp(ShiftSub, 0.1),
    new HerderInTimed(m_HerderSub, 0.1),
    new LiftUpCom(m_LadderSub, Constants.liftTopSetpoint),
    new TiltForwardTimedCom(m_LadderTiltSub,3.5),
   
    new LiftDownCom(m_LadderSub, Constants.liftMidSetpoint),
    new HerderOutTimed(m_HerderSub,0.5),
    new TiltBackwardTimedCom(m_LadderTiltSub, 4),
    new AutoDriveCom(m_DriveTrainSub, -1, 0, 275, 0)

    );
  }
  public static CommandBase centerCubeAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub, ShifterSub ShiftSub){
    return Commands.sequence(
      new AutoShiftUp(ShiftSub, 0.1),
      new LiftUpCom(m_LadderSub, Constants.liftMidSetpoint),
      new HerderInTimed(m_HerderSub, 0.1),
      new HerderOutTimed(m_HerderSub,0.5),
      new AutoDriveCom(m_DriveTrainSub, -1, 0, 70, 0),
      new BalanceRobotCom(m_DriveTrainSub, 0)
      
      //110
      // new BalanceRobotCom(m_DriveTrainSub, 0)

      );
  }
  public static CommandBase defCubeAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub, ShifterSub ShiftSub){
    return Commands.sequence(
      new AutoShiftUp(ShiftSub, 0.1),
      new LiftUpCom(m_LadderSub, Constants.liftTopSetpoint),
      new HerderInTimed(m_HerderSub, 0.1),
      new HerderOutTimed(m_HerderSub,0.5),
      new AutoDriveCom(m_DriveTrainSub, -1, 0, 275, 0)
    );
  }


  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}