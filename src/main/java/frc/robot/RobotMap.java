/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //I've setup robotMap for you, as it will make your lives easier (and reduce potential for malfunction)
  //Note that if things don't work, you have have to change values in here.
  //Feel free to do so, but it might make things more complicated
  
	/**
	 * Intake CANIDs
	 */
	final static int INTAKE_ARM_TALON = 10;
	final static int INTAKE_ARM_VICTOR = 20;
	final static int INTAKE_ROLLER_TALON = 12;
	final static int INTAKE_LIMIT_SWITCH = 0;


	// Intake objects. These are what you will use to control the intake
	public static TalonSRX intakeArmTalon = new TalonSRX(INTAKE_ARM_TALON);
	public static VictorSPX intakeArmVictor = new VictorSPX(INTAKE_ARM_VICTOR);
	public static TalonSRX intakeRollerTalon = new TalonSRX(INTAKE_ROLLER_TALON);
	public static final DigitalInput intakeLimitSwitch = new DigitalInput(INTAKE_LIMIT_SWITCH);

	public RobotMap(){		
		//These are configurations for the motor controllers, don't worry about this part
		intakeArmVictor.follow(intakeArmTalon);

		intakeArmTalon.configOpenloopRamp(0.1);
		intakeArmTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog);
		intakeArmTalon.setSensorPhase(false);
		intakeArmTalon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
				LimitSwitchNormal.NormallyOpen);
		intakeArmTalon.config_kP(0, 1.0, 0);
		intakeArmTalon.config_kI(0, 0.0, 0);
		intakeArmTalon.config_kD(0, 0.001, 0);

	}

}
