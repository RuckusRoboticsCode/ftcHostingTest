# Module 0: Basics

|Table of Contents|
|-|
|[Setup](#setup)|
|[Op Modes](#op-modes)|
|[Linear](#linear)|
|[Iterative](#iterative)|

### Setup

**Connecting to WiFi**

When you turn on the control hub, it emits its own network signal (you can't access the internet). By default it is called "ftc-[random]" where [random] is a random string of characters and numbers and by default the password is "password." Connecting to the WiFi is how we will interact with the robot.

**Android Studio**

[Android Studio Download](https://developer.android.com/studio). I personally have had problems with using the version intended for apple (ARM) chips. Even if your computer has an apple chip, I think you can use the intel version.

**OnBot Java**

OnBot Java allows programmers to code in Java, directly onto the robot, without downloading additional software. The only downside is that specific libraries are not supported on OnBot Java. The most notable being RoadRunner and FtcLib. If you are using OnBot Java, you can skip the following SDK section.

**SDK**

[FTC files](https://github.com/FIRST-Tech-Challenge/FtcRobotController). From the latest release, downlaod the source code and extract it somewhere you won't delete it. Open this in Android Studio and you are ready to get started.

**Configuring Robot Controller**

**ADB (only if you are using control hub)**

This will allow you to wirelessly connect to the control hub and upload the code.

Download [platform-tools](https://developer.android.com/studio/releases/platform-tools) and put it somewhere you won't move or delete it. 

Next, in android studio, go to Preference > Tools > External Tools. Then create a new tool.

1. Name it whatever you want
2. In the "program" section, select the adb file you downloaded earlier.
3. In the "argument" section, write "connect 192.168.43.1:5555"
4. In the "working directory" section, select the "teamcode" folder in .../firstinspires/ftc

**Hardware Mapping on Robot Controller**
If you are using a two phone set up, use the phone attached to the robot (the robot controller). If you are using a control hub, use the drivers station. 

1. Locate the three dots at the top of screen
2. Select "Configure Robot"
3. If there is no other conifguration, select new
4. Scan for devices, your expansion hubs should appear here
5. Select one of hubs that appear (Depending on where the wire is plugged into)
6. The categories that appear correspond to parts of the expansion hub. 
7. When you click one of the categories, all the ports will appear 
8. Specify the hardware type and name it (this is how you call upon the port in your code during declaration, we will explain this further later)

Video: [Hardware Mapping for Software](https://www.youtube.com/watch?v=oH6ktVwPQb0)

### Uploading Code

**Phone**

Plug the phone into your computer and click the green triangle in the toolbar.

**NOTE**: After 2023 (CENTERSTAGE), connecting to the robot using phones will not be supported or competition legal and all teams should switch to control hubs.

**Control Hub**

Connect to the control hub's wifi network. If you are using a control hub, go to Tools > External Tools and use the tool you created to connect. Then click the green triangle in the toolbar.

### Op Modes

##### **Linear Op Mode** {#linear}

What is it:

Linear Op Modes run everything in order from top to bottom one time, they work like other coding programs, so they are easier to transition to.

How to use:

`public class myOpMode extends LinearOpMode {...}`

Functions:

`RunOpMode() {...}`

All the code that you want to run goes inside this function.

`waitForStart();`

Use this to differentiate what runs in INIT and START

`isStopRequested()`

It's just convention to have this before wait for start as `if(isStopRequested()) return;

Also, if you have any loops, it's good to have `while(firstCondition && !isStopRequested()) {...}`

`opModeIsActive()`

Similar use as the previous one, used in most of hte same places.

When to use:

This can be used for anything, if you want to mimic an interative opMode, simply put code in 

Requirements:

LinearOpModes must have the runOpMode() function to work.

##### **Iterative Op Modes** {#iterative}

What is it:

The main part of this Op Mode is a loop that runs over and over while the OpMode is active. This can be more dificult to program an autonomous in.

How to use:

`public class myOpMode extends OpMode {...}`

Functions:

`init() {...}`

Everything in this function runs once when init is pressed. This is usually where you put all the setup stuff

`init_loop() {...}`

Code in this function runs continutally after init() and when start has not been pressed.

`start() {...}`

Runs once when start is pressed.

`loop() {...}`

Runs continually once start is pressed (and after start() if you have it). 

`stop() {...}`

Runs once when stop is pressed.

When to use:

Iterative opModes are usually used for TeleOp because you want to continually check Controller input and act accordingly. Other uses include a finite state machine in autonomous to create a quasi-asynchronous program that can run things simultaneously.

Requirements:

Any iterative OpMode must have the init() and loop() function, all the others are optional.

**Note: as much as possible, don't use sleep() inside an iterative opMode**

[Next Module](Module%201%3A%20Basic%20Movement.md)
