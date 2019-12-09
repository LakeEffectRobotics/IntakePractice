/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.time.temporal.TemporalQueries;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;

  //Create the intake
  public static Intake intake = new Intake();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
    RobotMap.init();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   */
  @Override
  public void robotPeriodic() {
    int position = RobotMap.intakeArmTalon.getSelectedSensorPosition();
    System.out.println(position - target);

    
  }

  //This is called when teleop is enabled
  @Override
  public void teleopInit() {
		//These are configurations for the motor controllers, don't worry about this part
  }

  double target=143;
  //This function is called periodically during teleop
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
        //This is where you'll want to put code used for testing and calibration.
    //Feel free to either use subststem functions or just call motors directly
    
    //Get the joystick value
    double joystickValue = 0.5 * -oi.xbox.getJoyLeftY();

    target = target+joystickValue;

    //Print out the value
    //System.out.println(RobotMap.intakeLimitSwitch.get());

    //Drive the motor with the speed from the joystick
    RobotMap.intakeArmTalon.set(ControlMode.Position, (int) target);
    //RobotMap.intakeArmTalon.set(ControlMode.PercentOutput, joystickValue);

    //returns true when not pressed, false when pressed
    if(RobotMap.intakeLimitSwitch.get()){
      RobotMap.intakeRollerTalon.set(ControlMode.PercentOutput, -0.3);
    }else{
      RobotMap.intakeRollerTalon.set(ControlMode.PercentOutput, 0);
      target = 350;
    }

  }


  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
}

