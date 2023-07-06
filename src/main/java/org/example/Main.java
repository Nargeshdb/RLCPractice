package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Thread serverThread = new Thread(() -> {
            try {
                server.start(8080);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        serverThread.start();


        Client client = new Client();
        client.start("localhost", 8080);
    }
}
