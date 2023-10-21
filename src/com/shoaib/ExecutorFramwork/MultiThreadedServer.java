package com.shoaib.ExecutorFramwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.shoaib.ExecutorFramwork.SingleThreadedServer.serveRequest;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket connection = serverSocket.accept();
            Thread thread = new Thread(() -> serveRequest(connection));
            thread.start();
        }
    }
}
