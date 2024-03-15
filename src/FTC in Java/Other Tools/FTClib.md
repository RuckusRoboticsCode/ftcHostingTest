# FTClib

Ftclib has a lot of great resources and it's library is pretty extensive.

### Command Based

The bulk of ftclib is about command based programming. Command-based is a programming paradigm used in ftc that describes things you want the robot to do as "commands" or "actions" that are triggered on certain "events". They all run in a loop, which allows things to update quasi-concurrently.

### GamepadEx

[GamepadEx](https://docs.ftclib.org/ftclib/v/v2.0.0/features/gamepad-extensions) is a class provided in the core library that makes using the gamepad easier. It provides functions that allow you to track buttonDown and buttonUp so you only run it once when the button is clicked.

When you use this, make sure the FIRST line in loop() is ".readValue()".

### PIDcontroller

[PIDcontroller](https://docs.ftclib.org/ftclib/v/v2.0.0/features/controllers) is an easy-to-use implementation of a PID controller. You still need to tune the variables and feed it your plant and target, however the actual implementation for calculations and stuff is done for you.