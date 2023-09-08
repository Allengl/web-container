package com.gl.hotel.template;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleTest {

    @Test
    public void testOneDay() {
        People student = new Student();
        System.out.println("学生的一天：");
        student.oneDay();
        People teacher = new Teacher();
        System.out.println("老师的一天：");
        teacher.oneDay();
    }

}