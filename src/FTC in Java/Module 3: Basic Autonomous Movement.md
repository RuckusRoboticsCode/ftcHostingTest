# Basic Autonomous Movement

|Table of Contents|
|-|
|[Background Information](#motor-modes-and-functions)|
|[Tasks](#tasks)|

### Motor Modes and Functions

**Information**

Encoders are spinning disks that are being used to track the rotation of the motors. They can be used to track rotations, but also velocity of the motors. Using encoders requires that you plug in the auxillary encoder cable.

Ticks refer to a unit of rotation taht the encoders track. Depending on the motor, there will be a different number of ticks/rotation.

**Changing Motor Modes**

`motor.setMode(DcMotor.RunMode.[INSERT MODE HERE]);`

**RUN_WITHOUT_ENCODERS**

This runmode means that using setPower() applies a percent of the available voltage to the motor. However, encoders are still being tracked if you want to use them for something else.

**RUN_WITH_ENCODERS**

This runmode means that using setPower() tries to reach a percent of the (predetermined) maximum RPM of the motor and it automatically adjusts the power as needed. Alternatively, this runmode also offers the use of setVelocity(), in ticks/second, and tries to apply the power needed to reach this velocity. This runmode also requires that you have the encoder cable plugged in.

**RUN_TO_POSITION**

In this runmode, you specify the "tick" that you want to reach and also the MAXIMUM power or velocity, it will try to reach this target. As it gets closer, it slows down and tries to accurately reach this target. It also means that if nothing changes, it will try and maintain the current position even if there is external force being applied to it. This runmode requires the encoder cable to be plugged in.

**STOP_AND_RESET_ENCODERS**

This isn't technically a runmode, but it is used in the same way. It stops the motor and resets the current encoder to "0". While it is technically possible to reset the encoder without stopping, it is not recommended and if the motor is moving may not work as you expect. 

### Tasks

Proficient:

- [ ] Create a function to input a distance in inches and return how many ticks that is
- [ ] Drive forward 23 inches &plusmn; 15%

Advanced:

- [ ] Modularize it

There is bound to be a little error because rotational distance (especially using mecanum wheels which slip a lot) doesn't translate perfectly to linear distance.

[Previous Module](Module%202%3A%20Basic%20TeleOp.md) | [Next Module](Module%204%3A%20Sensors%20and%20Servos.md)