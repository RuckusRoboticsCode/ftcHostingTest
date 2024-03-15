# Mecanum TeleOp

I'll include the diagram of mecanum movement here as a reminder.

![Mecanum Movement Diagram](../Images/mecanumMotion.png)

## Mecanum TeleOp

**Robot Centric**

Robot centric driving just means that our idea of "forward" is whatever direction the robot is facing.

When the left joystick is at (0, 1), the robot should move forward and (0, -1) should move backwards. (1, 0) should move to the right and (-1, 0) should move to the left. 

When the right joystick is at (1, 0), the robot should turn clockwise and at (-1, 0) the robot should turn counter clockwise. The y value of the right joystick shouldn't change anything.

I know this is a lot of requirements, but give it a try before looking at the solution. When you look at the solution, don't just accept that it's true. Try the code on your robot and also think about all the different situations I named above and convince yourself that it works as intended.

<details>
    <summary>Solution</summary>
    <IMG src="../BlocksImages/Module 7/robotMecanumTele.png">
</details>

**Field Centric**

Field centric driving means "forward" is a set direction no matter how robot is facing. This typically means the direction the driver is facing is "forward." This works by rotating the inputs based on the direction of robot. This uses the IMU (gyroscope) built into the control hub to figure out the orientation at any given time. So, if you haven't read the module on the IMU, read that before continuing. [Here](https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html) is a good reseource explaining how it works.

![Field Centric](../BlocksImages/Module%207/fieldCentric.png)