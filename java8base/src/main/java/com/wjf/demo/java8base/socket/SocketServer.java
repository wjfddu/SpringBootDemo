package com.wjf.demo.java8base.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            System.out.println("等待连接...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了...");
            handler(clientSocket);
        }
    }

    public static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read...");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕...");
        if(read != -1){
            String data = new String(bytes, 0, read);
            System.out.println("接收到客户端的数据：" + data);
        }
    }

}
