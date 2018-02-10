package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LCenterPosition extends CommandGroup {

    public LCenterPosition() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential (new ResetGyro());
    	addSequential (new AutoStraightForward (Global.AUTO_FRONT_DISTANCE_ONE));
    	addSequential (new Turn (Global.AUTO_TURN_LEFT));
    	addSequential (new AutoStraightForward (Global.AUTO_FRONT_DISTANCE_TWO));
    	addSequential (new Turn (Global.AUTO_TURN_RIGHT));
    	addSequential (new AutoStraightForward (Global.AUTO_FRONT_DISTANCE_THREE));
    	//TODO: add command to drop cube
    	
    }
}