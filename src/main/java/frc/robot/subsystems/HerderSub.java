// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class HerderSub extends SubsystemBase {
  private CANSparkMax herderMotor = new CANSparkMax(5, MotorType.kBrushless);
  

  /** Creates a new HerderSub. */
  public HerderSub() {

  }

  public void driveHerder(double speed){
    herderMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
