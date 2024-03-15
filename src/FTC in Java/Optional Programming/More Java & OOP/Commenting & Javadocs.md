# Commenting & Javadocs

### Commenting

Don't comment what every line does. If it is something complex, or hard to read, or it was hard to write, then it's probably worth a comment.

**Single Line Comments**

```
// this is a comment
```

**Multi-Line Comments**

```
/*
Everything in here is commented.
I can even use multiple lines.
*/
```

### Javadocs

These are comments we put before constructors and functions to clarify what they do, what the inputs are, and any expected returns. Most code editors will have these built in if you type `/**` then enter. Inputs are annotated as `@params` and returns are annotated as `@return`. Every newline is started with an asterick, which is also usually done automatically.

```
/**
* Adds two integer inputs
* @params a  the first integer to add
* @params b  the second integer to add
* @return  the sum of the two inputed integers
*/
public void addNumbers(int a, int b) {
    return (a + b);
}

```

This is just a nice way to make code more readable for other people. Ideally, someone who has never read over you function can understand how to use it without ever reading what's inside the function.