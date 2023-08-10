package org.example;

import java.io.IOException;
import java.net.Socket;
import org.checkerframework.checker.mustcall.qual.*;
import org.checkerframework.checker.calledmethods.qual.*;

@InheritableMustCall({"closeSocket"}) public class ClientWrapper {
    protected @Owning Socket socket = null;

    public ClientWrapper(String address, int port) throws IOException {
        this.socket = new Socket(address, port);
    }

    @CreatesMustCallFor("this")
    protected void setupConnection(String address, int port) throws IOException {
        // This is the original test case. Before this issue was fixed, an error was issued on the
        // second line.
        if(!this.socket.isClosed()){
            this.socket.close();
        }
        this.socket = new Socket(address, port);
    }

    @EnsuresCalledMethods(value = {"this.socket"}, methods = "close")
    public void closeSocket() throws IOException {
        this.socket.close();
    }

}
