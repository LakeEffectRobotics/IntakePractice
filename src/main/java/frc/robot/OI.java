/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.SampleInstantCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //I have included the team's Xbox controller wrapper in this project.
  //This is how you create the xbox controller
  public XBoxController xbox = new XBoxController(2);
  
  
  //// CREATING BUTTONS
  //First you define the constants that represent the buttons
  static final int BUTTON = XBoxController.XBOX_A;
  
  //To create a new button, use the following syntax:
  XBoxButton button = new XBoxButton(xbox, BUTTON);

  public OI(){
    //Put your button commands in here using the syntax:
    button.whenPressed(new SampleInstantCommand("The button was pressed!"));

  }
}
