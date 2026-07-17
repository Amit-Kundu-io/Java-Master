# Thread Life Cycle

## Introduction

A **Thread Life Cycle** describes the different states a thread goes through from its creation until it terminates.

In Java, every thread passes through several states during its lifetime.

---

# Thread Life Cycle Diagram

```text
                 New
                  │
            start()
                  │
                  ▼
              Runnable
                  │
      Thread Scheduler
                  │
                  ▼
              Running
             /   |    \
            /    |     \
 sleep()  wait() join()
        \   |    /
         \  |   /
          ▼ ▼ ▼
      Waiting / Timed Waiting
                  │
       notify() / timeout
                  │
                  ▼
              Runnable
                  │
                  ▼
              Running
                  │
      Task Completed
                  │
                  ▼
            Terminated
```

---

# Thread States

## 1. New

A thread is in the **New** state after it is created but before the `start()` method is called.

### Example

```java
Thread thread = new Thread();
```

---

## 2. Runnable

When `start()` is called, the thread enters the **Runnable** state.

The thread is now ready to execute and waits for the **Thread Scheduler** to assign CPU time.

### Example

```java
thread.start();
```

---

## 3. Running

The thread enters the **Running** state when the **Thread Scheduler** selects it for execution.

The `run()` method begins executing.

---

## 4. Waiting / Timed Waiting

A running thread may temporarily stop execution.

This happens when methods such as:

- `sleep()`
- `wait()`
- `join()`

are called.

After the waiting condition is satisfied, the thread returns to the **Runnable** state.

---

## 5. Terminated

A thread enters the **Terminated** state when:

- the `run()` method finishes execution, or
- an unrecoverable exception occurs.

Once terminated, a thread **cannot be restarted**.

---

# State Transition

```text
New
 │
 │ start()
 ▼
Runnable
 │
 │ Thread Scheduler
 ▼
Running
 │
 ├── sleep()
 ├── wait()
 ├── join()
 ▼
Waiting
 │
 │ notify() / timeout
 ▼
Runnable
 │
 ▼
Running
 │
 ▼
Terminated
```

---

# Important Points

- Every thread starts in the **New** state.
- Calling `start()` moves the thread to the **Runnable** state.
- The **Thread Scheduler** decides when a runnable thread starts running.
- `sleep()`, `wait()`, and `join()` temporarily pause thread execution.
- After waiting, the thread returns to the **Runnable** state.
- Once a thread reaches the **Terminated** state, it cannot be started again.

---

# Interview Questions

### Q1. What are the states of a thread in Java?

- New
- Runnable
- Running
- Waiting / Timed Waiting
- Terminated

---

### Q2. Which method moves a thread from New to Runnable?

**Answer:** `start()`

---

### Q3. Which component moves a Runnable thread to the Running state?

**Answer:** Thread Scheduler

---

### Q4. Can a terminated thread be restarted?

**Answer:** No. Once terminated, a thread cannot be started again.

---

# Summary

- A thread passes through multiple states during its execution.
- `start()` moves a thread from **New** to **Runnable**.
- The **Thread Scheduler** selects a runnable thread for execution.
- Waiting methods temporarily pause execution.
- After completing its task, the thread enters the **Terminated** state.