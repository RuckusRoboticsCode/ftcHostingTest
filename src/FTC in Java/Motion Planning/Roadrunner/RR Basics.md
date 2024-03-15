# RoadRunner Basics

## What is Road Runner?

RoadRunner is the trajectory planning library that does the back behind the scenes to figure what power each motors needs at any given moment to follow a specified path very accurately. RoadRunner can either be implemented with dead wheels or drive encoders or both. 

Deadwheels slip less than mecanum wheels, so dead wheel RoadRunnr will be more accurate than drive encoder. Three dead wheels (using two parallel ones to track rotation) will be more accurate than two dead wheels (using IMU to track rotation), these options are covered in [Localization](../Localization.md). Drive encoders work pretty well, but they get less accurate the more you drive.

## Why do we use it?

If we want accurate movement, especially if it's long distances and needs to be at high speeds, then RoadRunner will be able to do it.