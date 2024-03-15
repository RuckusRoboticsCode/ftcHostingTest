# Basic TeleOp & More Motors

|Table of Contents|
|-|
|[Tele Op Example](#tele-op)|
|[Tasks](#tasks)|

### Tele Op

**Gamepad Example**

```java
@TeleOp(name="basic tele")
public class myTeleOp extends OpMode {

    DcMotorEx motor;

    public void init() {
        motor = hardwareMap.get(DcMotorEx.class, "motor");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void loop() {
        motor.setPower(gamepad1.left_stick_y); // not 100% sure, but I think that left_stick_y returns positive as you go down and negative as you go up
        if(gamepad1.A) {
            motor.setPower(0);
        }
    }
}
```

`@TeleOp(name="basic tele")`

This annotation puts this OpMode in the teleOp list on the driver station.

First we do all our standard setup for variables and stuff. 

`gamepad1.left_stick_y`

This returns the left stick value. Not 100% sure, but I think it actually returns negative when you push the joystick up and postiive when you push the joystick down.

`gamepad1.A`

This returns whether the button "A" is currently pressed.

### Tasks

Proficient: 
- [ ] Drive forward and backward using Left Joystick Y
- [ ] Turn left and right using Right Joystick X

Advanced:
- [ ] Be able to use both left and right joystick at the same time
- [ ] Add smoothing functions to the input
- [ ] Report power using telemetry

[Previous Module](Module%201%3A%20Basic%20Movement.md) | [Next Module](Module%203%3A%20Basic%20Autonomous%20Movement.md)