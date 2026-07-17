# Creating Threads in Java

## Introduction

A **thread** is the smallest unit of execution within a Java program. To execute a task concurrently, Java provides multiple ways to create and run threads.

Depending on the use case, different approaches are recommended. While some methods are useful for learning, others are preferred in production applications.

---

# Ways to Create a Thread

Java provides **four common ways** to create and execute threads:

1. Extending the `Thread` Class
2. Implementing the `Runnable` Interface
3. Using Lambda Expression
4. Using `ExecutorService`

> **Interview Tip:** The most commonly used approaches in real-world applications are **Runnable** and **ExecutorService**.

---

# 1. Extending the Thread Class

The `Thread` class provides a built-in mechanism to create a new thread.

To create a thread:

- Extend the `Thread` class.
- Override the `run()` method.
- Call the `start()` method.

---

## Syntax

```java
class MyThread extends Thread {

    @Override
    public void run() {
        // Task
    }
}
```

---

## Example

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Child Thread is Running...");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.start();

        System.out.println("Main Thread");
    }
}
```

---

## Output

```text
Main Thread
Child Thread is Running...
```

> **Note:** The output order may change because the Thread Scheduler decides which thread executes first.

---


## `start()` Method

The `start()` method is used to **create and start a new thread**.

When `start()` is called:

1. A new thread is created.
2. The thread is registered with the **Thread Scheduler**.
3. The Thread Scheduler decides when the thread should execute.
4. The JVM automatically invokes the `run()` method on the new thread.

> **Note:** Create a thread is responsibility of thread class because start() method Is only available in Thread class


# Internal Working

## When `start()` is Called

```text
main()
   │
   ▼
thread.start()
   │
   ▼
New Thread Created
   │
   ▼
Thread Scheduler
   │
   ▼
run()
   │
   ▼
Task Executes
```


## `run()` Method

The `run()` method contains the **task** that a thread performs.

Calling `run()` directly **does not create a new thread**.

Instead, it behaves like a normal Java method and executes in the current thread.

> **Note:** Creating a task is responsibility of run() which is from runnable.


## When `run()` is Called

```text
main()
   │
   ▼
thread.run()
   │
   ▼
Normal Method Call
   │
   ▼
Task Executes
```

---

# 2. Implementing the Runnable Interface (Recommended)

The `Runnable` interface represents a task that can be executed by a thread.

Instead of extending `Thread`, implement `Runnable` and pass its object to the `Thread` constructor.

---

## Syntax

```java
class MyTask implements Runnable {

    @Override
    public void run() {
        // Task
    }
}
```

---

## Example

```java
class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable Thread");
    }
}

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyTask());

        thread.start();
    }
}
```

---

## Working

```text
Runnable Object
        │
        ▼
Thread Constructor
        │
        ▼
start()
        │
        ▼
run()
        │
        ▼
Task Executes
```

---

## Advantages

- Supports multiple inheritance.
- Better code reusability.
- Cleaner design.
- Most commonly used approach.

## Disadvantages

- Slightly more code than extending `Thread`.

---

# 3. Using Lambda Expression (Java 8+)

Since `Runnable` is a **Functional Interface**, it can be implemented using a Lambda Expression.

This approach reduces boilerplate code.

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread using Lambda");
        });

        thread.start();
    }
}
```

---

## Advantages

- Less code.
- Easy to read.
- Perfect for small tasks.

## Disadvantages

- Not suitable for large or complex tasks.

---

# 4. Using ExecutorService (Production Recommended)

Creating a new thread for every task is expensive.

Java provides the **Executor Framework**, which manages a pool of reusable threads.

Instead of manually creating threads, tasks are submitted to the thread pool.

---

## Example

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() ->
                System.out.println(Thread.currentThread().getName()));

        executor.shutdown();
    }
}
```

---

## Working

```text
Application
      │
      ▼
ExecutorService
      │
      ▼
Thread Pool
 ┌──────────────┐
 │ Thread 1     │
 │ Thread 2     │
 │ Thread 3     │
 └──────────────┘
      │
      ▼
Execute Tasks
```

---

## Advantages

- Reuses existing threads.
- Better performance.
- Reduces memory usage.
- Easy thread management.
- Production-ready solution.

## Disadvantages

- Slightly more complex for beginners.

---

# Which Method Should You Use?

| Scenario | Recommended Approach |
|----------|----------------------|
| Learning Java Threads | Extend `Thread` |
| General Development | `Runnable` |
| Short Tasks | Lambda Expression |
| Enterprise Applications | `ExecutorService` |

---

# Best Practices

- Prefer **Runnable** over extending `Thread`.
- Use **Lambda Expressions** for short and simple tasks.
- Use **ExecutorService** in production applications.
- Avoid creating unnecessary threads.
- Always shut down an `ExecutorService` after use.

---

# Common Mistakes

❌ Calling `run()` instead of `start()`.

❌ Creating thousands of threads manually.

❌ Forgetting to call `shutdown()` on an `ExecutorService`.

❌ Extending `Thread` when implementing `Runnable` is sufficient.

---

# Interview Questions

### Q1. How many ways are there to create a thread in Java?

**Answer:**
1. Extending the `Thread` class
2. Implementing the `Runnable` interface
3. Using Lambda Expression
4. Using `ExecutorService`

---

### Q2. Which approach is recommended?

**Answer:**
Implementing `Runnable` or using `ExecutorService`.

---

### Q3. Why is `Runnable` preferred over extending `Thread`?

**Answer:**

- Supports multiple inheritance.
- Better separation of task and thread.
- More reusable.
- Cleaner object-oriented design.

---

### Q4. Which approach is used in real-world applications?

**Answer:**
Most enterprise applications use **ExecutorService** because it efficiently manages thread pools and improves performance.

---

# Summary

- Java provides **four common ways** to create threads.
- Extending `Thread` is simple but mainly useful for learning.
- Implementing `Runnable` is the preferred general-purpose approach.
- Lambda expressions simplify thread creation for small tasks.
- `ExecutorService` is the recommended choice for scalable, production-ready applications because it manages thread pools efficiently.


# Thread Scheduler

## What is Thread Scheduler?

When multiple threads are waiting for execution, deciding **which thread gets the chance to execute next** is the responsibility of the **Thread Scheduler**.

The **Thread Scheduler** is an internal component of the **Java Virtual Machine (JVM)**.

> **Note:** The scheduling algorithm is **JVM-dependent**, meaning its behavior may vary depending on the JVM vendor and the underlying operating system.

---

## How Thread Scheduler Works

```text
           JVM

     Thread Scheduler
            │
   ┌────────┼────────┐
   │        │        │
   ▼        ▼        ▼
Thread 1  Thread 2  Thread 3
 Waiting   Waiting   Waiting
            │
            ▼
 Chooses one thread for execution
```

---

## Important Points

- Responsible for selecting the next thread for execution.
- It is an internal component of the JVM.
- There is **no guarantee** about the execution order of threads.
- The scheduling algorithm may differ across JVM implementations.

---

# Difference Between `start()` and `run()`

The `start()` and `run()` methods are frequently asked in Java interviews.

Although both are related to thread execution, they behave very differently.

| `start()` | `run()` |
|-----------|----------|
| Creates a **new thread**. | Does **not** create a new thread. |
| JVM calls the `run()` method internally. | Executes like a normal method call. |
| Executes concurrently. | Executes sequentially in the current thread. |
| Thread Scheduler decides when it runs. | No Thread Scheduler involvement. |
| Used to start a thread. | Contains the task to be executed. |

---

## `start()` Method

When we call the **`start()`** method:

- A **new thread is created**.
- The JVM registers the thread with the **Thread Scheduler**.
- The Thread Scheduler decides when the new thread should execute.
- The new thread eventually calls the **`run()`** method automatically.

### Flow

```text
main()
   │
   ▼
thread.start()
   │
   ▼
New Thread Created
   │
   ▼
Thread Scheduler
   │
   ▼
run()
```

### Example

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Child Thread");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.start();

        System.out.println("Main Thread");
    }
}
```

---

## `run()` Method

When we call the **`run()`** method directly:

- **No new thread is created.**
- The `run()` method executes just like a normal Java method.
- Everything runs in the **current thread** (usually the `main` thread).

### Flow

```text
main()
   │
   ▼
thread.run()
   │
   ▼
Normal Method Call
   │
   ▼
Task Executes
```

### Example

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Child Thread");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.run();

        System.out.println("Main Thread");
    }
}
```

---

## Interview Note

> **When we use `thread.start()`, a new thread is created, and that new thread is responsible for executing the `run()` method.**

> **When we use `thread.run()`, no new thread is created. The `run()` method executes like a normal Java method in the current thread.**

---

# Important Concept

## Creating Task vs Creating Thread

This is one of the most important concepts in Java Multithreading.

### Creating a Task

Creating a **task** is the responsibility of the **`run()`** method.

The `run()` method contains the code that the thread will execute.

```java
@Override
public void run() {
    System.out.println("Task Executing...");
}
```

---

### Creating a Thread

Creating a **thread** is the responsibility of the **`Thread`** class.

The **`start()`** method is available only in the `Thread` class and is responsible for creating a new thread.

```java
Thread thread = new Thread(new MyTask());

thread.start();
```

---

## Flow

```text
Runnable
    │
    ▼
run()  ← Defines the Task
    │
    ▼
Thread
    │
    ▼
start()  ← Creates the Thread
    │
    ▼
Thread Scheduler
    │
    ▼
run() Executes
```

---

## Key Points

- `run()` defines **what** work should be done.
- `start()` creates **who** will perform the work (a new thread).
- `run()` belongs to the `Runnable` interface.
- `start()` belongs to the `Thread` class.
- Never call `run()` directly when you want concurrent execution.

---

# Interview Tip

> **`run()` is responsible for defining the task, while `start()` is responsible for creating and starting a new thread to execute that task.**