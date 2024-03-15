# Motion Profiling and Feedback Controllers

### What is motion profiling?

Motion Profiling is a type of feedforward control that creates time-dependent plots of velocity and acceleration (based on provided MAX velocity and MAX acceleration). This smooths out movement and ensures the robot can actually follow the desired velocity and acceleration.

You can model a desired voltage to achieve a certain velocity and acceleration linearly, so you have the gains kStatic, kV, and kA. 

kStatic helps overcome static friction, kV pushes the output power to achieve the desired velocity, and kA pushes the output power to achieve the desired acceleration.

### Feedback

Now that the robot goes the right velocity and acceleration, the only problem is making sure it is in the right place. This is where position feedback controller comes into play. You can use a PID controller for translational error and another PID controller for heading error.

Once you put the feedforward and feedback together, now the robot goes the right speed, right acceleration, and is at the right place. This is the basis of path following.