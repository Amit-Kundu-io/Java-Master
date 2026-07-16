
# Multithreading

## Multitasking

**Multitasking** means executing multiple tasks simultaneously. It is of two types:

### 1. Process-Based Multitasking
- Multiple independent programs (**processes**) run at the same time.
- Each process has its own separate memory.
- Processes do **not** share memory with each other.

**Example:**
- Google Chrome
- VLC Media Player
- Microsoft Word

These applications can run simultaneously on your computer.

---

### 2. Thread-Based Multitasking (Multithreading)
- Multiple **threads** execute simultaneously within the same program.
- Threads are independent units of execution but belong to the same process.
- Threads share the same memory and resources.

**Example (VLC Media Player):**
- **Thread 1:** Play audio/video
- **Thread 2:** Update timer and progress bar
- **Thread 3:** Handle Play/Pause button
- **Thread 4:** Load subtitles

---

# What is a Thread?

A **Thread** is the smallest unit of execution within a program.

## Definition

> A **Thread** is an independent path of execution that runs as part of a program.

or

> A **Thread** is a lightweight sub-task of a process that allows multiple tasks to execute concurrently.

---

## Example

**Program:** VLC Media Player

- **Thread 1:** Play video
- **Thread 2:** Display timer
- **Thread 3:** Handle Play/Pause
- **Thread 4:** Load subtitles

> **Note:** A thread is **not** a separate program. It is only a part of a program.

---

# Process vs Thread

| Process | Thread |
|---------|--------|
| A running program | A small unit of execution inside a process |
| Has its own separate memory | Shares the process memory |
| Heavyweight | Lightweight |
| Creation is slower | Creation is faster |
| Communication is slower (IPC required) | Communication is faster (Shared Memory) |
| Consumes more resources | Consumes fewer resources |
| Example: Chrome, VS Code, VLC | Example: UI Thread, Download Thread |

---

# Memory Representation

```text
Process (Chrome)
│
├── Thread 1 → UI
├── Thread 2 → Network Requests
├── Thread 3 → Downloads
└── Thread 4 → Rendering

(All threads share the same process memory.)
```

---

# Important Notes

- A **Process** can contain **multiple Threads**.
- Threads belonging to the same process **share memory and resources**.
- Every thread has its own **execution stack**.
- All threads share the **Heap Memory** of the process.

---

# Why Do We Need Multithreading?

## 1. Better Performance
Multiple tasks can execute simultaneously, improving application performance.

**Example:**
A browser loads multiple tabs at the same time.

---

## 2. Improved Responsiveness
The application remains responsive while performing background tasks.

**Example:**
Downloading a file while scrolling through social media.

---

## 3. Efficient CPU Utilization
Modern processors have multiple CPU cores, allowing multiple threads to execute in parallel.

---

## 4. Resource Sharing
Threads share the same memory, making communication faster and more efficient.

---

## 5. Faster Execution
Independent tasks can execute concurrently, reducing the total execution time.

---

# Real-World Examples

## WhatsApp
- Send Messages
- Receive Messages
- Voice Calls
- Notifications

Each task runs on a separate thread.

---

## YouTube
- Play Video
- Buffer Video
- Show Comments
- Display Recommendations

---

## Google Chrome
- Render Web Page
- Execute JavaScript
- Download Files
- Handle User Input

---

# Interview Definition

### What is Multithreading?

> **Multithreading** is a Java feature that allows multiple threads to execute concurrently within a single process, improving performance, responsiveness, and efficient CPU utilization.

---

# Quick Revision

- **Process** = Running Program
- **Thread** = Smallest Unit of Execution
- **One Process → Multiple Threads**
- **Threads Share Memory**
- **Multithreading = Multiple Threads Executing Concurrently Within One Program**

---

# Key Points to Remember

- Process = Heavyweight
- Thread = Lightweight
- Process has separate memory.
- Threads share process memory.
- One process can have multiple threads.
- Thread communication is faster than process communication.
- Multithreading improves performance and responsiveness.