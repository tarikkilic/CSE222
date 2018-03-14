package com.tarikkilic;


import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @org.junit.jupiter.api.Test
    void bookRoom() {
        Guest guest = new Guest("ad","soyad","9999");
        Room room = new Room(1,"EMPTY");
        boolean b = guest.bookRoom("deneme.csv", room, guest); //dogru sekilde book ediyor
        assertEquals(b,true);

        //Bu sefer oda dolu iken deneyelim
        Guest guest1 = new Guest("ad1","soyad1","9998");
        Room room1 = new Room(1,"RESERVE");
        boolean c = guest.bookRoom("deneme.csv", room1, guest1); //dogru sekilde return ediyor
        assertEquals(c,false);

        //ayni id li kisiyi eklersek
        Room room2 = new Room(3,"EMPTY");
        boolean d = guest.bookRoom("deneme.csv", room2, guest); //dogru sekilde return ediyor
        assertEquals(d,false);


    }

    @org.junit.jupiter.api.Test
    void cancelRezerv() {
        Guest guest = new Guest("ad","soyad","9999");
        Room room = new Room(1,"EMPTY");
        guest.bookRoom("deneme.csv", room, guest);
        boolean b = guest.cancelRezerv("deneme.csv",guest);//dogru sekilde iptal ediyor.
        assertEquals(b,true);

        //olmayan rezervi iptal etmeye calisirsa
        Guest guest1 = new Guest("ad2","soyad2","8999");
        boolean c = guest.cancelRezerv("deneme.csv",guest1);//dogru sekilde return ediyor..
        assertEquals(c,false);
    }
}