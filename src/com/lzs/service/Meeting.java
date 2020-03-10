package com.lzs.service;

import com.lzs.entity.*;

/*
总裁班培训会议流程
 */
public class Meeting {
    private Integer AttendNums;//参会人数
    private Integer size;//会议规模
    private String level;//
    private Food food;
    private Medicines medicines;
    private Prop prop;//道具
    private Staff staff; //员工
    private Stationery stationery;//文具
    private Teachers teachers;
    private User user;


    public static void main(String[] args) {

        Prop prop1 = new Prop();
        Teachers teachers = new Teachers();
        //会议厅（）
        Boolean meet = meet(teachers);

        //餐厅（）
        eat(meet);
    }

    /*-----餐厅调度----------*/
    private static void eat(boolean meet) {
        String time ="12";
        //判断时间&&课程状态
        if(time.equals("12")&&meet){
            //1.午餐-----（12:00）
            System.out.println("午餐时间到了");
        }
        if(!time.equals("12")&&meet){
            //2.晚餐-----（18:00）
            System.out.println("晚餐时间到了");
        }




    }

    /*-----会议厅调度-------*/
    private static Boolean meet(Teachers teachers) {
        teachers.setSpeech("课程运行状态");
        if(teachers.getSpeech().equals("课程运行状态")){
            //入场-----（身份验证）
            boolean check = enterAndCheck();
            //听课------（文具准备）
            Listen(check);
            //茶歇--------（食物准备）
            Rest();
            //游戏----------（道具准备）
            Game();

            return true;

        }else return false;

    }

    private static boolean enterAndCheck() {
        System.out.println("检查身份信息");
        User user = new User();
        if(user.equals("有预定"))return true;
        else return false;
    }

    private static void Listen(boolean check) {
        if(check) {
            System.out.println(new Stationery());
        }else  System.out.println("不好意思,您需要预约才能听课");
    }

    private static void Rest() {
        System.out.println(new Food()+"休息时间");
    }

    private static void Game() {
        System.out.println(new Prop()+"游戏时间");
    }
}
