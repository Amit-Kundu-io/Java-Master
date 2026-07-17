package JAVA.D_Multithreading.doc.java.thread.thread_priority;

/**
 *Thread Priorities
 * -----------------------
 * In java thread can have different priorities that indicate their importance to the thread scheduler.
 * Priorities can be from 1 to 10
 * 1 -- lowest priority
 * 5 - Normal priority
 * 10 -- highest priority
 */
public class PriorityExample {
    public static void main(String[] args) {

        //Main thread priority checking
        Thread thread = Thread.currentThread();
        System.out.println("Thread : " + thread.getName() + " Priority: " + thread.getPriority());

        Thread t1 = new Thread(new MyRunnable(),"Thread-1");
        Thread t2 = new Thread(new MyRunnable(),"Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

    }
}
