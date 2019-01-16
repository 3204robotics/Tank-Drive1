package org.usfirst.frc.team3204.robot.subsystems;

import org.usfirst.frc.team6637.robot.commands.TeleopDrive_Command;



//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DMC60;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team3204.robot.RobotMap;

/**
 *
 */
public class Drive_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSPX leftMaster = new VictorSPX(RobotMap.leftMaster);
	VictorSPX leftSlave = new VictorSPX(RobotMap.leftSlave);
	DMC60 rightMaster = new DMC60(RobotMap.rightMaster);
	DMC60 rightSlave = new DMC60(RobotMap.rightSlave);
	
	DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
	
	public Drive_Subsystem() {
		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);
	}
	
	public void teleopDrive(double move, double turn) {
		drive.arcadeDrive(move, turn);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDrive_Command());
    }
}

