package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class task5_teleOp extends OpMode {
    DcMotorEx FL;
    DcMotorEx FR;
    DcMotorEx BL;
    DcMotorEx BR;

    @Override
    public void init() {
        FL = hardwareMap.get(DcMotorEx.class, "motorFL");
        FR = hardwareMap.get(DcMotorEx.class, "motorFR");
        BL = hardwareMap.get(DcMotorEx.class, "motorBL");
        BR = hardwareMap.get(DcMotorEx.class, "motorBR");

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        boolean smoothing = false;
        double leftY = -gamepad1.left_stick_y;
        double leftX = gamepad1.left_stick_x;
        double rightX = gamepad1.right_stick_x;

        if(smoothing) {
            if(leftY < 0) {
                leftY = -Math.pow(leftY, 2);
            } else {
                leftY = Math.pow(leftY, 2);
            }
            if(leftX < 0) {
                leftX = -Math.pow(leftX, 2);
            } else {
                leftX = Math.pow(leftX, 2);
            }
            if(rightX < 0) {
                rightX = -Math.pow(rightX, 2);
            } else {
                rightX = Math.pow(rightX, 2);
            }
        }
        leftX *= 1.1;

        double denominator = Math.max(Math.abs(leftY) + Math.abs(rightX) + Math.abs(leftX), 1.0);
        double powerFL = (leftX + leftY + rightX) / denominator;
        double powerFR = (leftY - leftX - rightX) / denominator;
        double powerBL = (leftY - leftX + rightX) / denominator;
        double powerBR = (leftY + leftX - rightX) / denominator;

        setMotorPower(powerFL, powerFR, powerBL, powerBR);

        telemetry.addData("power FL ", powerFL);
        telemetry.addData("power FR ", powerFR);
        telemetry.addData("power BL ", powerBL);
        telemetry.addData("power BR ", powerBR);
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
}
