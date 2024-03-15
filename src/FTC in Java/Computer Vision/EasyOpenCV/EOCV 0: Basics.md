# Easy Open CV: Basics

|Table of Contents|
|-|
|[Installation](#installation)|
|[Pipelines](#pipelines)|
|[Camera Setup](#camera--webcam-intiialization)|
|[Simulator](#eocv-sim)|

### Installation

https://github.com/OpenFTC/EasyOpenCV

### Pipelines

Pipelins are where the actual image is processed. It is written in it's own class and has certain methods that must exist. 

"All pipelines are required to extend OpenCvPipeline and implement the public Mat processFrame(Mat input) method. Let's take a look at an "empty" pipeline that doesn't actually do anything with the input image:"
```java
class EmptyPipeline extends OpenCvPipeline
{
    @Override
    public Mat processFrame(Mat input)
    {
        return input;
    }
}
```

You never actually call this function, but it runs it automatically in the background when you attach the pipeline to the camera.

### Camera / Webcam Intiialization

If you want to see what the camera is seeing, then you add this line at the top.
`int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());`

Then to create a camera object
```java
// With live preview
OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera2(OpenCvInternalCamera2.CameraDirection.BACK, cameraMonitorViewId);

// Without live preview
OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera2(OpenCvInternalCamera2.CameraDirection.BACK);
```

Or a webcam
```java
WebcamName webcamName = hardwareMap.get(WebcamName.class, "NAME_OF_CAMERA_IN_CONFIG_FILE")

// With live preview
OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);

// Without a live preview
OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName);
```

**Opening and Starting Camera**

You can either do this asynchronously or synchronously. The Github recommends doing it asynchronously, though I haven't had any issues with either of them.

Asnyc:
```java
camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
{
    @Override
    public void onOpened()
    {
        // Usually this is where you'll want to start streaming from the camera (see section 4)
    }
    @Override
    public void onError(int errorCode)
    {
       /*
       * This will be called if the camera could not be opened
       */
    }
});
```

Synchronous:
`camera.openCameraDevice();`

Next, you have to start getting input from the camera.
`camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);`

The last parameter specifies the orientation of the camera. Options include
1. UPRIGHT
2. SIDEWAYS_LEFT
3. SIDEWAYS_RIGHT

**Processing Images**

`camera.setPipeline(yourPipeline);`

This tells the camera to feed the frames into the pipeline.

### EOCV sim

https://deltacv.gitbook.io/eocv-sim/

This is a great way to test if you don't have access to the control hub or phone. It allows you to run pipelines off your comptuer and even supports a little bit of telemetry (though it only works like half the time in my experience). There are pretty thorough instructions on how to use install and use it in the link above.