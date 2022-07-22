package com.chen;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 陈宇超
 * 14:15
 */
public class WebTest {
    @Test
    public void webTest01() throws Exception{
        // 启动一个服务器
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        // 获得输入流
        InputStream inputStream = accept.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1){
            System.out.print(new String(buf,0,len));
        }
        inputStream.close();
        accept.close();
    }
}
