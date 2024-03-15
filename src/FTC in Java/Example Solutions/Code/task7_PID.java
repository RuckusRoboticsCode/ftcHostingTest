package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class task7_PID extends LinearOpMode {

	private class PIDcontroller {

		ElapsedTime timer;
		double kp, ki, kd;
		double setPoint;
		double integralSum;
		double lastError;
		double tolerance;

		/**
		 * Constructor for PIDcontroller class
		 * @param kp  proportional gain value
		 * @param ki  integral gain value
		 * @param kd  derivative gain value
		 */
		public PIDcontroller(double kp, double ki, double kd) {
			this.kp = kp;
			this.ki = ki;
			this.kd = kd;
			this.timer = new ElapsedTime();
			this.setPoint = 0;
			this.integralSum = 0;
			this.lastError = 0;
			this.tolerance = 0;
		}

		/**
		 * Sets a new setpoint and resets any leftover data from previous set point
		 * @param setPoint  target to get to
		 */
		public void setSetPoint(double setPoint) {
			this.integralSum = 0;
			this.timer.reset();
			this.lastError = 0;
			this.setPoint = setPoint;
		}

		/**
		 * Set the tolerance for the controller, how far away is "okay"
		 * @param tolerance  how far away is reached
		 */
		public void setTolerance(double tolerance) {
			this.tolerance = tolerance;
		}

		/**
		 * calculate some return value based on the current position and the set point
		 * @param current  current state
		 * @return  whatever you tuned for. It could be power or velocity or something else
		 */
		public double calculate(double current) {
			double error = setPoint - current;

			integralSum += error;
			double derivative = (error - lastError) / timer.seconds();
			this.lastError = error;

			double p = kp * error;
			double i = ki * integralSum;
			double d = kd * derivative;

			timer.reset();
			return (p + i + d);
		}

		/**
		 * Returns whether the system has reached the setpoint
		 * @param current  current position
		 * @return  whether the system has reached the set point or within the tolerance
		 */
		public boolean atSetPoint(double current) {
			return (Math.abs(setPoint - current) < tolerance);
		}

	}

	DcMotorEx FL;
	DcMotorEx FR;
	DcMotorEx BL;
	DcMotorEx BR;

	IMU imu;

	public static double kp = 0, ki = 0, kd = 0;

	PIDcontroller controller;

	@Override
	public void runOpMode() throws InterruptedException {

		IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
				RevHubOrientationOnRobot.LogoFacingDirection.UP,
				RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
		));

		imu = hardwareMap.get(IMU.class, "imu");

		imu.initialize(parameters);

		FL = hardwareMap.get(DcMotorEx.class, "motorFL");
		FR = hardwareMap.get(DcMotorEx.class, "motorFR");
		BL = hardwareMap.get(DcMotorEx.class, "motorBL");
		BR = hardwareMap.get(DcMotorEx.class, "motorBR");

		FL.setDirection(DcMotorSimple.Direction.REVERSE);
		BL.setDirection(DcMotorSimple.Direction.REVERSE);
		FR.setDirection(DcMotorSimple.Direction.FORWARD);
		BR.setDirection(DcMotorSimple.Direction.FORWARD);

		controller = new PIDcontroller(kp, ki, kd);
        controller.setTolerance(3);

		if(isStopRequested()) return;
		waitForStart();

		imu.resetYaw();

		controller.setSetPoint(90);

		double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
		while(!controller.atSetPoint(heading)) {
			double power = controller.calculate(heading);

			FL.setDirection(power);
			BL.setDirection(power);

			FR.setPower(-power);
			BR.setPower(-power);

			heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
		}
	}
}
