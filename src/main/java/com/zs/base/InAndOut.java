package com.zs.base;

import java.io.*;
/*
@author zhangshuai

 */
public class InAndOut {
    public static void main(String[] args) throws IOException{
        File path=new File("E:\\test\\a.txt");
        File copyPath=new File("E:\\test\\ceshi01.txt");
    }
    public static void copy(File path){
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            byte[] bytes=new byte[1024*10];
            int len;
            fileInputStream=new FileInputStream(path);
            fileOutputStream=new FileOutputStream("E:\\test\\ceshi01.txt");
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException i){
                i.printStackTrace();
            }
            try {
                fileOutputStream.close();
            }catch (IOException i){
                i.printStackTrace();
            }
        }
    }

}
