package com.zs.base;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Foreach {
    public static void main(String[] args) {
        //getFile(new File("E:"+File.separator+"test"));
        //String line=getString();
        //getWord(line);
        //forWord();
        test01();
    }

    //遍历目录
    public static void getFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f);
            } else {
                getFile(f);
            }
        }
    }

    //查找相同字母组成的单词
    public static void getWord(String word) {
        String[] strs = word.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String line = strs[i];
            for (int j = 1; j < line.length(); j++) {
                Character firstWord = line.charAt(0);
                Character ch = line.charAt(j);
                if (firstWord == ch) {
                    System.out.println(strs[i]);
                } else {
                    break;
                }
            }
        }
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

    public static void forWord() {
        Scanner input1 = new Scanner(System.in);
        String line = input1.nextLine();
        String str = input1.next();
        System.out.println(line);
        System.out.println(str);
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            String lines = String.valueOf(line.charAt(i));
            if (str.equals(lines)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void test01(){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String s =sc.nextLine();
                if(s.length()%8 !=0 )
                    s = s + "00000000";
                while(s.length()>=8){
                    System.out.println(s.substring(0, 8));
                    s = s.substring(8);
                }
            }
        }
    }
