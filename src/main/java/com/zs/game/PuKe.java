package com.zs.game;

public class PuKe {
    private String color;
    private String number;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PuKe{" +
                "color='" + color + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
