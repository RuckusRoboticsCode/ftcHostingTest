# Arrays & ArrayLists

### Arrays

These have a defined type and defined space. These things cannot be changed. That means they only hold one type of object or primitive and the length is constant. Use these if you know these things won't change. For example, an Array of drivetrain motors could be useful to iterate over.

**Iteration**

Basic:

```java
int[] myArray = {1, 2, 3, 4};

for(int i = 0; i < myArray.length; i++) {
    System.out.println(myArray[i]);
}
```

More convenient (if you're familiar with python this will be useful):

```java
int[] myArray = {1, 2, 3, 4};

for(int val: myArray) {
    System.out.println(val);
}
```

The first increments the index and reads through each value. Once compiled the second one is the exact same, but it makes it a little easier to read and write.

### Multi-Dimensional Arrays
Arrays can have many dimensions (up to 32!), but in most use cases 1 - 3 dimensions are sufficient. A 2 dimensional array is called a matrix: 

```java
int[][] myMatrix = new int[i][j];

```
We can think of such an array, as an array i, wherein each value of i is an array j. An important thing to note is that the length of every row does not have to be the same, thus, we can call upon the length of any row by using its index: 
```java
myMatrix.length = i; 
myMatrix[0].length = j; 

```
We can conceptualize this structure, as a Cartesian Plane, wherein, two data points are used to describe a position in space, 

### ArrayLists

ArrayLists are able to hold multiple datatypes and a variable number of arguments. However the type specification must be an object, not a primitive. It also requires you to import the class from the core Java. [Here](https://www.w3schools.com/java/java_arraylist.asp) is a useful resource for what they can do.

```java
import java.util.ArrayList;

ArrayList<Integer> myArrayList = new ArrayList<Integer>();

myArrayList.add(1);
myArrayList.add(5);
myArrayList.set(0, 9);
System.out.println(myArrayList.get(0));
myArrayList.remove(0);
```

or multiple datatypes

```java
import java.util.ArrayList;

ArrayList<Object> myArrayList = new ArrayList<Object>();

myArrayList.add(1);
myArrayList.add("five");
```

If you've worked with lists in python, this is practically the same.
