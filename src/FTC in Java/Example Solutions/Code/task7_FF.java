package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

public class task7_FF extends LinearOpMode {

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

	DcMotorEx slideLeft;
	DcMotorEx slideRight;

	IMU imu;

	public static double kp = 0, ki = 0, kd = 0, kf = 0;

	PIDcontroller controller;

	@Override
	public void runOpMode() throws InterruptedException {

		IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
				RevHubOrientationOnRobot.LogoFacingDirection.UP,
				RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
		));

		imu = hardwareMap.get(IMU.class, "imu");

		imu.initialize(parameters);

		slideLeft = hardwareMap.get(DcMotorEx.class, "slideL");
		slideRight = hardwareMap.get(DcMotorEx.class, "slideR");

		slideLeft.setDirection(DcMotorSimple.Direction.FORWARD);
		slideRight.setDirection(DcMotorSimple.Direction.FORWARD);

		controller = new PIDcontroller(kp, ki, kd);

		if(isStopRequested()) return;
		waitForStart();

		imu.resetYaw();

		controller.setSetPoint(500);

		int currentPosition = (slideLeft.getCurrentPosition() + slideRight.getCurrentPosition()) / 2;
		while(!controller.atSetPoint(currentPosition)) {
			double power = controller.calculate(currentPosition);

			// Here we are adding the tuned kf, which acts against gravity
			power += kf;

			slideLeft.setPower(power);
			slideRight.setPower(power);

			currentPosition = (slideLeft.getCurrentPosition() + slideRight.getCurrentPosition()) / 2;
		}
	}
}
