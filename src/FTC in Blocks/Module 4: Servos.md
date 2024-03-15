# Servos

## Modes

Servos have two modes: Continuous and Stepper. Continuous just means that you tell it a certain power and it spins at that power. Stepper you tell it a position and it goes to that position and holds.

## Programming Servos

In stepper mode, the servo has a "left" and "right" limit where it operates within that defined range.

To switch which mode the servo is on, we need to use a servo programmer. This [link](https://docs.revrobotics.com/duo-build/actuators/servos/srs-programmer) has steps for switching modes.

Servo limits can also be adjusted(to a narrower range) using software.

![Servo Code](../BlocksImages/Module%204/servoScaling.png)

servo.scaleRange() makes it so the maximum, 1, is the second value (0.5) and that the minimum, 0, is the first value (0.25). This means that the next line `setPosition(1);`, goes to 0.5, not 1.