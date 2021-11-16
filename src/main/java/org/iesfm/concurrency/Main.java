package org.iesfm.concurrency;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);
        try {
            s.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread saludoThread = new Thread(new SaludoTask(s));
        Thread yaThread = new Thread(new YaHaSaludadoTask(s));

        saludoThread.start();
        yaThread.start();

        try {
            saludoThread.join();
            yaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ha terminado");
    }
}
