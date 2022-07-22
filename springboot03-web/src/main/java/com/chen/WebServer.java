package com.chen;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 陈宇超
 * 15:02
 */
public class WebServer {
    public static void main(String[] args) throws Exception{
        // 创建一个服务器监听在8888端口
        ServerSocket serverSocket = new ServerSocket(8989);
        Socket server = serverSocket.accept();
        OutputStream outputStream = server.getOutputStream();
        // 按照http协议的格式封装一个报文
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Length: 39\r\n" +
                "Content-Type: text/html;charset=UTF-8\r\n\r\n" +
                "<h1 style=\"color:red\">hello server!<h1>";
        // 将报文写出给浏览器
        outputStream.write(response.getBytes());
        outputStream.flush();
        // 这个输出流不要着急关，因为突然的关闭会导致浏览器和服务器的连接断开
    }
}
