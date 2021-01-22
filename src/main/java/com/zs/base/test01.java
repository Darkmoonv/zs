package com.zs.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class test01 {
    public static void main(String[] args) {
        Scanner cs=new Scanner(System.in);
        String s=cs.nextLine();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++){
            Character key=s.charAt(i);
            Integer value=map.get(key);
            if (value==null){
                value=1;
                map.put(key,value);
            }else {
                value++;
                map.put(key,value);
            }
        }
        Set<Character> keys=map.keySet();
        for (Character c:keys){
            System.out.println(c+"出现了"+map.get(c));
        }
    }
}
