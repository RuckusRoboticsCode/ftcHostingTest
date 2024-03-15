package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class task6_advanced extends OpMode {

    DcMotorEx FL;
    DcMotorEx FR;
    DcMotorEx BL;
    DcMotorEx BR;

    IMU imu;
    YawPitchRollAngles orientation;

    @Override
    public void init() {
        FL = hardwareMap.get(DcMotorEx.class, "motorFL");
        FR = hardwareMap.get(DcMotorEx.class, "motorFR");
        BL = hardwareMap.get(DcMotorEx.class, "motorBL");
        BR = hardwareMap.get(DcMotorEx.class, "motorBR");

        imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        );

        imu.initialize(parameters);

        imu.resetYaw();

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        double power = 0.5;
        double correction = getCorrection();

        double leftPower = power + correction;
        double rightPower = power - correction;

        setMotorPower(leftPower, rightPower, leftPower, rightPower);
    }

    /**
     * Assigns each motors its specified power
     * @param powerFL  the power to assign to FL
     * @param powerFR  the power to assign to FR
     * @param powerBL  the power to assign to BL
     * @param powerBR  the power to assign to BR
     */
    public void setMotorPower(double powerFL, double powerFR, double powerBL, double powerBR) {
        FL.setPower(powerFL);
        FR.setPower(powerFR);
        BL.setPower(powerBL);
        BR.setPower(powerBR);
    }

    /**
     * calculate a correction based on the heading error
     * @return  the power to adjust by to minimize heading error
     */
    public double getCorrection() {
        double currentHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        double gain = 0.1;

        return gain * currentHeading;
    }
}
