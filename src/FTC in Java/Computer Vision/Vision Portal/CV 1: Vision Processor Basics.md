# Vision Processor Basics

## Note

You no longer have to install EasyOpenCv for this. It comes as part of the FTC library/SDK.

## Framework

```java
import org.firstinspires.ftc.vision.VisionProcessor;

public class visionProcessor implements VisionProcessor {
    
    public void init(int width, int height, CameraCalibration calibration) {
        // init can do nothing, unless you need camera calibration for TFOD
    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        /*
        frame here is an OpenCv Mat object
        Everything in here can be OpenCv functions and methods
        */
        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {
        // only if you want to draw something like bounding boxes
    }
}
```

`public class visionProcessor implements VisionProcessor`

Here the included VisionProcessor is an interface rather than a class. This just means that a set of required methods have been specified, but there is no existing implementation. The required methods are `init`, `processFrame`, and `onDrawFrame`.

## Storing variables

The easiest way to store information would be to define a class variable (static variable) and assign that in the processFrame method. This also requires getters and setters.