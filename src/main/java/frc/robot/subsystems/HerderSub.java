// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import pabeles.concurrency.IntOperatorTask.Max;


public class HerderSub extends SubsystemBase {
  private CANSparkMax rightHerderMotor = new CANSparkMax(Constants.clawRightMotorChannel, MotorType.kBrushless);
  private CANSparkMax leftHerderMotor = new CANSparkMax(Constants.clawLeftMotorChannel, MotorType.kBrushless);
  private double max = rightHerderMotor.getOutputCurrent();


  /** Creates a new HerderSub. */
  public HerderSub() {

  }

  public void driveHerders(double speed){
    rightHerderMotor.set(speed);
    leftHerderMotor.set(-speed);

  }
  public double getCurrent(){
    return rightHerderMotor.getOutputCurrent();
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
    double test = rightHerderMotor.getOutputCurrent();
    if(max<test){
      max = test;
    }
    
    SmartDashboard.putNumber("Current AMPS", rightHerderMotor.getOutputCurrent());
    SmartDashboard.putNumber("MAX AMPS", max);

  }
}
