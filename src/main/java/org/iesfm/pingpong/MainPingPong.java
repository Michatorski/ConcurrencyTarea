package org.iesfm.pingpong;

import java.util.concurrent.Semaphore;

public class MainPingPong {

    public static void main(String[] args) {
        Semaphore pingSempahore = new Semaphore(1);
        Semaphore pongSempahore = new Semaphore(1);

        Thread saludoThread = new Thread(new Ping(pingSempahore, pongSempahore));
        Thread yaThread = new Thread(new Pong(pingSempahore, pongSempahore));

        try {
            pongSempahore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
