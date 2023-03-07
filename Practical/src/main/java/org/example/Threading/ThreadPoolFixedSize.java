package org.example.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFixedSize extends Thread {

    int index;
    ThreadPoolFixedSize(int index) {

        index = this.index;

    }

    @Override
    public void run() {

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }

        for (int i = 0; i < 5; i++) {

            System.out.println("Thread count: "+Thread.activeCount());

            System.out.println(Thread.currentThread().getName()+" - "+i);

        }

    }

    public static void main(String[] args) {

        System.out.println("Initial Thread Count: "+Thread.activeCount());

        ExecutorService service = Executors.newFixedThreadPool(3);

//        for (int i = 0; i < 5; i++) {
//
//            service.submit(new ThreadPoolFixedSize(i));
//
//        }

        service = Executors.newCachedThreadPool();

        /*
            here number of threads are equals to Integer.MAX_VALUE
         */

        for (int i = 0; i < 5; i++) {

            service.submit(new ThreadPoolFixedSize(i));

        }


    }
}
