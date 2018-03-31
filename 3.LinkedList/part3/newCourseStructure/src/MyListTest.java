import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @org.junit.jupiter.api.Test
    void size() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyList list = system.getList();
        //listenin  boyutu 54 olmasi gerekir
        assertEquals(list.size(),54);
        Course course = new Course(3,"MATH 101","Calculus I",7,5,"5+0+0");
        list.remove(course);
        //sildigim icin 53 olmasi gerekir
        assertEquals(list.size(),53);

    }

    @org.junit.jupiter.api.Test
    void add() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyList list = system.getList();
        Course course = new Course(9,"GTU 101","GEBZE TEKNIK I",7,5,"5+0+0");
        assertTrue(list.add(course));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyList list = system.getList();
        Course course = new Course(3,"MATH 101","Calculus I",7,5,"5+0+0");
        //var olani siliyor
        assertTrue(list.remove(course));
        Course course2 = new Course(9,"GTU 101","GEBZE TEKNIK I",7,5,"5+0+0");
        //olmayani silmiyor
        assertFalse(list.remove(course2));

    }
}