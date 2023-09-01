// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkMaxRelativeEncoder;
import frc.robot.Constants;

public class LadderTiltSub extends SubsystemBase {

  private final CANSparkMax tiltMotor = new CANSparkMax(Constants.elevatorTiltMotorChannel, MotorType.kBrushed);
  private final RelativeEncoder tiltEncoder = tiltMotor.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 8192);
  public LadderTiltSub() {
    

  }

  public void driveTilt(double speed){
    tiltMotor.set(speed);
  }

  public double getTiltEncoder(){
    return tiltEncoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Tilt", tiltEncoder.getPosition());
  }
}
