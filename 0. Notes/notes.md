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

Here is what this might look like with our conditional statements with this example from the `NotesNot1.java` file:

```java
boolean isStudent = false;

if (!isStudent) {
    System.out.println("This person is not a student");
} else {
    System.out.println("This person is a student");
}
```

Can you predict which portion of the `if` block is going to happen? Let's work through it! The `if` statement is processing `!isStudent`, which when we know that `isStudent` is `false`, is really `!false`. The opposite of `false` is `true`, so `!isStudent` is equivalent to `true`. Since the boolean expression is `true`, the `if` statement executes its first portion of code, which prints out `"This person is not a student"`.

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

Here is what this might look like with our conditional statements with this example from the `NotesAnd1.java` file:

```java
boolean isStudent = true;
boolean hasMoney = false;

if (isStudent && hasMoney) {
    System.out.println("This person can just pay for college");
} else if (isStudent) {
    System.out.println("This person is going to college and will need a loan to pay for it");
} else if (hasMoney) {
    System.out.println("This person can pay for it, but is not going to college and doesn't need to pay for it");
} else {
    System.out.println("This person is not going to college, and doesn't need to worry about whether or not they can pay for it");
}
```

Can you predict which portion of the `if` block is going to happen? Let's work through it! The `if` statement is processing `isStudent && hasMoney`, which when we know that `isStudent` is `true` and `hasMoney` is `false`, is really `true && false`. `and` is only `true` when both pieces are `true`, so `true && false` is equivalent to `false`. Since the boolean expression is `false`, the `if` statement skips its first portion of code, and moves to process the next `else if`, which is asking `isStudent`. We know `isStudent` is `true`, so this boolean expression is `true` and we should execute the line of code inside of it. This will print out `"This person is going to college and will need a loan to pay for it"` and then skip the rest of the `if` block.

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

Here is what this might look like with our conditional statements with this example from the `NotesOr1.java` file:

```java
boolean friendsOnline = true;
boolean gameToPlay = false;

if (friendsOnline || gameToPlay) {
    System.out.print("I should hop on my computer ");
    if (friendsOnline && gameToPlay) {
        System.out.println("because I have my friends to play my game with");
    } else if (friendsOnline) {
        System.out.println("because my friends are online");
    } else {
        System.out.println("because I have a game I want to play");
    }
} else {
    System.out.println("This person is not going to college, and doesn't need to worry about whether or not they can pay for it");
}
```

Can you predict what the output will be? Let's work through it! The `if` statement is processing `friendsOnline || gameToPlay`, which when we know that `friendsOnline` is `true` and `gameToPlay` is `false`, is really `true || false`. `or` is only `false` when both pieces are `false`, so `true || false` is equivalent to `true`. This means we execute what is inside the `if` statement, which we notice is a `print` followed by a nested `if` block, to further select what we need to do. To determine our final line of printing, we need to process `friendsOnline && gameToPlay`, because the reason that the `or` statement from before is `true` has three options: both pieces were true (this is our `and`), or one of the two pieces was true. We know from earlier that `friendsOnline && gameToPlay` is equivalent to `true && false`, which turns out to `false`, so we move on to the `else if`. Since `friendsOnline` is `true`, the boolean expression is `true` and we use the print statement from the `else if` to complete our final statement: `"I should hop on my computer because my friends are online"`.

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

We can also process statements that use our relational operators from Unit 3 Section 1, since they can produce booleans for us to work with. Here is an example from the `NotesCompound1.java` file:

```java
int age = 25;
double cash = 100.0;

if (age >= 18 && cash >= 250.0) {
    System.out.println("You can rent a car!");
} else if (age >= 18) {
    System.out.println("You are old enough to rent a car, but cannot afford it.");
} else if (cash >= 250.0) {
    System.out.println("You can afford to rent a car, but are not old enough to rent one.");
} else {
    System.out.println("You are not old enough to rent a car and could not afford it anyways.");
}
```

Can you predict what the output will be? Let's work through it! The `if` statement is processing `age >= 18 && cash >= 250.0`, which is a large compound statement to process. Using our operator precedence, we know that the first thing we should tackle is `age >= 18` since it is the first relational operator when working from left-to-right. In this case, `age` is `25`, so the statement is equivalent to `25 >= 18`, which we know is `true`. Now our statement is `true && cash >= 250.0`, and so `cash >= 250.0` should come next since `>=` comes before `&&` in operator precedence. Since `cash` is `100.0`, we know that this is equivalent to `100.0 > 250.0`, which we can calculate is `false`. Our statement is now `true && false`, which calculates to be `false`, meaning we will skip the initial `if` and start checking the `else if`. The `else if` has the expression `age >= 18`, which we already calculated is `true`, so we will execute this section, printing out `"You are old enough to rent a car, but cannot afford it."` and skipping the rest.

---

## Short-Circuit Evaluation

Since programming languages do so much calculation, they sometimes approach calculations in a really smart way to save time and energy. In certain circumstances, we can know the results of `and` or `or` statements without finishing the calculation, which we refer to as **short-circuit evaluation**.

Let's start with `and`. We said earlier that `and` was really *picky*, since it only produced `true` when both sides are `true`. Another way to phrase this is `false` if either side is `false`. This means that when evaluating an `and` statement, if the first boolean is `false`, we know that the output will have to be `false`, regardless of the second value. In this situation, Java won't bother to check the other side of the statement and jump to the final answer of `false`.

We can do something similar with `or`, where we said it was really not *picky*, since it almost always produces `true`. `or` will be `true` if just one side is `true`. This means that when evaluating an `or` statement, if the first boolean is `true`, we know that the output will have to be `true`, regardless of the second value. In this situation, Java won't bother to check the other side of the statement and jump to the final answer of `true`.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
