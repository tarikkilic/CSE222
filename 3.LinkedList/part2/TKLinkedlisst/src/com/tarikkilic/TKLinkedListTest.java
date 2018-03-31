package com.tarikkilic;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TKLinkedListTest {

    @org.junit.jupiter.api.Test
    void disable() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();

        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        assertEquals(list.disable(course),course);
    }

    @org.junit.jupiter.api.Test
    void enable() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();
        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        //enable ettigim ile ayni mi
        assertEquals(list.enable(course),course);
        //artik enable degil esit olmamasi gerek
        assertNotEquals(list.enable(course),course);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();
        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        //disable ettigim yerin null olmasi gerekir
        assertEquals(list.remove(3),null);
    }

    @org.junit.jupiter.api.Test
    void size() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();
        //listenin  boyutu 54 olmasi gerekir
        assertEquals(list.size(),54);
        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        //disabl ettigim icin 53 olmasi gerekir
        assertEquals(list.size(),53);

    }

    @org.junit.jupiter.api.Test
    void set() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();
        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        Courses course1 = new Courses(1,"CSE 101","INT 10",34,8,"5+0+0");
        //disable ettigim yere null dondurmesi gerek
        assertEquals(list.set(3,course1),null);

    }

    @org.junit.jupiter.api.Test
    void get() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TKLinkedList<Courses> list = system.getList();
        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        //disable ettigim yerin null olmasi gerekir
        assertEquals(list.get(3),null);
    }
}