# Basic Autonomous

## Motor Control

The motors spin counter clockwise by default, but we can change this in our software. If all motors spin the same direction, the left and right side motors will spin in opposite directions, so we typically reverse both motors on one side.

![Reverse Motor Direction](../BlocksImages/Module%201/reverseMotorDirection.png)

Motors accept a "power", which is a percentage of the available voltage from the battery. This can range between -1 and 1, with negative values spinning the motor in the reverse direction.

Once we have reversed the motors, setting all motors to a power of 1 will move it forward.

![Drive Forward](../BlocksImages/Module%201/motorPower.png)

## Tracking Time

Now, we are going to learn how to track time so we can stop the motors after a set amount of time.

![Timer Set Up](../BlocksImages/Module%201/elapsedTime.png)

This creates a variable "runtime" as a new "ElapsedTime" (our timer). We tell the timer to reset after we click start. Next, the condition for our while loop tells the code to keep looping while the number of seconds tracked by the timer is less than 2 seconds. While in this loop, we are just adding telemetry (text on the screen) with how many milliseconds have been tracked.

## Putting it Together

Now we can move motors and track time, so let's put it together and make our robot drive for a set amount of time.

![Putting it Together](../BlocksImages/Module%201/full.png)

## Task