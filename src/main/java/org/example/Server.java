package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start(int port) throws IOException {
        ServerSocket serverSocket = null;
        SocketWrapper clientSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            socket = serverSocket.accept();
            clientSocket = new SocketWrapper(socket);
            System.out.println("Client connected: " + clientSocket.getSocket().getInetAddress().getHostAddress());

            String message;
            while ((message = clientSocket.receiveMessage()) != null) {
                System.out.println("Received message: " + message);
                clientSocket.sendMessage("Server received: " + message);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                if (socket != null) socket.close();
                System.out.println("Error closing sockets: " + e.getMessage());
            }
        }
    }
}
