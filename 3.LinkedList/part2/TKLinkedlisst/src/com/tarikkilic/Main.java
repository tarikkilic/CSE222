package com.tarikkilic;

import java.io.IOException;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TKLinkedList<Courses> list = system.getList();

        System.out.println("ITERATOR OLUSTURULDU");
        ListIterator<Courses> iter = list.listIterator();


        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("ADD METODU DOGRU SEKILDE CALISTI");
        System.out.println("--------------------------------------------------------------");


        System.out.println(list.size());
        System.out.println("SIZE METODU DOGRU SEKILDE CALISTI");
        System.out.println("--------------------------------------------------------------");

        Courses course = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course);
        list.showDisabled();
        System.out.println("DISABLE VE SHOWDISABLE METODU DOGRU SEKILDE CALISTI");
        System.out.println("--------------------------------------------------------------");

        System.out.println(list.size());
        System.out.println("SIZE METODU DOGRU SEKILDE CALISTI- 1 EKSILDI");
        System.out.println("--------------------------------------------------------------");

        System.out.println(list.get(3));
        System.out.println("GET METODU DISABLE EDEN ELEMANI DONDURMEDI YERINE NULL BASTIRDI,CALISTI");
        System.out.println("--------------------------------------------------------------");

        list.remove(3);
        System.out.println("REMOVE METODU DISABLE EDEN ELEMANI SILEMEDI,CALISTI");
        System.out.println("--------------------------------------------------------------");




        list.set(3,new Courses(7,"MATH 150","Calculus 5",7,5,"5+0+0"));
        System.out.println("SET METODU DISABLE EDILEN YERE ELEMAN KOYMAADI VE EKRANA 'DISABLED ITEM' YAZISI BASTIRDI");
        System.out.println("--------------------------------------------------------------");

        System.out.println(list.enable(course));
        System.out.println("ENABLE METODU DISABLE OLAN ELEMANI ENABLE YAPTI");
        System.out.println("--------------------------------------------------------------");

        list.showDisabled();
        System.out.println("DISABLE OLAN ITEM KALMADI");
        System.out.println("--------------------------------------------------------------");


        System.out.println(list.get(3));
        System.out.println("DISABLE DAN ENABLE YAPTIGIM ELEMANI ARTIK GET ILE CAGIRALABILIYOR");
        System.out.println("--------------------------------------------------------------");


        Courses course2 = new Courses(1,"MATH 101","Calculus I",7,5,"5+0+0");
        list.disable(course2);
        System.out.println("ITERATORU DENEMEK ICIN TEKRAR DISABLE ETTIM");
        System.out.println("--------------------------------------------------------------");

        System.out.println("ITERATOR OLUSTURULDU");
        ListIterator<Courses> iter2 = list.listIterator();

        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }

        System.out.println("MATH101 YERINE NULL BASTIRDI DISABLE EDILEN ITEMI GOSTERMEDI,CALISTI");
        System.out.println("--------------------------------------------------------------");




    }
}
