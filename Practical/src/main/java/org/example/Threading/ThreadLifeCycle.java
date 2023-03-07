package org.example.Threading;

public class ThreadLifeCycle extends Thread {

    ThreadLifeCycle(String name) {

        super(name);

    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" State: "+Thread.currentThread().getState());

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLifeCycle thread = new ThreadLifeCycle("Thread1");

        System.out.println(thread.getName()+" State: "+thread.getState());

        System.out.println(Thread.currentThread().getName()+" State: "+Thread.currentThread().getState());

        thread.start();

        thread.join();

        System.out.println("After thread.join(): "+Thread.currentThread().getName()+" State: "+Thread.currentThread().getState());

        System.out.println(thread.getName()+" State: "+thread.getState());

    }
}
