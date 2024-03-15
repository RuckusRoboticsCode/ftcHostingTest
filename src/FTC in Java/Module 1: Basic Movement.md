# Module 1: Basic Movement

|Table of Contents|
|-|
|[Background Information](#background-information)|
|[Tasks](#tasks)|

### Background Information

**Example**
```java
@Autonomous(name="square")
public class squareDriving extends LinearOpMode {

    DcMotorEx motor;
    ElapsedTime time;

    public void runOpMode() {
        motor = hardwareMap.get(DcMotorEx.class, "motor");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);

        time = new ElapsedTime();

        waitForStart();

        time.reset();
        sleep(1000);
        int seconds = time.seconds();
        while(opModeIsActive) {
            motor.setPower(0.75);
        }
    }

}
```

`@Autonomous(name="square")`

This annotation makes it so that this OpMode shows up in the autonomous list on the driver station.

Here we have a basic opMode structure using a LinearOpMode. I (usually) declare variables outside runOpMode(), however if you know you are not using them anywhere else, you can declare them in the lower scope. 

`DcMotorEx motor;`

Here, we declare a motor of type DcMotorEx that we called "motor." All motors connected to a REV Expansion Hub can be declared as DcMotorEx.

`ElapsedTime time;`

Here, we declare an object called "time" of type ElapsedTime. This can be used to keep track of time.

`motor = hardwareMap.get(DcMotorEx.class, "motor");`

Here we are assigning a value to the DcMotorEx called "motor". "hardwareMap" is the configuration of the robot controller that we set previously. We pass two arguments, the first is the type of object we are looking for, in this case DcMotorEx. The second argument we pass is the name in the configuration, in this case "motor". 

`motor.setDirection(DcMotorSimple.Direction.REVERSE);`

This function here reverses the direction of the motor. If originally setPower(1) made it rotate counter-clockwise, then after it's been reversed it will instead rotate clockwise.

`motor.setPower(0.75)`

This function takes an input between -1 and 1 and gives a proportionate amount of the available voltage.

`time = new ElaspedTime()`

Here we assign the variable "time" to be a new instance of an ElapsedTime class.

`time.reset()`

Here we reset the ElapsedTime object time.

`time.seconds()`

This return the seconds since the last time this object was reset (or since it was created if it was never reset).

### Tasks

The first task is to drive in a square using time (it doesn't have to be perfect).

Proficient: 
- [ ] Drive forward for 2 seconds
- [ ] Turn 90(ish) degrees
- [ ] Drive in a square

Advanced:
- [ ] Modularize movement
- [ ] Variable drive time

[Previous Module](Module%200%3A%20Basics.md) | [Next Module](Module%202%3A%20Basic%20TeleOp.md)