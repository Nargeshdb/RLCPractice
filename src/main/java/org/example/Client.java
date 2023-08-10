package org.example;

import org.checkerframework.checker.mustcall.qual.MustCall;

import java.io.IOException;

public class Client {
    public void start(String serverIP, int serverPort) {
        ClientWrapper s = null;
        try {
            s = new ClientWrapper(serverIP, serverPort);
            s.setupConnection(serverIP, serverPort);
            s.closeSocket();
            System.out.println("Connected to server: " + serverIP + ":" + serverPort);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
