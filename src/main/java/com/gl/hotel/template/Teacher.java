package com.gl.hotel.template;

public class Teacher extends People{
    @Override
    public void qichuang() {
        System.out.println("老师：老婆叫醒，起床");
    }

    @Override
    public void xishu() {
        System.out.println("老师：刷牙洗脸");
    }

    @Override
    public void quxuexiao() {
        System.out.println("老师：做地铁去学校");
    }

    @Override
    public void shangke() {
        System.out.println("老师：上课传授知识");
    }
}
