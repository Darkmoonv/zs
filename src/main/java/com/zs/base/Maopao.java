package com.zs.base;

public class Maopao {
    public static void main(String[] args) {
        int[] arry={10,67,21,1,89,0,43,199};
        maoSort(arry);
        for (int i:arry){
            System.out.println(i);
        }
    }
    public static void maoSort(int[] arry){
        int temp;
        for (int i=0;i<arry.length-1;i++){
            for (int j=0;j<arry.length-i-1;j++){
                if (arry[j+1]<arry[j]){
                    temp=arry[j+1];
                    arry[j+1]=arry[j];
                    arry[j]=temp;
                }
            }
        }
    }
}
