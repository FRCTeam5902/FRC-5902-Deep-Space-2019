# FRC-5902-Deep-Space-2019
Deep Space 2019 Code for team 5902

#2019 Notes

# Robot Subsystems

## DriveTrain - Robot Driving
Talon SRX Motor Controllers connected 
- Left Motor Lead (3)
- Left Motor Follow (4)

- Right Motor Lead (1)
- Right Motor Follow (2)

## cargoSystem - Method to Intake and Eject the cargo Ball
Talon SRX Motor Controllers connected 
- Right Motor Lead (5)
- Right Motor Follow (6)

## hatchSystem
Rev Smart Robotics Servos
- Rev Smart Robotics Servo (PWM 1) - Arm
- Rev Smart Robotics Servo (PWM 2) - Triangle

## pneumaticSystem
Single solenoids connected 
- frontPistons (1)
- backPistons (0)

## lightSystem
Rev Robotics Blinkin Light Controllers
- Right Light Controller (PWM 0)
- Left Light Controller  (PWM 3)

# Sandstorm Mode

Code to be used during the sandstorm portion of the game

Two options selectable on Shuffleboard
1- Do Nothing - Robot sits still and implements arcade drive for driver controlled sandstorm.
2- Drive Straight - has the robot drive straight with cargo in front off of the lower hab and then allows driver control.

# Teleop Mode

During teleop mode the robot can run commands as well as having the driver drive around. On the drive station computer, there is a SmartDashboard runnng shuffleboard that will display information from the robot to the drivers.

## Driver Station Shuffleboard (SmartDashboard)

On shuffleboard we have the following
- USB Camera Feeds (5 cameras)
- Status of Front & Back Pistons
- Status of Pressure Switch
- Basic Field Information
- What direction drive is currently in
- Chooser for Auto mode. Defaulting to do nothing.


## 2019 Driver Controls


### Operator Interface Assignments

| Button  | Button # | Command |
| ------------- | ------------- | ------------- |
| Drive Joystick Trigger | 1 | Toggle front and back of robot direction |
| Cargo Intake Joystick Trigger | 1 | .95 Eject Direction |
| AC Button 1  | 1 | Front Piston Toggle |
| AC Button 2  | 2 | Back Piston Toggle |
| AC Button 3  | 3 | All Pistons Off |
| AC Button 4  | 4 | Hatch Servo - Arm Down |
| AC Button 5  | 5 | Hatch Servo - Arm Partway |
| AC Button 6  | 6 | Hatch Servo - Arm Up |
| AC Button 7  | 7 | Hatch Servo - Triangle Up |
| AC Button 8  | 8 | Hatch Servo - Triangle Down |
| AC Button 9  | 9 | Unassigned |