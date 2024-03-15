# FTC Dashboard

### Installation

[Here](https://acmerobotics.github.io/ftc-dashboard/gettingstarted) are the steps to install FTC Dashboard into any FTC project.

### Use

Dashboard allows you to edit variables on the fly and see the effects without have to reupload code. Though, if you restart anything the changes will not stay in effect, so make sure to change variables in the files afterwards.

### Implementation

Variables you want to be able to change have to be declared as `public static` and the class has to be annotated with `@Config`. Also you stuff has to be in a loop so that the change actually affects anything.

```
@Config
@TeleOp(name="dashboard test")
public class myOpMode extends OpMode {
    public static double power = 0;
    DcMotorEx motor;

    public void init() {
        motor = hardwareMap.get(DcMotorEx.class, "motor");
    }

    public void loop() {
        motor.setPower(power);
    }
}
```

`@Config` just tells Dashboard that this OpMode has a Config variable.

[Previous Module](Module%206%3A%20IMU.md) | [Next Module](Module%207%3A%20PID.md)