package com.zs.base;

public class Test09 {
    public static void main(String[] args) {
        find();
    }
    public static void find(){
        int i=0;
        int j=0;
        for ( i=1;i<=100;i++){
            for (j=2;j<=i/2;j++){
                if (i%j==0){
                    break;
                }
            }
            if (j>i/2){
                System.out.println(i);
            }
        }
    }
}
