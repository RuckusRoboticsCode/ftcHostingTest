# Module 4: Sensors and Servos

|Table of Contents|
|-|
|[Servos](#servos)|
|[Servo Tasks](#servo-tasks)|
|[Sensors](#sensors)|
|[Color](#color-sensor)|
|[Touch](#touch-sensor)|
|[Distance](#distance-sensor)|
|[Limit Switch](#magnetic-limit-switch)|
|[Sensor Tasks](#sensor-tasks)|

### Servos

**Modes**

Servos have two modes: Continuous and Stepper. Continuous just means that you tell it a certain power and it spins at that power. Stepper you tell it a position and it goes to that position and holds.

**Programming Servos**

In stepper mode, the servo has a "left" and "right" limit where it operates within that defined range.

To switch which mode the servo is on, we need to use a servo programmer. This [link](https://docs.revrobotics.com/duo-build/actuators/servos/srs-programmer) has steps for switching modes.

Servo limits can also be adjusted(to a narrower range) using software.

```java
Servo servo;
servo.scaleRange(0.25, 0.5);
servo.setPosition(1);
```

servo.scaleRange() makes it so the maximum, 1, is the second value (0.5) and that the minimum, 0, is the first value (0.25). This means that the next line `setPosition(1);`, goes to 0.5, not 1.

### Servo Tasks

- [ ] Program a claw to open and close

### Sensors

##### **Color Sensor**

I'm assuming you're using the REV color sensors. 
For color sensor v2:

The configuration type is "REV Color/Range sensor"
```java
ColorRangeSensor sensor = hardwareMap.get(ColorRangeSensor.class, "color");
double blue = color.blue();
double distance = color.getDistance(DistanceUnit.INCH);
```

The sensor can return RGBA values either all together or individually. From experimentation, it seems that the way to get "blue percent" is doing `sensor.blue() / sensor.alpha()`.

For color sensor v3:

The configuration type is "REV color sensor v3"

**note: I don't know how these return colors because I haven't used them before**

##### **Touch Sensor**

This assumes you are using REV touch sensors.

```java
TouchSensor sensor;
// setup...
touch.isPressed();
```

It's pretty simple. It tells you if it's pressed or not.

##### **Distance Sensor**

```java
DistanceSensor sensor;
// setup stuff here
sensor.getDistance(DistanceUnit.INCH);
```

Sometimes the distance sensors are really weird and return values that are completely wrong or like 300 inches if it doesn't see anything. I recommend either tracking "last valid distance" if you know the maximum possible distance, or just throwing out values that are above a certain threshold.

##### **Magnetic Limit Switch**

Pretty much it can measure when a STRONG ENOUGH magnetic field is present next to the sensor. You can use a stronger magnet if you want the sensor to detect it from further away.

### Sensor Tasks

Proficient:

- [ ] Close a claw if the color is BLUE and is closer than 3 inches.
- [ ] Move backward, if the distance < 10, stop.

Advanced:

- [ ] Center an object in front of the robot using two distance sensors

[Previous Module](Module%203%3A%20Basic%20Autonomous%20Movement.md) | [Next Module](Module%205%3A%20Mecanum%20Movement.md)
