package JAVA.D_Multithreading.doc.java.thread.create;

public class TestThread {
    public static void main(String[] args) {

        /*  Thread class extends to create a thread */
        MyThread t1 = new MyThread();

        //print thread name
        var threadName = t1.getName();
        var mainThreadName  = Thread.currentThread().getName();
        System.out.println("Main thread name "+ mainThreadName);
        System.out.println("t1 thread name "+threadName);

        //Set Thread name
        t1.setName("Child Thread");
        var threadName1 = t1.getName();
        System.out.println("t1 thread name "+threadName1);


        t1.start();

        /***
         * MyThread t1 = new MyThread();
         *  t1.start();
         *  t1.start(); // not possible , one thread object can be start only once ,
         *  if you need then need to create a new object or reference
         */

        /** Runnable ------ -------*/

        // Create the task (Runnable) that contains the code to execute
        MyRunnable r1 = new MyRunnable();

        // Create a new Thread and assign the Runnable task to it
        // Runnable defines "what to do", Thread defines "where/how to run it"
        Thread t2 = new Thread(r1);

        // Start a new thread.
        // The JVM creates a separate thread and automatically calls r1.run()
        // (Don't call run() directly if you want concurrent execution.)
        t2.start();


    }
}



 class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10;i++){
            System.out.println("Thread run " + i);
        }
    }
}



 class MyRunnable  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10;i++){
            System.out.println("Runnable run " + i);
        }
    }
}


