# Localization Hardware

### What is localization

Localization is just tracking where you are on the field. There are many ways to do this, which each have their pros and cons. Knowing where the robot is is the basis of any path following or motion profiling software.

### When do we use it

Localization is useful if you are trying to create an autonomous program with complex movement or if you need to know where on the field the robot is.

### Implementations

**Distance Sensors**

Some teams have put distance sensors on one or two sides of the robot and use the return distance to calculate where they are on the field.

Pros:
- Parts readily available
- Easy to code

Cons:
- Distance sensors aren't that accurate

**Touch Sensor**

Some teams have put touch sensors on one or two sides of the robot. This can be used in conjunction with another form of localization to give it periodically acurrate data (when it hits a wall, you know one of the coordinates).

Pros:
- When it is hit, you know one of the coordinates accurately
- Parts readily available
- Easyish to code

Cons:
- Robot has to hit a wall
- not good on it's own because you only get data when you hit a wall

**Drive Encoders**

You can use the rotations of the drivetrain motors to track where the robot is. This is relatively accurate and can be implemented without any extra sensors.

Pros:
- Almost all motors have encoders
- Relatively accurate
- Lots of code online for this
- Can be used with roadrunner(talk about this in another module)

Cons:
- Drift cannot be acounted for over time
- Rotational motion can't be perfectly translated to linear motion

All wheels "slip" sometimes. Omni wheels the most and Mecanum wheels a little less and traction wheels the least. However the motors don't know about this "slip", so when it happens your localization won't be able to account for it.

**2-Wheel Dead Wheels**

Deadwheels are small unpowered omni wheels that are attached to encoders. If we use two, we put on parallel and one perpendicular to the robot. This lets us track forward movement (perpendicular) and sideways movement (parallel). These wheels are attached to springs which ensure that it is always touching the ground.

Pros:
- Encoders are accurate (usually Rev Through Bore)
- Dead wheels can track "slip"
- Can use Roadrunner(another module)

Cons:
- Encoders are expensive (usually Rev Through Bore)
- Have to use IMU for heading

**3-Wheel Dead Wheels**

3-Wheel dead wheels work the same as 2-wheel dead wheels, except now we have two perpendicular dead wheels. This allows us to track heading using the difference in encoder ticks.

Pros:
- Heading more accurate(no drift error)
- Same as 2 wheel

Cons:
- Even more expensive than 2-wheel

**Vuforia**

Vuforia is the 4 pictures that are taped on the walls of the field. We can use computer vision to identify the image and where we are relative to it. This is fairly accurate IF the camera can recognize it. Through testing, we found that it's only accurate within <30-40 cm, which is not ideal.

Pros:
- Accurate

Cons:
- Annoying to code, but there are basic versions as examples
- Not great at mid-long distances
- No way to update if you don't see an image