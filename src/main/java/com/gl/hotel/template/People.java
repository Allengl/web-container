package com.gl.hotel.template;

public abstract class People {

    public void oneDay() {
        // 人的一天： 起床，洗漱，去学校，上课
        qichuang();
        xishu();
        quxuexiao();
        shangke();
    }

    public void qichuang() {
    }

    public void xishu() {
        System.out.println("洗漱");
    }

    public void quxuexiao() {
        System.out.println("去学校");
    }

    public void shangke() {
    }
}
