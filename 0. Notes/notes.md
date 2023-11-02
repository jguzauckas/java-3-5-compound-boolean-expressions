# Compound Boolean Expressions

We've used the last sections to expand our opportunities to have multiple branching paths within our code, but we haven't really discussed how to make more complex decisions, just more complex answers.

---

## Nested `if` Statements

When we want code to occur based on multiple boolean conditions, we can have multiple `if` statements, nested inside of each other, so you can only get to the center when you pass all the checks. This is referred to as **nested `if` statements**. Here is a brief example from the `NotesNestedIf1.java` file:

```java
int x = 10;

if (x > 5) {
    if (x < 15) {
        System.out.println("x is greater than 5 and less than 15");
    } else {
        System.out.println("x is greater than 5, but not less than 15");
    }
} else {
    System.out.println("x is not greater than 5, which means it must be less than 15");
}
```

The nested `if` statements above essentially decide whether the number `x` falls between 5 and 15, above the interval, or below the interval. Try to modify the value of `x` in the `NotesNestedIf1.java` file to get each of the three statements to print out!

---

## Logical Operators

**Logical operators** are operations that are performed on boolean values and produce boolean values. There are three of them: **`not`**, **`and`**, and **`or`**.

### `not`

`not` is commonly referred to as the negation operator, as all it does is reverse a boolean value. Since booleans only have two values: `true` and `false`, negation is pretty simple, since it just switches from the current value to the only other possible value. Java uses the exclamation point `!` as the negation operator, and is meant to come before the boolean value that is to be negated.

To better understand logical operators, we have a table known as a **truth table**, which helps to display all the possible options of an operator like `not`. Columns labeled with letters like `p`, `q`, and `r` are just a boolean values, and each row can have a boolean value assigned to that "variable". Other columns will have operations like `not` and will use the values of the "variables" in that row to calculate an answer. Here is a truth table for `not`:

| `p` | `!p` |
|:---:|:---:|
| `true` | `false` |
| `false` | `true` |

We can see that the boolean value in the left column, representing the "original" boolean value known as `p`, is flipped to the opposite in the right column, which represents `!p` or `not p`. We can see this happen in a couple of sentences in English. These sentences are about Mr. G:

- "I am a teacher" -> For Mr. G, this is a `true` statement.
- "I am not a teacher" -> This is the negation of the previous statement, and for Mr. G, it is `false`.

It works for sentences that were wrong to begin with as well though:

- "I hate math" -> For Mr. G, this is a `false` statement.
- "I do not hate math" -> This is the negation of the previous statement, and for Mr. G, it is `true`.

### `and`

`and` is an operator that needs both inputs to be `true` to produce a `true` value, and otherwise will always be `false`. `and` is represented by a double ampersand `&&`, with a boolean value written to the left and to the right of it to act on (just like you write numbers on each side of `+`).

Since `and` uses two boolean values, here is a truth table with two inputs, `p` and `q`, and their combination `p && q` or `p and q`:

| `p` | `q` | `p && q` |
|:---:|:---:|:---:|
| `true` | `true` | `true` |
| `true` | `false` | `false` |
| `false` | `true` | `false` |
| `false` | `false` | `false` |

One important feature of truth tables, is that we try to represent every possible combination of boolean values to help best understand our output. In the first truth table, there had been 2 rows, since one boolean value only has 2 options. In this table, there are 4 rows, since when you have combinations of one boolean value with 2 options and another boolean value with 2 options, you have `2 * 2 = 4` total options.

We can see from this table, that `and` is a very *picky* operator, as it only produces `true` when both inputs are true, and for the other 3/4 of options, prints `false`.

Just like `not`, we can see how this works with sentences in English. In order to do this, we need to establish some statements that are `true` and `false` to try and combine and see if they make sense:

- "I am a teacher" -> This is `true` for Mr. G.
- "I am 25" -> This is `true` for Mr. G.
- "I hate math" -> This is `false` for Mr. G.
- "I hate video games" -> This is `false` for Mr. G.

Now let's try some combinations:

- "I am a teacher and I am 25" -> This is equivalent to `true && true`, and is `true` for Mr. G.
- "I am a teacher and I hate math" -> This is equivalent to `true && false`, and it makes sense in English that the second half breaks this, making it `false` for Mr. G.
- "I hate video games and I am 25" -> This is equivalent to `false && true`, and it makes sense in English that the first half breaks this, making it `false` for Mr. G.
- "I hate math and I hate video games" -> This is equivalent to `false && false`, and it makes sense in English that if nothing is true, then the whole sentence must be `false` for Mr. G.

### `or`

`or` is an operator that needs at least one input to be `true` to produce a `true` value, and will produce `false` when both inputs are `false`. `or` is represented by a double pipe `||`, with a boolean value written to the left and to the right of it to act on (just like you write numbers on each side of `+`).

Since `or` uses two boolean values, here is a truth table with two inputs, `p` and `q`, and their combination `p || q` or `p or q`:

| `p` | `q` | `p \|\| q` |
|:---:|:---:|:---:|
| `true` | `true` | `true` |
| `true` | `false` | `true` |
| `false` | `true` | `true` |
| `false` | `false` | `false` |

We can see from this table, that `or` is a much less *picky* operator than `and`, as it produces `true` when either input is true, and only prints `false` in the event that both sides are `false`.

Just like `not` and `and`, we can see how this works with sentences in English. In order to do this, we need to establish some statements that are `true` and `false` to try and combine and see if they make sense:

- "I am a teacher" -> This is `true` for Mr. G.
- "I am 25" -> This is `true` for Mr. G.
- "I hate math" -> This is `false` for Mr. G.
- "I hate video games" -> This is `false` for Mr. G.

Now let's try some combinations:

- "I am a teacher or I am 25" -> This is equivalent to `true || true`, and is `true` for Mr. G.
- "I am a teacher or I hate math" -> This is equivalent to `true || false`, and it makes sense in English that the first half makes this work, making it `true` for Mr. G.
- "I hate video games or I am 25" -> This is equivalent to `false || true`, and it makes sense in English that the second half makes this work, making it `true` for Mr. G.
- "I hate math or I hate video games" -> This is equivalent to `false || false`, and it makes sense in English that if nothing is true, then the whole sentence must be `false` for Mr. G.

---

## Compound Boolean Expressions

**Compound boolean expressions** combine multiple operations that produce a single boolean value. These can be processed in steps by use of operator precedence. To do this, here is an updated operator precedence list that includes all the operators we've covered so far in this course. Remember that the steps go from top to bottom (top done first) and anything on the same step can be processed in appearance order from left to right:

1. Grouping `()`, Object Access `.`
2. Type Casting `(int)` `(double)`, Object Creation `new`
3. Not `!`
4. Multiplication `*`, Division `/`, Remainder `%`
5. Addition `+`, Subtraction `-`, String Concatenation `+`
6. Less Than `<`, Less Than or Equal To `<=`, Greater Than `>`, Greater Than or Equal To `>=`
7. Equals `==`, Not Equals `!=`
8. And `&&`
9. Or `||`
10. Assignment `=` `+=` `-=` `*=` `/=` `%=`

Even though they operate on different types of information, we put all operators on a single chart because problems can link many pieces together and use things like relational operators to switch which types we are working with.

Here is an example of a compound boolean expression: `(p && q) || !p`

Given values for `p` and `q`, we could calculate this. Let's say `p` is `true` and `q` is `false`. Then, we can plug into our expression and see that it is now `(true && false) || !true`. Operator precedence tells us that grouping should come first, so we first do `true && false` to get `false`, now our expression looks like this: `false || !true`. Next comes the `not` operation, and `!true` is `false`, so now our expression is `false || false`, which we know is `false`.

Sometimes when given an expression like this, we'll use a truth table to determine what the possible outcomes are. For example, maybe the question is what values for `p` and `q` could cause the expression `(p && q) || !p` to be true? To do this, we do the steps we did above as columns in the truth table to evaluate our answer:

| `p` | `q` | `p && q` | `!p` | `(p && q) \|\| !p` |
|:---:|:---:|:---:|:---:|:---:|
| `true` | `true` | `true` | `false` | `true` |
| `true` | `false` | `false` | `false` | `false` |
| `false` | `true` | `false` | `true` | `true` |
| `false` | `false` | `false` | `true` | `true` |

Once we do this, we can see that our example above of `p` as `true` and `q` as `false` was actually the outlier in this situation. Any other combination of values for `p` and `q` produces `true` in this expression!


# `else if` Statements

We often refer to an `if` statement as a one-way selector, as it has only one direction to go: when the **boolean expression** is `true`. In the Unit 3 Section 3, we introduced `if-else` statements, which function as two-way selectors, as it has two directions to go: when the **boolean expression** is `true`, or when it is `false`. In real life, decision-making is much more complex than just two options, and so we would wonder if we can combine some tools we have to overcome the limitation of booleans only having two values.

---

## `if-else if` Statements

Unlike `if` and `if-else` statements, an **`else if` statement** doesn't exist on it's own, it is instead incorporated into one of the other two tools in order to make them more powerful. The most typical application of this new tool would be creating an `if-else if` statement. This is something that might make sense to first work through a real-life decision in English and then translate it into a program. Here is our situation:

```
I am going to apply for a loan to buy a house. One of the things the bank takes into consideration is my age.
The bank has a process they follow to decide what interest rate I can get:
1. If I am older than 30, I can get a 3% interest rate on my loan.
2. If I am not older than 30, but I am older than 20, I can get a 4% interest rate on my loan. (Higher interest rate is worse).

So I tell the bank that I am 25.
They go through their process:
1. Am I older than 30? I am not. Continue on.
2. Am I older than 20? I am. I can have the 4% interest rate.

On the other hand, my friend Sam is 33 and goes to the bank for a loan as well.
They go through their process:
1. Is Sam older than 30? Yes he is. He can have the 3% interest rate.
The bank doesn't bother checking if Sam is older than 20 because they have already found his interest rate.
```

This scenario is an example of `if-else if` statement in action. The first ask a question, "are you older than 30". If you are, you get the 3% interest rate, but if you aren't, instead of just making a blanket statement that you can have the 4% interest rate, they ask a follow-up question, "are you older than 20". If you are, then you get the 4% interest rate and we are done, but if you aren't their process just ends, since I guess they wouldn't give a loan for a house to a person under 20.

Essentially, we've done two `if` statements, `if age is over 30` and `if age is over 20`, but the second `if` statement will only happen when needed, which is why it is an `if-else if` statement, as opposed to just an `if-if` statement. Let's turn this scenario into a Java program, which can be seen in this example from the `NotesIfElseIf1.java` file:

```java
int age = 25; // Mr. G's age
if (age > 30) {
    System.out.println("You can have the 4% interest rate.");
} else if (age > 20) {
    System.out.println("You can have the 3% interest rate.");
}
```

When run, we expect this to assign us the 4% interest rate, let's see if it works:

```
You can have the 4% interest rate.
```

It does! Here is an example from the `NotesIfElseIf2.java` file where the only change is that we put in Sam's age of 33:

```java
int age = 33; // Mr. G's friend Sam's age
if (age > 30) {
    System.out.println("You can have the 4% interest rate.");
} else if (age > 20) {
    System.out.println("You can have the 3% interest rate.");
}
```

When run, we expect this to assign Sam the 3% interest rate, let's see if it works:

```
You can have the 3% interest rate.
```

Even though we are using the keyword `else`, which in Unit 3 Section 3 meant that we will always have something to do, it is possible here to not do either of the options presented. Let's say one of you all tried to get a loan from this bank as a high school student, here is the slightly modified example from the `NotesIfElseIf3.java` file to show what might happen:

```java
int age = 16; // Sample student age
if (age > 30) {
    System.out.println("You can have the 4% interest rate.");
} else if (age > 20) {
    System.out.println("You can have the 3% interest rate.");
}
```

We know that in the real-life example, this would have just not given you an interest, but the program we put together works a little bit differently. We'd expect here for the program to just not offer us an interest rate:

```

```

The output is just blank, nothing is printed! This makes sense based on the code, but doesn't make any sense in real life, as the bank would at least let us know they can't offer us an iterest rate! There must be a piece we are missing that could enable us to handle a final "other" option.

---

## `if-else if-else` Statements

Continuing with the above example, it would be reasonable for the bank to add a third step to their process, as follows:

```
1. If I am older than 30, I can get a 3% interest rate on my loan.
2. If I am not older than 30, but I am older than 20, I can get a 4% interest rate on my loan. (Higher interest rate is worse).
3. If I am not older than 20, then I cannot get a loan.
```

Fortunately in code, this is just as simple as adding another piece to our existing `if-else if` statement, an `else` statement, and we can continue on. Here is an example from the `NotesIfElseIfElse1.java` file:

```java
int age = 16; // Sample student age
if (age > 30) {
    System.out.println("You can have the 4% interest rate.");
} else if (age > 20) {
    System.out.println("You can have the 3% interest rate.");
} else {
    System.out.println("You cannot have a loan.");
}
```

Adding this `else` statement shouldn't effect our working examples, because `else` would only happen when everything else fails, which was only in the case of the student example. Now, we expect to hear from the bank to let us know what the status of our loan is if they don't offer us an interest rate:

```
You cannot have a loan.
```

Excellent! Well, not excellent that you can't get a loan, but excellent that it works! Regardless of how many pieces there are to your `if` statement, you can always end it with a singular `else` to offer a final alternative. "Regardless of how many pieces", does this mean we can have more options?

---

## `if-else if-...-else if-else` Statements

That's right, we can have as many options as we want, all we need to do is add more `else if` statements to our chain! Let's liven up our real-life scenario by making it more realistic, with more interest rate breakpoints:

```
1. If I am older than 60, I can get a 1% interest rate on my loan.
2. If I am not older than 60, but I am older than 50, I can get a 1.5% interest rate on my loan. (Higher interest rate is worse).
3. If I am not older than 50, but I am older than 40, I can get a 2% interest rate on my loan. (Higher interest rate is worse).
4. If I am not older than 40, but I am older than 30, I can get a 2.5% interest rate on my loan. (Higher interest rate is worse).
5. If I am not older than 30, but I am older than 20, I can get a 3% interest rate on my loan. 
6. If I am not older than 20, then I cannot get a loan.
```

The bank's process is 6 steps now! Let's turn this into code to make it easier for the people that work there. Here is an example from the `NotesIfElseIfElseIfElse1.java` file:

```java
int age = 53; // Mr. G's father's age
double interestRate = -1.0;
if (age > 60) {
    interestRate = 1.0;
} else if (age > 50) {
    interestRate = 1.5;
} else if (age > 40) {
    interestRate = 2.0;
} else if (age > 30) {
    interestRate = 2.5;
} else if (age > 20) {
    interestRate = 3.0;
} else {
    System.out.println("You cannot have a loan.");
}

if (interestRate > 0) {
    System.out.println("You can have the " + interestRate + "% interest rate.");
}
```

This code was rewritten more than the previous examples to make it easier to read and work with. Now there is an `interestRate` variable that changes throughout the `if` statement and then is printed with later. At the end, we need to check that `interestRate` has been changed before we tell them what their interest rate is.

We plugged my dad's age into here to see if it works right. We expect this should give him an interest rate of `1.5%` if we set this up right:

```
You can have the 1.5% interest rate.
```

---

## Wrap-Up

With the pieces of `if`, `else if` and `else`, we can accomplish almost anything! Combinations of these pieces can often be referred to as an `if` block. These are the rules for an `if` block:

1. Only 1 `if` statement.
2. 0 to many `else if` statements.
3. 0 or 1 `else` statements.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
