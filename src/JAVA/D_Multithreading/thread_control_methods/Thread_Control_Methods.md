
# Thread Control Methods

## Introduction

Java provides several methods to control the execution of threads. These methods allow a thread to pause, wait, or give other threads an opportunity to execute.

The three commonly used thread control methods are:

1. `yield()`
2. `join()`
3. `sleep()`

---

# Thread Control Methods

| Method | Purpose |
|---------|---------|
| `yield()` | Gives other threads of the same priority a chance to execute. |
| `join()` | Makes one thread wait until another thread finishes. |
| `sleep()` | Pauses the current thread for a specified amount of time. |

---

# 1. sleep()

## Definition

The `sleep()` method pauses the execution of the **current thread** for a specified amount of time.

During this period, the thread enters the **Timed Waiting** state.

---

## Syntax

```java
Thread.sleep(milliseconds);
```

Example:

```java
Thread.sleep(1000); // Pause for 1 second
```

---

## Working

```text
Running
   │
sleep()
   │
   ▼
Timed Waiting
   │
Time Expired
   │
   ▼
Runnable
```

---

## Example

```java
public class SleepExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start");

        Thread.sleep(3000);

        System.out.println("End");
    }
}
```

---

## Output

```text
Start
(wait for 3 seconds)
End
```

---

## Uses

- Countdown timers
- Delay animations
- Retry mechanisms
- Periodic tasks

---

# 2. yield()

## Definition

The `yield()` method gives a **hint** to the **Thread Scheduler** that the current thread is willing to pause temporarily so that another thread of the **same priority** can execute.

> **Note:** Calling `yield()` does **not guarantee** that another thread will execute. It is only a suggestion to the Thread Scheduler.

---

## Syntax

```java
Thread.yield();
```

---

## Working

```text
Running
   │
yield()
   │
   ▼
Runnable
   │
Thread Scheduler
   │
   ▼
Running
```

---

## Example

```java
class MyThread extends Thread {

    @Override
    public void run() {

        Thread.yield();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread");
        }
    }
}
```

---

## Note

If the child thread calls `yield()`, the **main thread** gets more opportunities to execute.

As a result, the **main thread has a higher chance of completing first**.

However, this is **not guaranteed** because it depends on the **Thread Scheduler**.

---

## Uses

- Improving responsiveness
- Giving other threads a chance to execute
- Cooperative multitasking

---

# 3. join()

## Definition

The `join()` method makes **one thread wait until another thread completes its execution**.

---

## Syntax

```java
thread.join();
```

---

## Working

```text
Main Thread
      │
      ▼
Child Thread.start()
      │
      ▼
Child Thread Running
      │
main.join()
      │
      ▼
Main Thread Waiting
      │
Child Thread Finished
      │
      ▼
Main Thread Resumes
```

---

## Example

```java
class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Child : " + i);
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        MyThread thread = new MyThread();

        thread.start();

        thread.join();

        System.out.println("Main Thread");
    }
}
```

---

## Output

```text
Child : 1
Child : 2
Child : 3
Child : 4
Child : 5
Main Thread
```

---

## Uses

- Waiting for background tasks
- File downloading
- Data processing
- Report generation

---

# Comparison

| Method | Purpose | Thread State |
|---------|---------|--------------|
| `sleep()` | Pause the current thread | Timed Waiting |
| `yield()` | Give other threads a chance to execute | Runnable |
| `join()` | Wait for another thread to finish | Waiting / Timed Waiting |

---

# Key Points

- `sleep()` pauses the **current thread** for a specified time.
- `yield()` gives a **hint** to the Thread Scheduler.
- `join()` makes one thread wait until another thread completes.
- `yield()` is **not guaranteed** to switch execution.
- `sleep()` does **not release** any locks.
- `join()` is commonly used when task completion order is important.

---

# Interview Questions

### Q1. What are the three thread control methods?

- `sleep()`
- `yield()`
- `join()`

---

### Q2. Which method pauses the current thread?

**Answer:** `sleep()`

---

### Q3. Which method gives another thread a chance to execute?

**Answer:** `yield()`

---

### Q4. Which method waits for another thread to finish?

**Answer:** `join()`

---

### Q5. Does `yield()` guarantee that another thread will execute?

**Answer:** No. It only provides a hint to the Thread Scheduler.

---

# Summary

- `sleep()` pauses the current thread for a specified duration.
- `yield()` suggests to the Thread Scheduler that another thread may execute.
- `join()` makes one thread wait until another thread completes.
- These methods are essential for controlling thread execution and coordinating concurrent tasks.