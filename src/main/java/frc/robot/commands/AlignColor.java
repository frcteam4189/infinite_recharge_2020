/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSpinner;


public class AlignColor extends CommandBase {
  /**
   * Creates a new AlignColor.
   */

  private ColorWheelSpinner spinner;

  private String targetColor = DriverStation.getInstance().getGameSpecificMessage();

  public AlignColor(ColorWheelSpinner input) {
    this.spinner = input;
    addRequirements(spinner);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    targetColor = DriverStation.getInstance().getGameSpecificMessage();
    spinner.wheelSpinner.set(ControlMode.PercentOutput, 1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinner.wheelSpinner.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(spinner.detectColors() == targetColor)
      return true;
    return false;
}
}
