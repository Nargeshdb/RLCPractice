package org.example;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethods;
import org.checkerframework.checker.mustcall.qual.InheritableMustCall;
import org.checkerframework.checker.mustcall.qual.MustCallAlias;
import org.checkerframework.checker.mustcall.qual.NotOwning;
import org.checkerframework.checker.mustcall.qual.Owning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@InheritableMustCall({"close"}) class SocketWrapper {

    private final @Owning Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public @MustCallAlias SocketWrapper(@MustCallAlias Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(String message) throws IOException {
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println(message);
    }

    public @NotOwning Socket getSocket() {
        return socket;
    }

    public String receiveMessage() throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return input.readLine();
    }
    @EnsuresCalledMethods(value = {"socket"}, methods="close")
    public void close() throws IOException {
        socket.close();
    }
}
