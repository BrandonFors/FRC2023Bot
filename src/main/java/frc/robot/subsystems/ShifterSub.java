// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShifterSub extends SubsystemBase {

  private DoubleSolenoid dSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.SolFwdChannel, Constants.SolBwdChannel);
  
  public ShifterSub() {
    
  }
  public void shiftForward(){
    dSolenoid.set(Value.kForward);

    
  }
  public void shiftReverse(){
    dSolenoid.set(Value.kReverse);
  }
  public void shiftOff(){
    dSolenoid.set(Value.kOff);
  }

  @Override
  public void periodic() {
    
  }
}
