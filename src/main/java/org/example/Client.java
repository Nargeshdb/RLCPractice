package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {

    public void justConnect(String serverIP, int serverPort) {
        try {
            // Leak reported for this line.  Fix by rewriting the code using try-with-resources.
            Socket s = new Socket(serverIP, serverPort);
            System.out.println("Connected to server: " + serverIP + ":" + serverPort);
            System.out.println("Receive buffer size: " + s.getReceiveBufferSize());
            s.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void start(String serverIP, int serverPort) {
        SocketWrapper socket = null;
        try {
            // Leak reported for this line, but it's a false positive, since socket gets closed.
            // Fix by adding appropriate annotations to SocketWrapper.
            Socket s = new Socket(serverIP, serverPort);
            socket = new SocketWrapper(s);
            System.out.println("Connected to server: " + serverIP + ":" + serverPort);

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            String message;

            System.out.print("Enter a message to send to the server (or 'quit' to exit): ");
            message = input.readLine();

            socket.sendMessage(message);
            System.out.println("Server response: " + socket.receiveMessage());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
