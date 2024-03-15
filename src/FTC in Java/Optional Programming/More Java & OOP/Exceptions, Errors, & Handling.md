# Exceptions, Errors, & Handling

### Errors

Errors are general, exceptions are more errors and tell you what specifically went wrong.

**Syntax Error**

Your actualy code can't compile. Usually something is spelled wrong, braces are put incorrectly, or missing semicolons.

**Run Time Error**

This happens when the computer, when it's running (hence run time), is asked to do something it can't do. 

**Logical Error**

Not technically an error, just when you code doesn't work how you want it to. This can't be detected because the compiler doesn't know what the program "should" do.

### Built-in Java Exceptions

**ArithmeticException**

Something went wrong with arithmetic. This is often caused by dividing by zero.

**ArrayIndexOutOfBoundsException**

Pretty self explanatory, the index you are trying to access is outside the array.

**ClassNotFoundException**

Not gonna explain.

**FileNotFoundException**

Also not gonna explain.

**IOException**



**InterruptedException**



**NoSuchFieldException**

Not gonna explain.

**NoSuchMethodException**

Not gonna explain.

**NullPointerException**

You are trying to access a variable that is null (or undefined).

**NumberFormatException**

**RuntimeException**

**StringIndexOutOfBoundsException**

Trying to access the characters of a string by index, and you are trying to access something out of the string.

**IllegalArgumentException**

**IllegalStateException**

**Throwing Exceptions**

You can also "throw" exceptions, which just means telling the program there was an exception. You also have to specifiy the type of exception.

```
public class Main {
  static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    checkAge(15); // Set age to 15 (which is below 18...)
  }
}
```

Error:
Exception in thread "main" java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
        at Main.checkAge(Main.java:4)
        at Main.main(Main.java:12)

### Handling

**Assert**

Assert pretty much goes: check a condition, if it's false, throw an exception.

```
public int divide(int a, int b) {
    assert (b != 0) : "you can't divide by zero"

    return a / b;
}

```

If you try to input 0 as b, then you would get an `AssertionError: you can't divide by zero`

This is good practice to ensure that variables you are passing are valid so that it doesn't error out.

**Try Catch**

However, if you want to do something when there is an error rather than just crashing the entire program, it goes to the catch block. It's not a great idea to catch too many exceptions, but it's a useful tool.

```
try{
    divide(2, 0);
} catch(Exception e) {
    // if there is an exception, the code will go here
}
```

This catches ANY exceptions, however you can also have catch blocks for specific exceptions.

```
try{
    divide(2, 0);
} catch(FileNotFoundException e) {
    // the error in the try block won't be caught because it's a different type of exception
} finally {
    // code here runs regardless anything was caught or not
}
```