package JAVA.D_Multithreading.thread_control_methods;

public class ThreadControl {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Main Thread :- "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}


class MyThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Child Thread :- "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}