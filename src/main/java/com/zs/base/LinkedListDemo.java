package com.zs.base;

import com.zs.domain.User;

import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        SingleList singleList=new SingleList();
        UserNode userNode1=new UserNode(1,"tom");
        UserNode userNode2=new UserNode(2,"rose");
        UserNode userNode3=new UserNode(3,"yueke");
        singleList.myAdd(userNode1);
        singleList.myAdd(userNode2);
        singleList.myAdd(userNode3);
        System.out.println(singleList.count());
        singleList.show();
        System.out.println("-----------");
        singleList.replace(new UserNode(2,"lihua"));
        //System.out.println(singleList.findUserNode(2)+"--");
        System.out.println(singleList.count());
        /*singleList.addSort(userNode1);
        singleList.addSort(userNode2);
        singleList.addSort(userNode3);*/
        singleList.show();
        /*SingleList singleList=new SingleList();
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("p(add)");
            char key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    singleList.show();
                    break;
                case 'p':
                    int no=scanner.nextInt();
                    String name=scanner.next();
                    singleList.addSort(new UserNode(no,name));
                    break;
                case 'e':
                   flag=false;
                   break;
                default:
                    break;
            }
        }*/
    }
}
class SingleList{
    private UserNode head=new UserNode(0,"");//创建一个头节点（一般不能发生变化）
    public void add(UserNode userNode){
        UserNode temp=head;//创建一个头节点的临时变量
        while (true){
            if (temp.next==null){//如果是最后一个元素
                break;
            }
            temp=temp.next;//如果不是最后一个元素，将他的next赋给temp
        }
        temp.next=userNode;
    }
    public void myAdd(UserNode userNode){
        UserNode temp=head;
        while (true){
            if (temp.next==null){
                temp.next=userNode;
                break;
            }
            temp=temp.next;
        }
    }
    public void replace(UserNode newUserNode){
        UserNode temp=head;
        if (temp==null){
            return;
        }
        while (temp.next!=null){
            if (temp.no==newUserNode.no){
                temp.name=newUserNode.name;
                break;
            }else {
                temp=temp.next;
            }
        }
    }
    public void delete(int no){
        UserNode temp=head;
        if (temp.next==null){
            return;
        }
        while (temp.next!=null){
            if (temp.next.no==no){
                //删除
                temp.next=temp.next.next;
                break;
            }else {
                temp=temp.next;
            }
        }
    }
    public void addSort(UserNode userNode){
        //因为是单链表，要找添加位置的前一个位置
        UserNode temp=head;
        boolean flag=false;//判断元素是否已经存在
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no>userNode.no){//如果新添加的元素的指针小于该位置的指针可以添加
                break;
            }else if (temp.next.no==userNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("该元素以存在！");
        }else {
            userNode.next=temp.next;
            temp.next=userNode;
        }
    }
    //显示链表
    public void show(){
        UserNode temp=head;
        if (temp.next==null){//判断链表是否为空
            return;
        }
        while (temp.next!=null){//只要不为空就将里面的数据打印出来，并将节点后移
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //链表有效数据的个数
    public int count(){
        int count=0;
        UserNode temp=head;
        while (true){
            if (temp.next!=null){
                count++;
                temp=temp.next;
            }else {
                break;
            }
        }
        return count;
    }
    //查找单链表中倒数第k个节点




}
class UserNode{
    public int no;//用户编号
    public String name;
    public UserNode next;//指向下一个节点
    public UserNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "UserNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
