package com.lzs.entity;
/*
事务
 */
public class Food extends BaseEntity{
    private String flavour;//味道

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Food{" +
                "flavour='" + flavour + '\'' +
                '}';
    }
}
