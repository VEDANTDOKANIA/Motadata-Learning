package org.example.Threading;

class Counter {
    int count;

    public void increment() {

        System.out.println("Before incrementing: "+count);

        synchronized (this) {

            count++;

        }

        System.out.println("After incrementing: "+count);

    }
}

public class SynchronizedBlock {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {

                    counter.increment();

                }

            }

        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {

                    counter.increment();

                }

            }

        });

        thread1.start();

        thread2.start();

        thread1.join();

        thread2.join();

        System.out.println(counter.count);
    }

}