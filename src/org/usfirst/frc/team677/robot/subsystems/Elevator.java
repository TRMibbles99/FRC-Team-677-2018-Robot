package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Tankdrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static TalonSRX pulley = new TalonSRX(RobotMap.ELEVATOR_PORT);
//	public static DigitalInput limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
	
	public Elevator() {	
		pulley.setNeutralMode(NeutralMode.Brake);
	}

	public static void drive(double speed) {
		pulley.set(ControlMode.PercentOutput, speed);
	}
	
//	public static boolean checkSwitch() {
//		return limitSwitch.get();
//	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorManual());
    }
}

