package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class task3 extends LinearOpMode {
    DcMotorEx FL;
    DcMotorEx FR;
    DcMotorEx BL;
    DcMotorEx BR;

    @Override
    public void runOpMode() throws InterruptedException {

        FL = hardwareMap.get(DcMotorEx.class, "motorFL");
        FR = hardwareMap.get(DcMotorEx.class, "motorFR");
        BL = hardwareMap.get(DcMotorEx.class, "motorBL");
        BR = hardwareMap.get(DcMotorEx.class, "motorBR");

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);

        setMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if(isStopRequested()) return;
        waitForStart();

        driveForward(23.0);

    }
    /**
     * Drive forward a certain distance
     * @param inches  the number of inches to drive forward
     */
    public void driveForward(double inches) {
        setMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = inchesToTicks(inches);

        // you have to set a target before you switch modes
        FL.setTargetPosition(ticks);
        FR.setTargetPosition(ticks);
        BL.setTargetPosition(ticks);
        BR.setTargetPosition(ticks);

        setMotorMode(DcMotor.RunMode.RUN_TO_POSITION);

        double power = 0.5;

        FL.setPower(power);
        FR.setPower(power);
        BL.setPower(power);
        BR.setPower(power);

        boolean motorsBusy = (FL.isBusy() || FR.isBusy() || BL.isBusy() || BR.isBusy());
        while(opModeIsActive() && !isStopRequested() && motorsBusy) {
            telemetry.addData("FL position ", FL.getCurrentPosition());
            telemetry.addData("FR position ", FR.getCurrentPosition());
            telemetry.addData("BL position ", BL.getCurrentPosition());
            telemetry.addData("BR position ", BR.getCurrentPosition());
            motorsBusy = (FL.isBusy() || FR.isBusy() || BL.isBusy() || BR.isBusy());
        }
        stopMotors();
    }

    /**
     * converts distance in inches to rotations in ticks
     * @param inches  the distance to travel
     * @return        the ticks to rotate to travel this distance
     */
    public int inchesToTicks(double inches) {
        double GEAR_RATIO = 1.0;
        double WHEEL_RADIUS = 1.77165;
        double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS * Math.PI * 2.0;
        double TICKS_PER_REVOLUTION_BASE = 288;
        double TICKS_PER_REVOLUTION_OUTPUT = TICKS_PER_REVOLUTION_BASE * GEAR_RATIO;
        double TICKS_PER_INCH = TICKS_PER_REVOLUTION_OUTPUT / WHEEL_CIRCUMFERENCE;

        return (int)(TICKS_PER_INCH * inches);
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
     * Stops all motors
     */
    public void stopMotors() {
        setMotorPower(0, 0, 0, 0);
    }

    /**
     * Set runmode of all motors
     * @param runMode the runmode to set all motors to
     */
    public void setMotorMode(DcMotor.RunMode runMode) {
        FL.setMode(runMode);
        FR.setMode(runMode);
        BL.setMode(runMode);
        BR.setMode(runMode);
    }
}
