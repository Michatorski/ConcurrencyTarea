package org.iesfm.concurrency;

import java.util.concurrent.Semaphore;

public class SaludoTask implements Runnable {

    private Semaphore semaphore;

    public SaludoTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // POne uno en verde
        semaphore.release();
        try {
            // Necesita los dos en verde
            semaphore.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Adios");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
