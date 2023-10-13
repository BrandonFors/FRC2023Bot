// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.concurrent.CancellationException;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class LadderSub extends SubsystemBase {

  /** Creates a new LadderSub. */
  private final CANSparkMax liftMotor = new CANSparkMax(Constants.elevatorLiftMotorChannel, MotorType.kBrushed);
  private final RelativeEncoder liftEncoder = liftMotor.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 8192);
   public LadderSub() {
    setLiftEncoder(Constants.liftMidSetpoint);
    
  }
  

  public void driveLift(double speed){
    liftMotor.set(speed);
  }

  

  public double getLiftEncoder(){
    return liftEncoder.getPosition();
  }
  public void setLiftEncoder(double val){
    liftEncoder.setPosition(val);
    
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Hieght", liftEncoder.getPosition());

  }
}
