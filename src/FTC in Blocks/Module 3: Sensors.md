# Sensors

## Color Sensor

I'm assuming you're using the REV color sensors. 
For color sensor v2:

The configuration type is "REV Color/Range sensor"
```
ColorRangeSensor sensor = hardwareMap.get(ColorRangeSensor.class, "color");
double blue = color.blue();
double distance = color.getDistance(DistanceUnit.INCH);
```

The sensor can return RGBA values either all together or individually. From experimentation, it seems that the way to get "blue percent" is doing `sensor.blue() / sensor.alpha()`.

For color sensor v3:

The configuration type is "REV color sensor v3"

**note: I don't know how these return colors because I haven't used them before**

## Touch Sensor

This assumes you are using REV touch sensors.

```
TouchSensor sensor;
// setup...
touch.isPressed();
```

It's pretty simple. It tells you if it's pressed or not.

## Distance Sensor

```
DistanceSensor sensor;
// setup stuff here
sensor.getDistance(DistanceUnit.INCH);
```

Sometimes the distance sensors are really weird and return values that are completely wrong or like 300 inches if it doesn't see anything. I recommend either tracking "last valid distance" if you know the maximum possible distance, or just throwing out values that are above a certain threshold.

## Magnetic Limit Switch

Pretty much it can measure when a STRONG ENOUGH magnetic field is present next to the sensor. You can use a stronger magnet if you want the sensor to detect it from further away.
