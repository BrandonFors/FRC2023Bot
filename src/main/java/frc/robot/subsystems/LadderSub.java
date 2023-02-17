// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.concurrent.CancellationException;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LadderSub extends SubsystemBase {
  /** Creates a new LadderSub. */
  private final CANSparkMax liftMotor = new CANSparkMax(Constants.elevatorLiftMotorChannel, MotorType.kBrushless);
  private final CANSparkMax tiltMotor = new CANSparkMax(Constants.elevatorTiltMotorChannel, MotorType.kBrushless);
  private final RelativeEncoder lifEncoder = liftMotor.getEncoder();
  private final RelativeEncoder tiltEncoder = tiltMotor.getEncoder();
  
  public LadderSub() {
    
  }

  public void driveLift(double speed){
    liftMotor.set(speed);
  }

  public void driveTilt(double speed){
    tiltMotor.set(speed);
  }

  public double getLiftEncoder(){
    return lifEncoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
