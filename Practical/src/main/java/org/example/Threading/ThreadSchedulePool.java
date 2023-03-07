package org.example.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadSchedulePool extends Thread {

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

        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        // this task will run after 10 seconds
        service.schedule(new ThreadSchedulePool(), 10, SECONDS);

        // this task will run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new ThreadSchedulePool(), 15,10, SECONDS);
    }

}
