package org.example;

import java.io.IOException;
import java.net.Socket;

public class ClientWrapper {
    protected Socket socket = null;
    protected void setupConnection(String address, int port) throws IOException {
        // This is the original test case. Before this issue was fixed, an error was issued on the
        // second line.
        this.socket.close();
        this.socket = new Socket(address, port);
    }

    public void closeSocket() throws IOException {
        this.socket.close();
    }

}
