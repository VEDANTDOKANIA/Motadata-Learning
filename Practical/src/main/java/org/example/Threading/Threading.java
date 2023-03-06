package org.example.Threading;

class CustomThread implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Inside the run method");
            Thread.sleep(20000);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
public class Threading {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CustomThread());
        thread.start();
        thread.interrupt();
        thread.join();
//        thread.join();
        Thread.sleep(2000);
    }
}
