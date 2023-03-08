package org.example.Threading;

public class DeadLock {

    public static void main(String[] args) {

        String resourse1 = "Nikunj";

        String resourse2 = "Patel";

        Thread thread1 = new Thread("Thread1") {
            @Override
            public void run() {

                synchronized (resourse1) {

                    System.out.println("Thread1 has acquired lock on resource 1");

                    try {

                        Thread.sleep(800);

                    } catch (InterruptedException interruptedException) {

                        System.out.println("Exception: "+interruptedException);

                    }

                    synchronized (resourse2) {

                        System.out.println("Thread1 has acquired lock on resource2");

                    }

                }

            }
        };

        Thread thread2 = new Thread("Thread2") {
            @Override
            public void run() {

                synchronized (resourse2) {

                    System.out.println("Thread2 has acquired lock on resource 2");

                    try {

                        Thread.sleep(800);

                    } catch (InterruptedException interruptedException) {

                        System.out.println("Exception: "+interruptedException);

                    }

                    synchronized (resourse1) {

                        System.out.println("Thread2 has acquired lock on resource 1");

                    }

                }

            }
        };

        thread1.start();

        thread2.start();

    }

}
