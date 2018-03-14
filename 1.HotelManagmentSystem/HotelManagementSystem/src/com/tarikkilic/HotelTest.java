package com.tarikkilic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HotelTest {

    @Test
    void logIn() {
        Hotel hotel = new Hotel("GTU HOTEL \n");
        Receptionist recep = null;
        User usr = hotel.logIn("0000");
        recep = (Receptionist) usr;
        assertEquals(recep,new Receptionist("Tarık","KILIÇ","0000")); //Hotel constructorının içinde init edilen kullanıcılar karsilastirdim.

        //Her bir guest icin tek tek kontrol ettim
        Guest guest1 = null;
        User usr1 = hotel.logIn("1234");
        guest1 = (Guest) usr1;
        assertEquals(guest1,new Guest("Celal Can","KAYA","1234"));

        Guest guest2 = null;
        User usr2 = hotel.logIn("4321");
        guest2 = (Guest) usr2;
        assertEquals(guest2,new Guest("Ramazan","GUVENC","4321"));

        Guest guest3 = null;
        User usr3 = hotel.logIn("2564");
        guest3 = (Guest) usr3;
        assertEquals(guest3,new Guest("Serkan","SORMAN","2564"));

        Guest guest4 = null;
        User usr4 = hotel.logIn("2222");
        guest4 = (Guest) usr4;
        assertEquals(guest4,new Guest("Akin","CAM","2222"));

        //olumsuz durum icin kontrol

        User usr5 = hotel.logIn("12345");
        guest4 = (Guest) usr5;
        assertNotEquals(guest4,new Guest("Akin","CAM","2222"));

    }

}