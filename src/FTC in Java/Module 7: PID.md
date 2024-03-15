# Module 7: PID & FF

|Table of Contents|
|-|
|[What it is](#what-is-it)|
|[Example Uses](#example-use)|
|[Tuning](#tuning-a-pid-controller)|
|[PID Task](#pid-task)|
|[Feedforward](#feedforward-component)|
|[Feedforward Examples](#feedforward-examples)|
|[FF Task](#feedforward-tasks)|

### What is it

There are 3 terms in a PID controller. a proportional gain (P), an integral gain (I), and a derivative gain (D). PID controllers take two inputs, the target(where you want to be) and the plant(where you are). The goal is to tune the 3 terms and when you tell it where you want to go and where you are, it brings the system there.

### Example Use

One common way to use PID controllers is to turn to a specific heading and not overshoot or undershoot.

Another common way to use a PID controller is to move linear slides to target position (height) and maintain it after it reaches. This may sound very familiar, that's beacuse thisis how RUN_TO_POSITION works behind the scene. It tends to reach the target more accurately and quickly if you are using a custom PID controller.

### Tuning a PID controller

Pretty good [tutorial](https://www.youtube.com/watch?v=E6H6Nqe6qJo&t=391s) on how to tune a PIDF controller.

### PID Task

Proficient:

- [ ] Tune a PID controller to turn to a specified heading taking inputs of current heading and target heading

Advanced:

- [ ] Always takes the shortest turn

### Feedforward Component

There can be a 4th term that is feedforward. Feedforward tries to take corrective action before the error happens/accumulates. 

### Feedforward Examples

One common way to use feedforward control is to keep linear slides or an arm up. 

**Linear Slides**

This is a constant because the force of gravity acting on the slides is constant. So if would be something like

```java
double ff = 0.2;
double power = pid.calculate(plant, error) + ff;
```

So you would have to find what power is needed to hold the slides up, but not move them up.

**Arm**

The power needed to hold an arm up is the highest when the arm is parallel to the ground and is lowest when the arm is perpendicular to the ground. 

So to counteract this, we need to calculate the angle of the arm at any time, which we can do with encoders. 

So to calculate the feedforward we can use Cos(angle) so that when the angle is 0, the power is at the highest.

```java
double kf = 0.2;
double ff = Math.cos(armAngle) * kf;
power = PID.calculate(plant, error) + ff;
```

### Feedforward Tasks

- [ ] Tune a PIDF controller for linear slides

[Previous Module](Module%206.5%3A%20FtcDashboard.md) | [Next Module](Module%208%3A%20CYOA.md)