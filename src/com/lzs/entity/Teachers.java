package com.lzs.entity;
/*
教师类
 */
public class Teachers {
    private  String Sex;
    private  String Subject;//科目
    private  String speech;//言论

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}

