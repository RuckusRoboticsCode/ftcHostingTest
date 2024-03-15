# Enums

### What Are They?

Enums are anonymous classes that you can't create objects of. They can have functions and variables, but they will all be public, static, and final. Because of this, enums are used for constants.

### Why Use Them?

Enums can be used to make the code more readable as well as decrease the chance of errors. For example, days of the week can be written as
```java
public void dayOfWeek(int day) {
    switch(day) {
        case 1:
            System.out.println("monday");
            break;
        case 2:
            System.out.println("tuesday");
            break;
        case 3:
        ...
    }
}
```

This would normally work, but what if someone inputs 15, which doesn't correspond to any day. Instead if we use enums, we remove the possibility for an errored input.

```java
enum days {
    MONDAY,
    TUESDAY,
    ...
}

public void dayOfWeek(days today) {
    switch(today) {
        case (MONDAY):
            System.out.println("monday");
            break;
        case (TUESDAY):
        ...
    }
}
```

Here there is no way for wrong information to get passed as long as it's the correct type.

### Variables in Enums

You can also have variables assigned to enums. For example

```java
enum linearSlideHeight{
    LOW(100),
    MEDIUM(200),
    HIGH(300);

    public final int ticks;

    linearSlideHeight(int ticks) {this.ticks = ticks;}

}

```