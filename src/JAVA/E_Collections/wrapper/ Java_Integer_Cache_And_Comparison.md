# Java_Integer_Cache_And_Comparison.md

# Java Integer Cache (`==` vs `equals()`)

## Introduction

Many beginners get confused by the following code:

```java
Integer a = 50;
Integer b = 50;

System.out.println(a == b);   // true

Integer x = 500;
Integer y = 500;

System.out.println(x == y);   // false
```

**Question:**
Why is the first comparison `true` and the second `false`?

Let's understand it step by step.

---

# Step 1: What does `==` compare?

For **primitive data types**, `==` compares **values**.

Example

```java
int a = 100;
int b = 100;

System.out.println(a == b);
```

Output

```
true
```

Because

```
100 == 100
```

---

For **objects**, `==` compares **memory addresses (references)**.

Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

Output

```
false
```

Even though both contain `"Java"`, they are different objects.

---

# Step 2: Integer Uses Auto Boxing

When you write

```java
Integer number = 50;
```

The compiler automatically changes it to

```java
Integer number = Integer.valueOf(50);
```

This process is called **Auto Boxing**.

---

# Step 3: Integer Cache

Java keeps some Integer objects ready to improve performance.

The cache range is

```
-128 to 127
```

These objects are created once and reused.

---

## Example 1

```java
Integer a = 50;
Integer b = 50;
```

Compiler converts it to

```java
Integer a = Integer.valueOf(50);
Integer b = Integer.valueOf(50);
```

Since **50 is inside the cache**, Java returns the **same object**.

Memory

```
      Integer Cache

      +-----------+
      |    50     |
      +-----------+
         ^     ^
         |     |
         a     b
```

Now compare

```java
System.out.println(a == b);
```

Both variables point to the same object.

Output

```
true
```

---

# Step 4: Value Outside the Cache

```java
Integer a = 500;
Integer b = 500;
```

Compiler changes it to

```java
Integer a = Integer.valueOf(500);
Integer b = Integer.valueOf(500);
```

Since **500 is outside the cache**, Java creates **two different objects**.

Memory

```
Heap Memory

+-----------+     +-----------+
|    500    |     |    500    |
+-----------+     +-----------+
      ^                 ^
      |                 |
      a                 b
```

Now compare

```java
System.out.println(a == b);
```

Output

```
false
```

Because both variables point to different objects.

---

# What Does `equals()` Do?

`equals()` compares the **values**, not the memory addresses.

Example

```java
Integer a = 500;
Integer b = 500;

System.out.println(a.equals(b));
```

Output

```
true
```

Because

```
500 == 500
```

The values are equal.

---

# Complete Example

```java
public class IntegerCacheExample {

    public static void main(String[] args) {

        Integer num1 = 50;
        Integer num2 = 50;

        System.out.println(num1 == num2);        // true
        System.out.println(num1.equals(num2));   // true

        Integer n1 = 500;
        Integer n2 = 500;

        System.out.println(n1 == n2);            // false
        System.out.println(n1.equals(n2));       // true
    }
}
```

Output

```
true
true
false
true
```

---

# Integer Cache Range

Java caches Integer objects from

```
-128 to 127
```

Examples

```java
Integer a = 127;
Integer b = 127;

System.out.println(a == b);
```

Output

```
true
```

---

```java
Integer a = 128;
Integer b = 128;

System.out.println(a == b);
```

Output

```
false
```

---

# Why Does Java Use Integer Cache?

Creating objects is expensive.

Instead of creating a new object every time for commonly used numbers, Java reuses existing Integer objects.

Benefits

- Better performance
- Less memory usage
- Faster execution

---

# `==` vs `equals()`

| `==` | `equals()` |
|------|------------|
| Compares memory addresses | Compares values |
| Used for reference comparison | Used for value comparison |
| Can return `false` even if values are the same | Returns `true` when values are equal |

Example

```java
Integer a = 500;
Integer b = 500;

System.out.println(a == b);        // false
System.out.println(a.equals(b));   // true
```

---

# Interview Rule

✔ Use `equals()` when comparing Wrapper class values.

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a.equals(b));
```

Output

```
true
```

Avoid using

```java
a == b
```

unless you want to check whether both variables refer to the **same object**.

---

# Quick Revision

```
Primitive
=========
==  → compares values

Objects
=======
==  → compares references (memory)

equals()
========
Compares values
```

---

# Memory Trick

```
Integer a = 50;
Integer b = 50;

50 is inside cache
↓

Same Object

↓

a == b

↓

true
```

```
Integer a = 500;
Integer b = 500;

500 is outside cache
↓

Two Different Objects

↓

a == b

↓

false
```

---

# Key Points

- `Integer` is a Wrapper class.
- `Integer.valueOf()` uses a cache from **-128 to 127**.
- Numbers inside the cache reuse the same object.
- Numbers outside the cache create new objects.
- `==` compares references for objects.
- `equals()` compares values.
- For Wrapper classes like `Integer`, always prefer `equals()` when comparing values.