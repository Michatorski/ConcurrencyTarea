package org.iesfm.concurrency;

import java.util.concurrent.Semaphore;

public class YaHaSaludadoTask implements Runnable {
    private Semaphore semaphore;

    public YaHaSaludadoTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // En cuanto uno este en verde tira
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Ya ha saludado"
        );
        // POne los dos en verde
        semaphore.release(2);

    }
}
