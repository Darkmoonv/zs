package com.zs.base;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TongXin {
    public static void main(String[] args) throws Exception{
        ServerSocket server=new ServerSocket(9999);
        Socket client=server.accept();//监听客户端
        InetAddress address=client.getInetAddress();
        System.out.println("连接服务器的ip为:"+address);
        Scanner sc=new Scanner(client.getInputStream());
        PrintStream out=new PrintStream(client.getOutputStream());
        boolean flag=true;
        while (flag){
            if (sc.hasNext()){
                String line=sc.nextLine().trim();
                if ("exit".equals(line)){
                    out.println("over!");
                    flag=false;
                }else {
                    out.println(line);
                    System.out.println(line);
                }
            }
        }
        sc.close();
        out.close();
        client.close();
        server.close();
    }
}
