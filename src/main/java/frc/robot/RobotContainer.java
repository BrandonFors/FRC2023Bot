// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Autos;
import frc.robot.commands.BalanceRobotCom;
import frc.robot.commands.DriveCom;
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
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import java.util.function.Supplier;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  private final DriveTrainSub m_DriveTrainSub = new DriveTrainSub();
  private final HerderSub m_HerderSub = new HerderSub();
  private final LadderSub m_LadderSub = new LadderSub();
  private final LadderTiltSub m_LadderTiltSub = new LadderTiltSub();
  private final ShifterSub m_ShifterSub = new ShifterSub();

  private final Joystick driveStick = new Joystick(Constants.DriveStickChannel);
  public final Joystick intakeStick = new Joystick(Constants.IntakeStickChannel);
  private final SendableChooser<String> m_chooser;

  public static final String defaultAutoTxt = "Default Auto";

  
  public RobotContainer() {
    m_chooser = new SendableChooser<>();
    m_chooser.addOption(defaultAutoTxt, defaultAutoTxt);

    SmartDashboard.putData("Auto Choices", m_chooser);
    
    m_DriveTrainSub.setDefaultCommand(new TeleDriveCom(m_DriveTrainSub, ()-> driveStick.getRawAxis(1)*(-0.75), ()-> driveStick.getRawAxis(0)*(-0.75)));
    // m_ShifterSub.setDefaultCommand(new ShiftDownCom(m_ShifterSub));
    configureBindings();  
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    new JoystickButton(driveStick, 1).whileTrue(new BalanceRobotCom(m_DriveTrainSub,0));
    new JoystickButton(driveStick, 4).toggleOnTrue(new ShiftUpCom(m_ShifterSub));
    new JoystickButton(driveStick, 2).whileTrue(new TiltForwardCom(m_LadderTiltSub));
    new JoystickButton(driveStick, 3).whileTrue(new TiltBackwardCom(m_LadderTiltSub));
    new JoystickButton(driveStick, 5).whileTrue(new LiftDownCom(m_LadderSub));
    new JoystickButton(driveStick, 6).whileTrue(new LiftUpCom(m_LadderSub));



    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

 
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    
    switch(m_chooser.getSelected()){
      case "Default Auto":
        return Autos.defaultAuto(m_DriveTrainSub);
    default:
       return Autos.defaultAuto(m_DriveTrainSub);

  }
}
}