package com.gl.hotel.template;

public class Student extends People {

    @Override
    public void qichuang() {
        System.out.println("爸爸妈妈叫醒，起床");
    }

    @Override
    public void xishu() {
        System.out.println("学生：洗漱");
    }

    @Override
    public void quxuexiao() {
        System.out.println("学生：坐校车去学校");
    }

    @Override
    public void shangke() {
        System.out.println("学生：上课学习知识");
    }

}
