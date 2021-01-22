package com.zs.base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class xishu {
    public static void main(String[] args) throws IOException{
        System.out.println(replaceSpace(new StringBuffer("tom is")));
    }
    //稀疏数组来完成一个五子棋存盘和读盘操作
    public static void sparseArry()throws IOException {
        //0表示没有数据，1表示红方的子，2表示蓝方的子
        //创建原始数组
        int[][] chess1=new int[11][11];
        //向数组赋值
        chess1[1][2]=1;
        chess1[2][3]=2;
        //输出原始二维数组
        for(int[] row:chess1){
            for (int data:row){
                System.out.print(data);
            }
            System.out.println();
        }
        int sum=0;//原始二维数组的有效个数
        for (int i=0;i<chess1.length;i++){
            for (int j=0;j<chess1.length;j++){
                int data=chess1[i][j];
                if (data!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建对应的稀疏数组
        int sparse[][]=new int[sum+1][3];
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;
        int count=0;
        for (int i=0;i<chess1.length;i++){
            for (int j=0;j<chess1.length;j++){
                int data=chess1[i][j];
                if (data!=0){
                    count++;
                    //稀疏数组的第一列是有效数据在第几行
                    sparse[count][0]=i;
                    //稀疏数组的第二列是有效数据在第几列
                    sparse[count][1]=j;
                    //稀疏数组的第三类是数据
                    sparse[count][2]=data;
                }
            }
        }
        File file=new File("E:"+File.separator+"test"+File.separator+"a.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter writer=new FileWriter(file);
        for (int[] row:sparse){
            for (int data:row){
                writer.write(data);
                writer.flush();
                System.out.printf("%d\t",data);//以制表符形式输出
                /*11	11	2
                1	2	1
                2	3	2*/
            }
            System.out.println();
        }
        //稀疏数组转化为原始二维数组
        FileReader reader=new FileReader(file);
        List<Integer> list=new ArrayList<Integer>();
        int line;
        while ((line=reader.read())!=-1){
            list.add(line);
        }
        int[][] chess2=new int[sparse[0][0]][sparse[0][1]];
        for (int i=1;i<sparse.length;i++){
            chess2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        for (int[] row:chess2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
    public static String replaceSpace(StringBuffer str) {
        int count=0;
      for (int i=0;i<str.length();i++){
          if (str.charAt(i)==' '){
              count++;
          }
      }
      int index=str.length()+count*2;
      for (int i=0;i<index-1;i++){
          if (str.charAt(i)==' '){
              str.setCharAt(i,'%');
              str.setCharAt(i+1,'2');
              str.setCharAt(i+2,'0');
          }
      }
      return str.toString();
    }

}
