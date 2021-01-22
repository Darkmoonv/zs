package com.zs.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        try {
            test1();
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            System.out.println("结束!");
        }
    }
    public static void test1()throws IOException{
        File f=new File("E:test");
        file(f);
    }
    public static void file(File f) throws IOException {
        File[] files=f.listFiles();
        List<String> list=new ArrayList<String>();
        String path;
        for (File file:files){
            if (file.isFile()){
                path=file.getPath();
                list.add(path);
                continue;
            }
            if (file.isDirectory()){
                for (File file1:files){
                    if (file1.isFile()){
                        path=file1.getPath();
                        list.add(path);
                        break;
                    }
                }
            }
        }
        for (String s:list){
            System.out.println(s);
        }
        }
    }
