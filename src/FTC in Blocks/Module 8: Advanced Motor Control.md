# Advanced Motor Control

## Encoders

Motors have a little disk inside them that spins with the motor. On this disk there are black lines and the motor is capable of counting how many black lines pass by. These are called encoder ticks or encoder counts. If the disk has 360 black lines, then each time it counts one line, we know the motor has spun 1<sup>o</sup> degree.

## Velocity

Now I will introduce another way to control motor movement. Previously we set the power to the motor, but if the battery is low this will result in different speeds. Another option that is availble is controlling the velocity of the motor (in ticks/second). These blocks are available within the "DcMotor" --> "Extended" section. 

Now, the motor will apply as much power as needed (if it's possible) to get to and maintain that velocity. On this note, I recommend not trying to set above 75% of the maximum velocity (which you can find on the motor page).

## Run to Position

Something else we can do using the encoders, is telling the motor to spin until it gets to a specific tick count and stop on that tick. This uses complex math to graduallyi ncrease and decrease the speed so it doesn't really overshoot the target. The blocks for this are in the same section as velocity blocks.

## Motor Runmodes

**RUN_WITHOUT_ENCODERS**

This runmode means that using setPower() applies a percent of the available voltage to the motor. However, encoders are still being tracked if you want to use them for something else.

**RUN_WITH_ENCODERS**

This runmode means that using setPower() tries to reach a percent of the (predetermined) maximum RPM of the motor and it automatically adjusts the power as needed. Alternatively, this runmode also offers the use of setVelocity(), in ticks/second, and tries to apply the power needed to reach this velocity. This runmode also requires that you have the encoder cable plugged in.

**RUN_TO_POSITION**

In this runmode, you specify the "tick" that you want to reach and also the MAXIMUM power or MAXIMUM velocity, it will try to reach this target. As it gets closer, it slows down and tries to accurately reach this target. It also means that if nothing changes, it will try and maintain the current position even if there is external force being applied to it. This runmode requires the encoder cable to be plugged in.

**STOP_AND_RESET_ENCODERS**

This isn't technically a runmode, but it is used in the same way. It stops the motor and resets the current encoder to "0". While it is technically possible to reset the encoder without stopping, it is not recommended and if the motor is moving, may not work as you expect. 

## Practice

Now let's try and drive a specific distance. Calculate the number of encoder ticks (for your specific motors and wheels) that corresponds to 23 inches of driving. Then set that as the target position and see if it gets close.

It has a little trouble with the "slowing down" part of the movement, so the lower the maximum specifieed speed, the closer it will be to the theoretical distance. Driving slower also minimizes wheel slippage.

<details>
    <summary>Solutions</summary>
    <IMG src="../BlocksImages/Module 8/mecanumRunToPosition.png">
</details>