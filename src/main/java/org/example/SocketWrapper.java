package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//testing
public class SocketWrapper {
    private final Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(String message) throws IOException {
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println(message);
    }

    public Socket getSocket() {
        return socket;
    }

    public String receiveMessage() throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return input.readLine();
    }

    public void close() throws IOException {
        socket.close();
    }
}
