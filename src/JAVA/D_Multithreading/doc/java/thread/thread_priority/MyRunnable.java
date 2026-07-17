package JAVA.D_Multithreading.doc.java.thread.thread_priority;

public class MyRunnable  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10;i++){
            System.out.println(i);
        }
    }
}
