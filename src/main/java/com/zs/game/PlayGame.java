package com.zs.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayGame {
    public static void main(String[] args) {
        sendNumber();
    }
    public static void sendNumber(){
        //定义装扑克牌的集合
        List<String> gameNumbers=new ArrayList<String>();
        //定义扑克牌的颜色及数字数组
        String[] colors={"♥","♠","♣","♦"};
        String[] numbers={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //将扑克牌的颜色和数字进行组合，共有52张牌
        for (int i=0;i<4;i++){
            for (int j=0;j<13;j++){
               String gameNumber=colors[i]+numbers[j];
               gameNumbers.add(gameNumber);
               //输出验证
                System.out.print(gameNumber);
            }
        }
        //将大王和小王加进扑克牌容器中
        gameNumbers.add("大王");
        gameNumbers.add("小王");
        Collections.shuffle(gameNumbers);
        //创建两个人的牌分别用集合装起来
        List<String> gameOne=new ArrayList<String>();
        List<String> gameTwo=new ArrayList<String>();
        for (int i=0;i<54;i++){
            if (i%2==0){
                gameOne.add(gameNumbers.get(i));
            }
            if (i%2==1){
                gameTwo.add(gameNumbers.get(i));
            }
        }
        System.out.println("@@@@@@@@@@@@");
        System.out.println("玩家1"+gameOne);
        System.out.println("&&&&&&&");
        System.out.println("玩家2"+gameTwo);
    }
}
