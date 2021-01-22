package com.zs.base;

import java.util.Scanner;

public class duilie {
    public static void main(String[] args) {
        Arry arryQuery= new Arry(4);
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
                    arryQuery.saveData(data);
                    break;
                case 'g':
                    try {
                        int data1=arryQuery.getData();
                        System.out.println("取出都数据是"+data1);
                    }catch (NullPointerException n){
                        n.printStackTrace();
                    }
                    break;
                case 's':
                    arryQuery.show();
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
    class Arry{
        private int MaxIndex;
        private int head;
        private int end;
        private int[] arry;
        public Arry(int index){
            MaxIndex=index;
            head=-1;
            end=-1;
            arry=new int[index] ;
        }
        //判断队列是否满
        public boolean isFull(){
            return end==MaxIndex-1;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return head==end;
        }
        //像队列中存放数据
        public void saveData(int n){
            if (isFull()){
                return;
            }
            end++;
            arry[end]=n;
        }
        //取出数据
        public int getData(){
            if (isEmpty()){
                throw new NullPointerException("队列为空，没有数据可取！");
            }
            head++;
            return arry[head];
        }
        //显示队列的所有数据
        public void show(){
            if (isEmpty()){
                return;
            }
            for(int data:arry){
                System.out.printf("%d\t",data);
            }
        }
    }

