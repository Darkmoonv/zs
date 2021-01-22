package com.zs.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final BufferedReader INPUT=new BufferedReader(new InputStreamReader(System.in));
    public static String getString(String message)throws Exception{
        System.out.println(message);
        String str=INPUT.readLine();
        return str;
    }

    public static void main(String[] args) throws Exception{
        Socket client=new Socket("localhost",9999);
        Scanner scanner=new Scanner(client.getInputStream());
        PrintStream out=new PrintStream(client.getOutputStream());
        boolean flag=true;
        while (flag){
            String line=getString("请输入内容:").trim();
            out.println(line);
            if (scanner.hasNext()){
                System.out.println(scanner.next());
            }
            if ("exit".equals(line)){
                flag=false;
            }
        }
        scanner.close();
        out.close();
        client.close();
    }
}
