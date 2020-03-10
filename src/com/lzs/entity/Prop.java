package com.lzs.entity;
/*
道具
 */
public class Prop {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Prop{" +
                "color='" + color + '\'' +
                '}';
    }
}
