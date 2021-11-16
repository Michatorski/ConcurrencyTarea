package org.iesfm.pingpong;

import java.util.concurrent.Semaphore;

public class Ping implements Runnable{

    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public Ping(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                pingSemaphore.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ping");
            pongSemaphore.release();
        }
    }
}
