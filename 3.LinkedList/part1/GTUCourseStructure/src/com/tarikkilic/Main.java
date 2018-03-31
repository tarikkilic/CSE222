package com.tarikkilic;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        GTUCseCourses system = null;

        try {
            system = new GTUCseCourses();
            LinkedList<Courses> code;
            code = system.getByCode("XXX XXX");
            Iterator<Courses> iter = code.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
            System.out.println("getByCode METODU DOGRU CALISTI");
            System.out.println("--------------------------------------");

            LinkedList<Courses> semester;
            semester = system.listSemesterCode(3);
            Iterator<Courses> iterSemester = semester.iterator();
            while(iterSemester.hasNext()){
                System.out.println(iterSemester.next());
            }
            System.out.println("listSemesterCode METODU DOGRU CALISTI");
            System.out.println("--------------------------------------");

            LinkedList<Courses> range;
            range = system.getByRange(13,27);
            Iterator<Courses> iterRange = range.iterator();
            while(iterRange.hasNext()){
                System.out.println(iterRange.next());
            }
            System.out.println("getByRange METODU DOGRU CALISTI");
            System.out.println("--------------------------------------");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }



    }
}
