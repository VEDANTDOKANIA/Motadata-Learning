package org.example.Threading;
public class ThreadSleep extends Thread {

    ThreadSleep(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {

            System.out.println(Thread.currentThread().getName()+" - before sleep");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" - "+i);
            }

            System.out.println(Thread.currentThread().getName()+" - after sleep");

        } catch (InterruptedException interruptedException) {

            interruptedException.printStackTrace();

        }

    }

    public static void main(String[] args) {

        ThreadSleep thread1 = new ThreadSleep("Thread1");

        ThreadSleep thread2 = new ThreadSleep("Thread2");

        thread1.start();

        thread2.start();
    }
}
