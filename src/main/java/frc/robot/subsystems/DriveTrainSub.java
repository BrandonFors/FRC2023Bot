// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DriveTrainSub extends SubsystemBase {
  //motors
  private CANSparkMax FrontRightMotor = new CANSparkMax(Constants.FrontRightMotorChannel, MotorType.kBrushless);
  private CANSparkMax FrontLeftMotor = new CANSparkMax(Constants.FrontLeftMotorChannel, MotorType.kBrushless);
  private CANSparkMax BackRightMotor = new CANSparkMax(Constants.BackRightMotorChannel, MotorType.kBrushless);
  private CANSparkMax BackLeftMotor = new CANSparkMax(Constants.BackLeftMotorChannel, MotorType.kBrushless);

  private final MotorControllerGroup rightMotors = new MotorControllerGroup(FrontRightMotor,BackRightMotor);
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(FrontLeftMotor, BackLeftMotor);

  private DifferentialDrive driveTrain = new DifferentialDrive(leftMotors, rightMotors);


  private RelativeEncoder leftDriveEncoder = FrontLeftMotor.getEncoder();
  private RelativeEncoder rightDriveEncoder = FrontRightMotor.getEncoder();

  
  
  private AHRS navX = new AHRS(SPI.Port.kMXP);
  
  public DriveTrainSub() {

  }

  public void driveRobot(double speed,double rotation){
    driveTrain.arcadeDrive(rotation, speed);
  
  }
  


  

  public double getPitch(){
    return navX.getPitch();
  }
  public double getRightEncoder(){
    return rightDriveEncoder.getPosition();
  }
  public double getLeftEncoder(){
    return leftDriveEncoder.getPosition();
  }
  public void setRightEncoder(double setpoint){
    rightDriveEncoder.setPosition(setpoint);
  }
  public void setLeftEncoder(double setpoint){
    leftDriveEncoder.setPosition(setpoint);
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Pitch Angle", navX.getPitch());
    SmartDashboard.putNumber("Gyro", navX.getAngle());
    SmartDashboard.putNumber("Right Encoder", leftDriveEncoder.getPosition());
    SmartDashboard.putNumber("Left Encoder", rightDriveEncoder.getPosition());
    
    SmartDashboard.putNumber("FrontRightTemp", FrontRightMotor.getMotorTemperature());
    SmartDashboard.putNumber("FrontLeftTemp", FrontLeftMotor.getMotorTemperature());
    SmartDashboard.putNumber("BackLeftTemp", BackLeftMotor.getMotorTemperature());
    SmartDashboard.putNumber("BackRightTemp", BackRightMotor.getMotorTemperature());

    SmartDashboard.putNumber("FrontRightAMP", FrontRightMotor.getAppliedOutput());
    SmartDashboard.putNumber("FrontLeftAMP", FrontLeftMotor.getAppliedOutput());
    SmartDashboard.putNumber("BackRightAMP", BackRightMotor.getAppliedOutput());
    SmartDashboard.putNumber("BackLeftAMP", BackLeftMotor.getAppliedOutput());



  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
