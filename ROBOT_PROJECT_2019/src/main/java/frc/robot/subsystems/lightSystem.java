/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Add your docs here.
 */
public class lightSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final SpeedController color = RobotMap.lights;

  public void party () {
    color.set(-.77);
  }

  public void revenge () {
    color.set(-.05);
  }
  
  public void white () {
    color.set(.93);
  }
  
  public void blueShots () {
    color.set(-.83);
  }
  
  public void blue () {
    color.set(.85);
  }
  
  public void red () {
    color.set(.61);
  }
  
  public void beatBlue () {
    color.set(-.23);
  }
  
  public void oceanBlue () {
    color.set(-.41);
  }
  
  public void redShots () {
    color.set(-.85);
  }
  
  public void scannerRed () {
    color.set(-.35);
  }
  
  public void beatRed () {
    color.set(-.25);
  }
  
  public void beatWhite () {
    color.set(-.21);
  }
  
  public void scannerGray () {
    color.set(-.33);
  }
  
  public void gray () {
    color.set(.95);
  } 
  
  public void strobeYellow() {
    color.set(-.07);
    
  }
  
  public void lavaError() {
    color.set(.49);
    
  }
  
  public void off () {
    color.set(0);
  }
  
  public String getLightColor() {
    String Color = "Null";
    switch ((int)(color.get()*100)) {
    case   0: Color = "Off"; break;
    case  49: Color = "Error"; break;
    case  -7: Color = "Strobe"; break;
    case  95: Color = "Gray"; break;
    case -33: Color = "Scanner Gray"; break;
    case -41: Color = "Calming Ocean"; break;
    case -85: Color = "Red Bullets"; break;
    case -35: Color = "Scanner Red"; break;
    case -21: Color = "Beat White"; break;
    case -25: Color = "Beat Red"; break;
    case -23: Color = "Beat Blue"; break;
    case -77: Color = "Party Time"; break;
    case  -5: Color = "How I really feel"; break;
    case  93: Color = "Revenge"; break;
    case -83: Color = "Blue Shots"; break;
    case  85: Color = "Blue"; break;
    case  61: Color = "Red"; break;}
    return Color;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
