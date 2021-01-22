package com.zs.base;

import java.math.BigInteger;
import java.util.Scanner;

public class DemoString {
    public static void main(String[] args) {
        //string01();
        numTo("a");
    }
    public static void string01(){
        Scanner sc=new Scanner(System.in);
        Integer in=sc.nextInt();
        StringBuffer sf=new StringBuffer(String.valueOf(in));
        sf.reverse();
        System.out.println(sf);
    }
    public static void numTo(String s){
        String line=new BigInteger(s,16).toString(10);
        System.out.println(line);
    }
}
