package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class task5_proficient extends LinearOpMode {
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

        if(isStopRequested()) return;
        waitForStart();

        double driveTime = 2.0;

        driveForward(driveTime);
        strafeLeft(driveTime);
        driveBackward(driveTime);
        strafeRight(driveTime);
    }

    /**
     * drive forward for a specified time
     * @param seconds  the time to drive forward
     */
    public void driveForward(double seconds) {
        double power = 1.0;
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() < seconds && opModeIsActive() && !isStopRequested()) {
            setMotorPower(power, power, power, power);
        }
        stopMotors();
    }

    /**
     * strafe left for a specific time
     * @param seconds  the time to strafe left
     */
    public void strafeLeft(double seconds) {
        double power = 1.0;
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() < seconds && opModeIsActive() && !isStopRequested()) {
            setMotorPower(-power, power, power, -power);
        }
        stopMotors();
    }

    /**
     * drive backward for a specific time
     * @param seconds  the time to drive backward
     */
    public void driveBackward(double seconds) {
        double power = 1.0;
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() < seconds && opModeIsActive() && !isStopRequested()) {
            setMotorPower(-power, -power, -power, -power);
        }
        stopMotors();
    }

    /**
     * strafe right for a specific time
     * @param seconds  the number of seconds to strafe right
     */
    public void strafeRight(double seconds) {
        double power = 1.0;
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() < seconds && opModeIsActive() && !isStopRequested()) {
            setMotorPower(power, -power, -power, power);
        }
        stopMotors();
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
}
