package org.example.Threading;

class Table {
    public synchronized static void printTable(int n) {

        for (int i = 1; i <= 10; i++) {

            System.out.println(n+"*"+i+"="+n*i);

        }

        try {

            Thread.sleep(100);

        } catch (InterruptedException interruptedException) {

            System.out.println("Exception: "+interruptedException);

        }
    }
}

public class StaticSynchronized {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                Table.printTable(5);

            }
        }, "Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                Table.printTable(10);

            }
        }, "Thread2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                Table.printTable(12);

            }
        }, "Thread3");

        thread1.start();

        thread2.start();

        thread3.start();
    }

}
