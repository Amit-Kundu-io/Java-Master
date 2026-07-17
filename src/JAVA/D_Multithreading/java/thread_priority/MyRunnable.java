package JAVA.D_Multithreading.java.thread_priority;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Thread : " + thread.getName() + " Priority: " + thread.getPriority());
    }
}
