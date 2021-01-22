package com.zs.base;

import java.util.Scanner;

public class CircleArry {
    public static void main(String[] args) {
        CircleTest test=new CircleTest(4);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("p(save)");
            System.out.println("g(get)");
            System.out.println("s(show)");
            System.out.println("e(exit)");
            key=scanner.next().charAt(0);
            switch (key){
                case 'p':
                    System.out.println("请输入一个数");
                    int data=scanner.nextInt();
                    test.saveData(data);
                    break;
                case 'g':
                    try {
                        int data1=test.getData();
                        System.out.println("取出都数据是"+data1);
                    }catch (NullPointerException n){
                        n.printStackTrace();
                    }
                    break;
                case 's':
                    test.show();
                    break;
                case 'e':
                    flag=false;
                    break;
                default:
                    System.out.println("您输入指令有误");
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}
class CircleTest{
    //环形队列 我空了一个元素，队列里面不能放满元素
    private int MaxIndex;
    private int head;//指向第一个元素
    private int end;//指向最后一个元素的后一个元素
    private int[] circleArry;
    public CircleTest(int index){
        MaxIndex=index;
        head=0;
        end=0;
        circleArry=new int[MaxIndex];
    }
    //判断环形数组是否为空
    public boolean isEmpty(){
        return head==end;
    }
    //判断环形数组是否满
    public boolean isFull(){
        //因为环形队列的最上面空出一个数据位，end的含义为指向最后一个元素的后一个位置
        return (end+1)%MaxIndex==head;
    }
    public void saveData(int n){
        if (isFull()){
            return;
        }
        circleArry[end]=n;
        end=(end+1)%MaxIndex;
    }
    public int getData(){
        if (isEmpty()){
            throw new NullPointerException("环形队列为空！");
        }
        int value=circleArry[head];
        head=(head+1)%MaxIndex;
        return value;
    }
    public void show(){
        if (isEmpty()){
            throw new NullPointerException("队列为空！");
        }
        for (int i=head;i<head+count();i++){
            System.out.printf("%d\t%d\t",i%MaxIndex,circleArry[i%MaxIndex]);
        }
    }
    public int count(){
        return (end+MaxIndex-head)%MaxIndex;
    }
}