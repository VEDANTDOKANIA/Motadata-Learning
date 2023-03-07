package org.example.Threading;

public class ThreadPriority extends Thread {

    ThreadPriority(String name) {
        super(name);
    }
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority());

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+" - "+i);

        }

    }

    public static void main(String[] args) {

        ThreadPriority thread1 = new ThreadPriority("Thread1");

        ThreadPriority thread2 = new ThreadPriority("Thread2");

        ThreadPriority thread3 = new ThreadPriority("Thread3");

        thread1.setPriority(2);

        thread2.setPriority(10);

        thread3.setPriority(4);

        thread1.start();

        thread3.start();

        thread2.start();
    }
}
