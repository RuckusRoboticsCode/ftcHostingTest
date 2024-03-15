# IMU

|Table of Contents|
|-|
|[What it is](#what-it-is)|
|[Uses](#uses)|
|[Setup](#setup)|
|[Tasks](#tasks)|

### What it is

Almost all expansion and control hub have an IMU (internal measurement unit). For our purposes this includes an accelerometer, a magnometer, and a gyroscope.

### Uses

The most common use is for the gyroscope to get your heading. 

Although you, in theory, can use the accelerometer to track the robot's position, the accumulated error adds up quickly and it isn't worth using.

### Setup

By default, I2C Bus 0, port 0 is the IMU. Do not attach any other device here if you plan to use the IMU.

```java
IMU.Parameters parameters;

parameters = new IMU.parameters(
    new RevHubOrientationOnRobot(
          RevHubOrientationOnRobotLogoFacingDirection.UP,
          RevHubOrientationOnRobotUsbFacingDirection.FORWARD
     )
); // this orientation system is useful if you are orienting the hub not at a weird angle
```

This is the way to create parameters to initialize the IMU with so it knows its orientation.

```java
IMU imu;
imu = hardwareMap.get(IMU.class, "imu");
imu.initialize(parameters);
```

This tells the hub which way it starts

```java
YawPitchRollAngles robotOrientation;
robotOrientation = imu.getRobotYawPitchRollAngles();

double Yaw   = robotOrientation.getYaw(AngleUnit.DEGREES);
double Pitch = robotOrientation.getPitch(AngleUnit.DEGREES);
double Roll  = robotOrientation.getRoll(AngleUnit.DEGREES);
```

And here we can extract data from the IMU.

### Tasks

Proficient:

- [ ] Report current heading to telemetry

Advanced:

- [ ] Correct heading while driving straight

[Previous Module](Module%205%3A%20Mecanum%20Movement.md) | [Next Module](Module%206.5%3A%20FtcDashboard.md)