# Computer-Science-II-Homeworks
Homeworks from "Starting Out with Java" by Tony Gaddis

## Car Class

A `Car` class program that implements a simple class (`Car`).  Includes examples of the constructor, accessor, and mutator methods.

## Rectangle Class

Another Java program that implements a simple class (`Rectangle`).  Includes examples of the constructor, accessor, and mutator methods.

## Circle Class

A `Circle` class that has three overloaded static methods for calculating the areas of circles, rectangles, and cylinders.

## Lottery Class

A `Lottery` class that simulates a lottery.  The class has an array of five integers named `lotteryNumbers`. The constructor uses the `Random` class to generate a random number in the range of 0 through 9 for each element in the array.  The class also has a method that accepts an array five integers that represent a person’s lottery picks. A method compares the corresponding elements in the two arrays and return the number of digits that match. In addition, the class has a method that returns a copy of the `lotteryNumbers` array. The class asks the user to enter five numbers. The program displays the number of digits that match the randomly generated lottery numbers. If all of the digits match, a message proclaiming the user a grand prize winner is displayed.

## Month Class

The class has an int field named `monthNumber` that holds the number of the month. For example, January would be 1, February would be 2, and so forth. In addition, the following methods are provided:

• A no-arg constructor that sets the `monthNumber` field to 1.

• A constructor that accepts the number of the month as an argument. It sets the `monthNumber` field to the value passed as the argument. If a value less than 1 or greater than 12 is passed, the constructor sets `monthNumber` to 1.

• A constructor that accepts the name of the month, such as `“January”` or `“February”` as an argument. It sets the `monthNumber` field to the correct corresponding value.

• A `setMonthNumber` method that accepts an `int` argument, which is assigned to the `monthNumber` field. If a value less than 1 or greater than 12 is passed, the method sets `monthNumber` to 1.

• A `getMonthNumber` method that returns the value in the `monthNumber` field.

• A `getMonthName` method that returns the name of the month. For example, if the `monthNumber` field contains `1`, then this method should return `“January”`.

• A `toString` method that returns the same value as the `getMonthName` method.

• An `equals` method that accepts a `Month` object as an argument. If the argument object holds the same data as the calling object, this method returns `true`. Otherwise, it returns `false`.
