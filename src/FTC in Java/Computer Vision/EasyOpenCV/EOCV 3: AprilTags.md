# AprilTags

### What are they

AprilTags are like a QR code that someone has trained an AI to recognize from lots of angles and lots of distances.

### When to use

When the challenge has some sort of custom identification AprilTags are a great tool because they work in good and bad lighting conditions and from different angles.

### How to implement

You can find all the different tags [here](https://www.dotproduct3d.com/uploads/8/5/1/1/85115558/apriltags1-20.pdf).

This is the pipeline to detect AprilTags, it calls external APIs to work because the actual detection software is written in C.

**pipeline**

```java
package org.firstinspires.ftc.teamcode.vision;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.apriltag.AprilTagDetectorJNI;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;

public class AprilTagDetectionPipeline extends OpenCvPipeline
{
    private long nativeApriltagPtr;
    private Mat grey = new Mat();
    private ArrayList<AprilTagDetection> detections = new ArrayList<>();

    private ArrayList<AprilTagDetection> detectionsUpdate = new ArrayList<>();
    private final Object detectionsUpdateSync = new Object();

    double fx;
    double fy;
    double cx;
    double cy;

    // UNITS ARE METERS
    double tagsize;
    double tagsizeX;
    double tagsizeY;

    private float decimation;
    private boolean needToSetDecimation;
    private final Object decimationSync = new Object();

    public AprilTagDetectionPipeline()
    {
        this.tagsize = 0.166;
        this.tagsizeX = tagsize;
        this.tagsizeY = tagsize;
        this.fx = 578.272;
        this.fy = 578.272;
        this.cx = 402.145;
        this.cy = 221.506;

        // Allocate a native context object. See the corresponding deletion in the finalizer
        nativeApriltagPtr = AprilTagDetectorJNI.createApriltagDetector(AprilTagDetectorJNI.TagFamily.TAG_36h11.string, 3, 3);
    }

    @Override
    public Mat processFrame(Mat input)
    {
        // Convert to greyscale
        Imgproc.cvtColor(input, grey, Imgproc.COLOR_RGBA2GRAY);

        synchronized (decimationSync)
        {
            if(needToSetDecimation)
            {
                AprilTagDetectorJNI.setApriltagDetectorDecimation(nativeApriltagPtr, decimation);
                needToSetDecimation = false;
            }
        }

        // Run AprilTag
        detections = AprilTagDetectorJNI.runAprilTagDetectorSimple(nativeApriltagPtr, grey, tagsize, fx, fy, cx, cy);

        synchronized (detectionsUpdateSync)
        {
            detectionsUpdate = detections;
        }

        return input;
    }

    public void setDecimation(float decimation)
    {
        synchronized (decimationSync)
        {
            this.decimation = decimation;
            needToSetDecimation = true;
        }
    }

    public ArrayList<AprilTagDetection> getLatestDetections()
    {
        return detections;
    }

    public ArrayList<AprilTagDetection> getDetectionsUpdate()
    {
        synchronized (detectionsUpdateSync)
        {
            ArrayList<AprilTagDetection> ret = detectionsUpdate;
            detectionsUpdate = null;
            return ret;
        }
    }
}
```

**using it**

```java
public class aprilTagTest extends LinearOpMode {

    private OpenCvCamera camera = null;

    @Override
    public void runOpMode() throws InterruptedException {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);
        AprilTagDetectionPipeline aprilTagDetectionPipeline = new AprilTagDetectionPipeline();
        camera.setPipeline(aprilTagDetectionPipeline);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
            }
            public void onError(int errorCode) {}});

        while(opModeInInit() || opModeIsActive() && !isStopRequested()) {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();
            if(currentDetections.size() != 0) {
                for (AprilTagDetection tag : currentDetections) {
                    telemetry.addData("tag ", tag.id);
                    break;
                }
            } else {
                telemetry.addData("tag ", "Not Found");
            }
            telemetry.update();
            sleep(20);
        }

    }

}
```

If the game has limited options for what it will be reading, I recommend writing it into an enum to make it clearer. For example in PowerPlay, I used 

```java
enum detectionLocation {
    LEFT(1),
    MIDDLE(2),
    RIGHT(3);

    public final int tagID;

    detectionLocation(int tagID) {this.tagID = tagID;}
}
```