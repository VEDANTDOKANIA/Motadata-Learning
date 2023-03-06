package org.example.Threading;

class CustomThread implements Runnable {
    Thread threadToInterrupt;
    @Override
    public void run() {
        try {
            threadToInterrupt.interrupt();
        } catch (Exception exception) {
            System.out.println(exception);
        }
//        try {
//            System.out.println("Inside the run method");
//            Thread.sleep(20000);
//        } catch (Exception exception) {
//            System.out.println(exception);
//        }
    }
}
public class Threading {
    public static void main(String[] args) throws InterruptedException {

        CustomThread customThread = new CustomThread();

        customThread.threadToInterrupt = Thread.currentThread();

        System.out.println(customThread.threadToInterrupt.getName());

        Thread thread = new Thread(customThread);

        thread.start();

        thread.join();


//        Thread thread = new Thread(new CustomThread());
//        thread.start();
//        thread.interrupt();
//        thread.join();
////        thread.join();
//        Thread.sleep(2000);
    }
}
