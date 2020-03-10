package com.lzs.entity;
/*
客户
 */
public class User extends BaseEntity {
    private String phoneNum;
    private String IDCard;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }
}

