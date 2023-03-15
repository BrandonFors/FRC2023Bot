// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.BalanceRobotCom;
import frc.robot.commands.DriveCom;
import frc.robot.commands.HerderInConeCom;
import frc.robot.commands.HerderOutConeCom;
import frc.robot.commands.LadderAdjustCom;
import frc.robot.commands.LiftDownCom;
import frc.robot.commands.LiftUpCom;
import frc.robot.commands.ShiftDownCom;
import frc.robot.commands.ShiftUpCom;
import frc.robot.commands.TeleDriveCom;
import frc.robot.commands.TiltBackwardCom;
import frc.robot.commands.TiltForwardCom;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.HerderSub;
import frc.robot.subsystems.LadderSub;
import frc.robot.subsystems.LadderTiltSub;
import frc.robot.subsystems.ShifterSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html

public class CenterAuto extends SequentialCommandGroup {
  
  /** Creates a new CenterAuto. */
  public CenterAuto(DriveTrainSub m_DriveTrainSub,HerderSub m_HerderSub,LadderSub m_LadderSub,LadderTiltSub m_LadderTiltSub) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new LiftUpCom(m_LadderSub, Constants.liftTopSetpoint),
      new TiltForwardTimedCom(m_LadderTiltSub,2.5),
      
      new HerderOutTimed(m_HerderSub,3),
      new LiftDownCom(m_LadderSub, Constants.liftMidSetpoint),
      new TiltBackwardTimedCom(m_LadderTiltSub, 2.5)


      
    );
  }
}
