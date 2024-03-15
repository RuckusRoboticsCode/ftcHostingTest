# Finite State Machines

### What are they?

Finite State Machines (FSMs) refer to a loop that runs continutally with pre-defined STATES. Within each state, there are instructions and conditions to move to the next state. This is a great time to use enums because the states are constant and the values are predefined.

### Uses

**Simultaneous actions**

One way to use a FSM is to control multiple actions without blocking. For example, adding automation in teleOp, but still allowing the driver to have control as well as cancelling the automation mid-action.

### Example

```java
public class FSM extends OpMode {
    enum state{
        IDLE,
        START,
        LIFT_SLIDES,
        OPEN_CLAW,
        CLOSE_CLAW,
        LOWER_SLIDES
    }

    state robotState;
    int targetPosition = 0;
    ElapsedTime time;

    public void init() {
        robotState = state.START;
        time = new ElapsedTime();
        // setup
    }

    public void loop() {
        if(gamepad1.a && !lastGamepad1.a) {
            if(robotState == state.IDLE) {
                robotState = state.START;
            } else {
                robotState = state.IDLE;
            }
        }
        switch(robotState) {
            case IDLE:
                targetPosition = slides.currentPosition;
                break;
            case START:
                robotState = state.LIFT_SLIDES;
                break;
            case LIFT_SLIDES:
                targetPosition = 100;
                if(slides.atPosition()){
                    robotState = state.OPEN_CLAW;
                    time.reset();
                }
                break;
            case OPEN_CLAW:
                // open claw
                if(time.milliseconds > 150) {
                    robotState = state.CLOSE_CLAW;
                    time.reset()
                }
                break;
            case CLOSE_CLAW:
                // close claw
                if(time.milliseconds > 150) {
                    robotState = state.LOWER_SLIDES;
                }
                break;
            case LOWER_SLIDES:
                targetPosiiton = 0;
                if(slides.atPosition()) {
                    robotState = state.idle;
                }
                break;
        }
        // teleop driving stuff here
        slides.update(targetPosition);
    }
}

```


