# Localization Software

This assumes you read all the hardware stuff and understand what they and what they do.

### Drive Encoders

Drive encoder localization uses how much the drivetrain motors have spun to track the position of the robot. To do this, it is important to understand the kinematics of differnet types of drivetrains.

[Here](https://research.ijcaonline.org/volume113/number3/pxc3901586.pdf) is a great resource on mecanum kinematics, based on these equations, you should be able to build out a localizer.

### Dead wheels

This should be a lot easier to implement. You convert rotational motion into translational motion and rotate that vector by the heading of the robot.