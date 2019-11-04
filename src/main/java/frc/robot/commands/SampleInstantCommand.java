/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This is a simple instant command you can use for reference.
 * It doesn't do much
 */
public class SampleInstantCommand extends InstantCommand {
  
  //A variable to store the argument so it can be used later
  String msg;

  //This is called when the command is created.
  //You don't need to have any arguments, I just added one so you hae a reference
  public SampleInstantCommand(String s) {
    super();
    //While this doesn't really need the intake, I put this here as an exapmle
    requires(Robot.intake);

    //Copy the message to a class variable
    msg = s;
  }

  //Called once when the command executes
  //This is where you want to do things (read sensors, drive motors, etc)
  @Override
  protected void initialize() {
    System.out.println("The message is: "+msg);
  }

}
