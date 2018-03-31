package com.tarikkilic;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GTUCseCoursesTest {

    @org.junit.jupiter.api.Test
    void getByCode() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //cse101 icin kontrol
        LinkedList<Courses> code;
        code = system.getByCode("CSE 101");
        Courses test = new Courses(1, "CSE 101", "Introduction To Computer Engineering", 8, 3, "3+0+0");
        assertEquals(code.get(0),test);

    }

    @org.junit.jupiter.api.Test
    void listSemesterCode() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList<Courses> list = system.getList();
        LinkedList<Courses> semester;
        semester = system.listSemesterCode(1);
        //1 ve 2. semesterlar icin kontrol
        for(int i = 0;i < 8;i++){
            assertEquals(semester.get(i),list.get(i));
        }

        semester = system.listSemesterCode(2);
        for(int i = 0; i < 8;i++){
            assertEquals(semester.get(i),list.get(i+8));
        }



    }

    @org.junit.jupiter.api.Test
    void getByRange() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList<Courses> list = system.getList();
        LinkedList<Courses> range;
        range = system.getByRange(13,27);
        for(int i = 0; i < 14;i++){
            assertEquals(list.get(i+13),range.get(i));
        }

    }
}