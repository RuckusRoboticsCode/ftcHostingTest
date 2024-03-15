# Heading Interpolation

### What is it?

Heading interpolation in the context of motion planning refers to figuring out what heading the robot should be at for a given point along a path. This is beacuse the translational and rotational kinematics of holonomic (we mostly use mecanum) drivetrains are completely separate. This means we can control the movement and rotation independently.