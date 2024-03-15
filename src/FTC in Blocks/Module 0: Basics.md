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

**Accessing Blocks**

After you connect to the network, on your browser, open the website "192.168.43.1:8080" and click the blocks tab.

**Configuring Robot Controller**

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

WHen you are connected to the robot and you are on the blocks tab, you can click the "save OpMode" button in the top left corner to upload the block code.

### Op Modes

##### **Linear Op Mode** {#linear}

What is it:

Linear Op Modes run everything in order from top to bottom one time, they work like other coding programs, so they are easier to transition to.

Here are some notable blocks that will show up in most of your programs.

![RunOpMode() {...}](../BlocksImages/Module%200/runOpMode.png)

All the code that you want to run goes inside this block.

![waitForStart](../BlocksImages/Module%200/waitForStart.png)

Use this to differentiate what runs in INIT and START

![opModeIsActive](../BlocksImages/Module%200/opModeIsActive.png)

Just always have the first block inside be waitForStart in case something goes wrong, it will stop reading the code. 

If you have any loops, it's good to have this condition in it as well. Like:

![opModeIsActive](../BlocksImages/Module%200/opModeIsActiveWhile.png)

[Next Module]
