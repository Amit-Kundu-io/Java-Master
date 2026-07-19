
# Java Wrapper Class: Boxing & Unboxing

## What is a Wrapper Class?

A **Wrapper Class** is a class that wraps (stores) a primitive data type as an object.

| Primitive | Wrapper Class |
|-----------|---------------|
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| char | Character |
| boolean | Boolean |

### Why Wrapper Classes?

Wrapper classes are required because many Java APIs and Collections (like `ArrayList`) work with **objects**, not primitive data types.

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
```

---

# Boxing

## Definition

**Boxing** is the process of converting a **primitive data type** into its corresponding **Wrapper Object**.

---

## Manual Boxing

The programmer explicitly converts a primitive into a wrapper object using `valueOf()`.

```java
int number = 100;

Integer obj = Integer.valueOf(number);
```

### Memory Representation

```
Primitive
number = 100
      |
      | Integer.valueOf()
      V
Wrapper Object
obj = Integer(100)
```

---

## Auto Boxing

The Java compiler automatically converts a primitive into a wrapper object.

```java
Integer age = 25;
```

Compiler converts it into:

```java
Integer age = Integer.valueOf(25);
```

---

# Unboxing

## Definition

**Unboxing** is the process of converting a **Wrapper Object** back into its corresponding **primitive data type**.

---

## Manual Unboxing

The programmer explicitly converts the object using methods like `intValue()`.

```java
Integer obj = Integer.valueOf(150);

int number = obj.intValue();
```

### Memory Representation

```
Wrapper Object
obj = Integer(150)
      |
      | intValue()
      V
Primitive
number = 150
```

---

## Auto Unboxing

The Java compiler automatically converts the wrapper object into a primitive.

```java
Integer a = 100;
Integer b = 50;

int sum = a + b;
```

Compiler internally performs:

```java
int sum = a.intValue() + b.intValue();
```

Output

```
150
```

---

# Difference Between Boxing and Unboxing

| Boxing | Unboxing |
|---------|----------|
| Primitive → Wrapper Object | Wrapper Object → Primitive |
| Uses `valueOf()` | Uses `intValue()`, `doubleValue()`, etc. |
| Stores primitive as an object | Extracts primitive value from object |

---

# Manual vs Auto Boxing

| Manual Boxing | Auto Boxing |
|---------------|-------------|
| `Integer obj = Integer.valueOf(10);` | `Integer obj = 10;` |
| Programmer performs conversion | Compiler performs conversion |

---

# Manual vs Auto Unboxing

| Manual Unboxing | Auto Unboxing |
|-----------------|---------------|
| `int x = obj.intValue();` | `int x = obj;` |
| Programmer performs conversion | Compiler performs conversion |

---

# Interview Questions

### Q1. What is Boxing?

Converting a primitive data type into its corresponding Wrapper Object.

Example:

```java
Integer obj = Integer.valueOf(10);
```

---

### Q2. What is Auto Boxing?

Automatic conversion of a primitive into a Wrapper Object by the compiler.

```java
Integer obj = 10;
```

---

### Q3. What is Unboxing?

Converting a Wrapper Object back into its primitive value.

```java
Integer obj = Integer.valueOf(20);

int x = obj.intValue();
```

---

### Q4. What is Auto Unboxing?

Automatic conversion of a Wrapper Object into a primitive by the compiler.

```java
Integer obj = 20;

int x = obj;
```

---

### Q5. Why do we need Wrapper Classes?

- Collections (`ArrayList`, `HashMap`) store objects, not primitives.
- Required when working with Generics.
- Useful for utility methods (`Integer.parseInt()`, `Double.valueOf()`, etc.).
- Supports `null` values (primitives cannot be `null`).

---

# Quick Revision

```
Primitive
    |
    | Boxing
    V
Wrapper Object
    ^
    | Unboxing
    |
Primitive
```

### Manual

```
int x = 10;

Integer obj = Integer.valueOf(x);

int y = obj.intValue();
```

### Automatic

```
Integer obj = 10;

int x = obj;
```

---

# Key Points to Remember

- Primitive → Wrapper = **Boxing**
- Wrapper → Primitive = **Unboxing**
- `valueOf()` performs **Manual Boxing**
- `intValue()`, `doubleValue()`, etc. perform **Manual Unboxing**
- The Java compiler automatically performs **Auto Boxing** and **Auto Unboxing**.
- Wrapper classes are mainly used with **Collections**, **Generics**, and Java APIs that require objects.