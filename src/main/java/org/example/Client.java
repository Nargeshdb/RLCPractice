package org.example;

import java.io.IOException;

public class Client {

    public void start(String serverIP, int serverPort) {
        ClientWrapper s = new ClientWrapper();
        try {
            s.setupConnection(serverIP, serverPort);
            System.out.println("Connected to server: " + serverIP + ":" + serverPort);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
