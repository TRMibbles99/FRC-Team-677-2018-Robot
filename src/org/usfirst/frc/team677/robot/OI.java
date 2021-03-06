/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot;

import org.usfirst.frc.team677.robot.commands.Eject;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.IntakeDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick driveCont = new Joystick(Global.JOYSTICK_DRIVE);
	public static Joystick auxCont = new Joystick(Global.JOYSTICK_AUX);
	public static Button buttonA = new JoystickButton(driveCont, Global.BUTTON_A);
	public static Button buttonB = new JoystickButton(driveCont, Global.BUTTON_B);
	public static Button buttonX = new JoystickButton(driveCont, Global.BUTTON_X);
	public static Button buttonY = new JoystickButton(driveCont, Global.BUTTON_Y);
	public static Button leftBumper = new JoystickButton(driveCont, Global.LEFT_BUMPER);
	public static Button rightBumper = new JoystickButton(driveCont, Global.RIGHT_BUMPER);
	public static Button select = new JoystickButton(driveCont, Global.SELECT);
	public static Button start = new JoystickButton(driveCont, Global.START);

	public static Button auxButtonA = new JoystickButton(auxCont, Global.BUTTON_A);
	public static Button auxButtonB = new JoystickButton(auxCont, Global.BUTTON_B);
	public static Button auxButtonX = new JoystickButton(auxCont, Global.BUTTON_X);
	public static Button auxButtonY = new JoystickButton(auxCont, Global.BUTTON_Y);
	public static Button auxLeftBumper = new JoystickButton(auxCont, Global.LEFT_BUMPER);
	public static Button auxRightBumper = new JoystickButton(auxCont, Global.RIGHT_BUMPER);
	public static Button auxSelect = new JoystickButton(auxCont, Global.SELECT);
	public static Button auxStart = new JoystickButton(auxCont, Global.START);

	// Default constructor
	public OI() {
		auxButtonA.whileHeld(new Grab(true, false));
		auxButtonA.whenReleased(new Grab(false, false));
		//buttonA.whenPressed(new RampLift(false));
		//buttonB.whenPressed(new RampRelease(false));
		//Intake and eject commands. TODO: Tune the speeds and directions
		auxLeftBumper.whileHeld(new IntakeDrive(1));
		auxRightBumper.whileHeld(new IntakeDrive(-1));
		auxButtonY.whenPressed(new Eject());
	}
}
