/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.OI;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Tankdrive extends Command {
	
	public Tankdrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
	}

	protected void execute() {
		if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) > Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, OI.driveCont.getRawAxis(5)*.5);
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) > Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE){
			Drivetrain.setSpeed(ControlMode.PercentOutput, OI.driveCont.getRawAxis(1)*.5, 0);
		} else {
			Drivetrain.setSpeed(ControlMode.PercentOutput, OI.driveCont.getRawAxis(1)*.5, OI.driveCont.getRawAxis(5)*.5);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
	}
}
