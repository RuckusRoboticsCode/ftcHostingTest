# Coding Conventions

## Why?

Standards and consistency make code easier to read for other programmers and can make fixing or improving code later much easier.

## Casing

**camelCase**

When we have instances/objects of a class, we use camelCase. It is also common to name the instance after the class, unless this is confusing or unclear in your use case. camelCase is also used to name methods within a class.

`AprilTagDetector aprilTagDetector = new AprilTagDetector();`

```
public class TestClass {

    // setup is hidden
    ...

    public void doSomething() {
        return null;
    }

}
```

**snake_case**

Snake case is seen more in python (in my experience), so you don't need to remmeber this one.

**kebab-case**

Kebab case is seen in Javascript and more broadly in web development. Do not use it.

**PascalCase**

PascalCase is used to name classes, abstract classes, and interfaces. Do not use this case for instances of classes.

`public class TestClass {...}`

**MACRO_CASE**

Macro class is used for constants. In general, if the variable can be declared final, it should be macro cased. 

`private final double GEAR_RATIO = 0.5;`

**Train-Case**

This is the same as kebab-case. Don't use it.

[Here](https://google.github.io/styleguide/javaguide.html) are more conventions you should follow. Most of them will never come up.