package org.example.Threading;

class CounterClass {
    int count;

    public synchronized void increment() {

        System.out.println(Thread.currentThread().getName()+" - Before incrementing: "+count);

        count++;

        System.out.println(Thread.currentThread().getName()+" - After incrementing: "+count);

    }
}

public class SynchronizedMethod {

    public static void main(String[] args) throws InterruptedException {

        CounterClass counter = new CounterClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {

                    counter.increment();

                }

            }

        }, "Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {

                    counter.increment();

                }

            }

        }, "Thread2");

        thread1.start();

        thread2.start();

    }

}
