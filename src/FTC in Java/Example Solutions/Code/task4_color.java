package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class task4_color extends OpMode {

    Servo claw;
    ColorRangeSensor color;

    double clawOpen = 0.45;
    double clawClose = 0.6;

    @Override
    public void init() {
        claw = hardwareMap.get(Servo.class, "claw");
        color = hardwareMap.get(ColorRangeSensor.class, "color");
    }

    @Override
    public void loop() {
        double blue = color.blue();
        double alpha = color.alpha();
        double bluePercent = blue / alpha;

        if(bluePercent > 0.4 && color.getDistance(DistanceUnit.INCH) < 3) {
            claw.setPosition(clawClose);
        } else {
            claw.setPosition(clawOpen);
        }
    }
}
