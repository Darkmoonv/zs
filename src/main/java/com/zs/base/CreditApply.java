package com.zs.base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreditApply {
    private String Serialno;
    private String Name;
    private String VouchType;
    private double Sum;

    public CreditApply(String serialno, String name, String vouchType, double sum) {
        Serialno = serialno;
        Name = name;
        VouchType = vouchType;
        Sum = sum;
    }

    public String getSerialno() {
        return Serialno;
    }

    public void setSerialno(String serialno) {
        Serialno = serialno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVouchType() {
        return VouchType;
    }

    public void setVouchType(String vouchType) {
        VouchType = vouchType;
    }

    public double getSum() {
        return Sum;
    }

    public void setSum(double sum) {
        Sum = sum;
    }

    @Override
    public String toString() {
        return "CreditApply{" +
                "Serialno='" + Serialno + '\'' +
                ", Name='" + Name + '\'' +
                ", VouchType='" + VouchType + '\'' +
                ", Sum=" + Sum +
                '}';
    }

    public static void main(String[] args) {
        List<CreditApply> list=new ArrayList<CreditApply>();
        CreditApply c1=new CreditApply("1001","张三","抵押",100000.5);
        CreditApply c2=new CreditApply("1002","李四","质押",50000);
        CreditApply c3=new CreditApply("1003","王五","质押",30000);
        CreditApply c4=new CreditApply("1004","赵六","抵押",60000.51);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        BufferedWriter bf=null;
        try {
            bf=new BufferedWriter(new FileWriter("E://test//a.txt"));
            for (CreditApply c:list){
                bf.write(c.toString());
                bf.flush();
            }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
           try {
               bf.close();
           } catch (IOException i){
               i.printStackTrace();
           }
        }
    }
}
