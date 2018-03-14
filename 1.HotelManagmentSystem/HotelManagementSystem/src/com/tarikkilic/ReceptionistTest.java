package com.tarikkilic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceptionistTest {

    @Test
    void checkIn() {
        Guest guest = new Guest("ad","soyad","9999");
        Receptionist recep = new Receptionist("ramo","gvnc","1111");
        Room room = new Room(1,"EMPTY");
        boolean b = recep.checkIn("deneme.csv",room,guest); //Dogru sekilde ekliyor
        assertEquals(b,true);

        //checkin olmus kisiyi tekrar checkin yaparsak
        Room room2 = new Room(3,"EMPTY");
        boolean c = recep.checkIn("deneme.csv",room2,guest); //Dogru sekilde return eder
        assertEquals(c,false);


    }

    @Test
    void checkOut() {
        Guest guest = new Guest("ad","soyad","9999");
        Receptionist recep = new Receptionist("ramo","gvnc","1111");
        Room room = new Room(1,"EMPTY");
        recep.checkIn("deneme.csv",room,guest);
        boolean b = recep.checkOut("deneme.csv",guest); //dogru sekilde cikartiyor
        assertEquals(b,true);

        //checkin yapmamis kisi checkout yapinca
        Guest guest2 = new Guest("ad4","soyad4","9899");
        boolean c = recep.checkOut("deneme.csv",guest2); //dogru sekilde return ediyor
        assertEquals(c,false);
    }

    @Test
    void bookRoom() {
        Guest guest = new Guest("ad","soyad","9999");
        Receptionist recep = new Receptionist("ramo","gvnc","1111");
        Room room = new Room(1,"EMPTY");
        boolean b = recep.bookRoom("deneme.csv",room,guest); //dogru sekilde book ediyor
        assertEquals(b,true);

        //Bu sefer oda dolu iken deneyelim
        Guest guest1 = new Guest("ad1","soyad1","9998");
        Room room1 = new Room(1,"RESERVE");
        boolean c = recep.bookRoom("deneme.csv", room1, guest1); //dogru sekilde return ediyor
        assertEquals(c,false);

        //ayni id li kisiyi eklersek
        Room room2 = new Room(3,"EMPTY");
        boolean d = recep.bookRoom("deneme.csv", room2, guest); //dogru sekilde return ediyor
        assertEquals(d,false);
    }
}