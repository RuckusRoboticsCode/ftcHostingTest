package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class task2 extends OpMode {

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
        double rightX = gamepad1.right_stick_x;

        /**
         * If smoothing is being used, square the inputs to reduce the small inputs
         * We have to check for negatives because squaring always return a positive value
         */
        if(smoothing) {
            if(leftY < 0) {
                leftY = -Math.pow(leftY, 2);
            } else {
                leftY = Math.pow(leftY, 2);
            }
            if(rightX < 0) {
                rightX = -Math.pow(rightX, 2);
            } else {
                rightX = Math.pow(rightX, 2);
            }
        }

        // denominator scales the power so it is within -1 and 1 at the same ratio
        double denominator = Math.max(Math.abs(leftY) + Math.abs(rightX), 1.0);
        double leftPower = (leftY + rightX) / denominator;
        double rightPower = (leftY - rightX) / denominator;

        setMotorPower(leftPower, rightPower, leftPower, rightPower);

        telemetry.addData("left power ", leftPower);
        telemetry.addData("right power ", rightPower);
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
