package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class task1 extends LinearOpMode {

    // declare motors
    DcMotorEx FL;
    DcMotorEx FR;
    DcMotorEx BL;
    DcMotorEx BR;

    @Override
    public void runOpMode() throws InterruptedException {

        // assign motors
        FL = hardwareMap.get(DcMotorEx.class, "motorFL");
        FR = hardwareMap.get(DcMotorEx.class, "motorFR");
        BL = hardwareMap.get(DcMotorEx.class, "motorBL");
        BR = hardwareMap.get(DcMotorEx.class, "motorBR");

        // set directions, while setting FORWARD isn't necessary, it's good practice
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);

        if(isStopRequested()) return;
        waitForStart();

        double driveTime = 2.0;

        // drive forward and turn 90 degrees, repeated 4 times.
        for(int i = 0; i < 4; i++) {
            driveForward(driveTime);
            turn90();
        }
    }

    /**
     * Drive forward for the specified amount of time at full power then stop
     * @param seconds  the number of seconds to drive forward
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
     * Turn counter clock-wise close to 90 degrees
     */
    public void turn90() {
        double turnTime = 1.5;
        double power = 0.5;
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() < turnTime && opModeIsActive() && !isStopRequested()) {
            setMotorPower(-power, power, -power, power);
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
     * Stop all motors
     */
    public void stopMotors() {
        setMotorPower(0, 0, 0, 0);
    }
}
