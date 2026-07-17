## Concurrent vs Parallel Execution

### Important Note

> **Concurrent execution does not always mean that multiple tasks are running at the exact same millisecond.**

Concurrency means multiple tasks make progress during the same period of time. On a single-core CPU, the processor rapidly switches between tasks, giving the illusion that they are running simultaneously.

Parallelism, on the other hand, means multiple tasks are actually running at the same time on different CPU cores.

### Example

Imagine you are writing notes while occasionally listening to music.

- You switch your attention between writing and listening.
- Both tasks progress over time.
- This is an example of **concurrency**.

Now imagine two people:

- Person A writes notes.
- Person B listens and summarizes the lecture.

Both tasks happen at the same time.

This is **parallelism**.

---

## Sequential Program

A **Sequential Program** executes one task at a time.

The next task starts only after the previous task has finished.

### Flow

```text
Start
   │
   ▼
Task 1
   │
   ▼
Task 2
   │
   ▼
Task 3
   │
   ▼
 End
```

### Characteristics

- Executes tasks one after another.
- Only one task runs at a time.
- Easy to understand and debug.
- Does not utilize multiple CPU cores efficiently.

### Example

```java
public class SequentialExample {

    public static void main(String[] args) {

        System.out.println("Loading User...");
        System.out.println("Loading Products...");
        System.out.println("Loading Orders...");
    }
}
```

**Output**

```text
Loading User...
Loading Products...
Loading Orders...
```

---

## Concurrent Program

A **Concurrent Program** performs multiple independent tasks during the same time period.

The JVM schedules different threads to execute independently.

### Flow

```text
                 Program
                    │
      ┌─────────────┼─────────────┐
      │             │             │
      ▼             ▼             ▼
  Thread 1      Thread 2      Thread 3
 Download      Play Music     Show UI
```

### Characteristics

- Multiple tasks make progress together.
- Improves responsiveness.
- Makes better use of CPU resources.
- Suitable for background operations.

### Real-World Examples

**YouTube**

- Play video
- Load comments
- Buffer video
- Display advertisements

**WhatsApp**

- Send messages
- Receive messages
- Voice calls
- Notifications

---

# How to Create a Thread in Java

Java provides several ways to create and execute threads.

## 1. Extending the `Thread` Class

Create a class that extends `Thread` and override the `run()` method.

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
    }
}
```

### Advantages

- Simple to understand.
- Good for learning.

### Disadvantages

- Java supports only single inheritance.
- Your class cannot extend another class.

---

## 2. Implementing the `Runnable` Interface ✅ (Recommended)

Implement the `Runnable` interface and override the `run()` method.

### Example

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

### Advantages

- Supports multiple inheritance through interfaces.
- Better code reusability.
- Recommended for most applications.

---

## 3. Using Lambda Expression (Java 8+)

If the task is small, a lambda expression can be used.

### Example

```java
public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Running using Lambda");
        });

        thread.start();
    }
}
```

### Advantages

- Less boilerplate code.
- Easy to read.
- Best for short tasks.

---

## 4. Using ExecutorService (Production Recommended)

Instead of creating threads manually, Java provides the **Executor Framework** to manage thread creation and execution efficiently.

### Example

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

### Advantages

- Thread Pool support.
- Better performance.
- Reuses existing threads.
- Prevents creating too many threads.
- Widely used in real-world applications.

---

# Which Approach Should You Use?

| Method | Recommended | Used In |
|---------|:-----------:|---------|
| Extending `Thread` | ❌ | Learning |
| Implementing `Runnable` | ✅ | Most Applications |
| Lambda Expression | ✅ | Java 8+ |
| ExecutorService | ⭐⭐⭐⭐⭐ | Production Applications |

---

## Interview Tip

> For interviews, always mention **Runnable** and **ExecutorService** as the preferred approaches.

- `Thread` → Good for learning.
- `Runnable` → Standard approach.
- `ExecutorService` → Best for real-world applications because it manages thread pools efficiently.


## Parallel Execution

**Parallel Execution** means multiple tasks are executed **at the exact same time**.

This is possible only when the system has multiple CPU cores or processors.

Each task runs on a separate core, allowing true simultaneous execution.

### Characteristics

- Multiple tasks run simultaneously.
- Requires a multi-core processor.
- Improves performance for CPU-intensive tasks.
- No context switching is needed between parallel tasks.

---

### Flow

```text
           CPU (4 Cores)

Core 1 ──► Thread 1
Core 2 ──► Thread 2
Core 3 ──► Thread 3
Core 4 ──► Thread 4

(All threads execute at the same time.)
```

---

### Real-World Example

Suppose your computer has a **4-core processor**.

- Core 1 → Playing a YouTube video
- Core 2 → Downloading a file
- Core 3 → Compiling Java code
- Core 4 → Playing music

All four tasks execute **simultaneously**.

---

## Concurrent vs Parallel

| Concurrent Execution | Parallel Execution |
|-----------------------|--------------------|
| Tasks make progress during the same time period. | Tasks execute at the exact same time. |
| May run on a single CPU core. | Requires multiple CPU cores. |
| Uses context switching. | Runs simultaneously on different cores. |
| Improves responsiveness. | Improves performance. |
| Example: One CPU switching between multiple threads. | Example: Multiple CPU cores running different threads. |

---

## Interview Tip

> **Concurrency** is about **dealing with multiple tasks at once**, while **Parallelism** is about **executing multiple tasks at the same time**.

- **Concurrency** = Multiple tasks are in progress.
- **Parallelism** = Multiple tasks are executing simultaneously.














