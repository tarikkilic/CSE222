package com.tarikkilic;

public class Main {
    private static final String filename = "hotel.csv";

    public static void main(String[] args) {

        System.out.println("-----OTEL OLUSTURULDU VE ISIM VERILDI--------");
        Hotel hotel = new Hotel("GTU HOTEL \n");

        System.out.println("----HOSGELDIN MESAJI---------");
        hotel.welcomeMessage();

        System.out.println("----------KULLANACAGIM REFERANSLAR OLUSTURULDU------------");
        Receptionist recep = null;
        Guest guest1 = null;
        Guest guest2 = null;
        Guest guest3 = null;
        Guest guest4 = null;


        System.out.println("----------LOGIN ISLEMLERI YAPILDI---------");
        User usr = hotel.logIn("0000");
        if(usr instanceof Receptionist){
            recep = (Receptionist) usr;
            System.out.println("RECEPTIONIST LOGGED");
        }
        usr = hotel.logIn("1234");
        if(usr instanceof  Guest){
            guest1 = (Guest) usr;
            System.out.println("GUEST LOGGED");
        }

        usr = hotel.logIn("4321");
        if(usr instanceof  Guest){
            guest2 = (Guest) usr;
            System.out.println("GUEST LOGGED");
        }

        usr = hotel.logIn("2564");
        if(usr instanceof  Guest){
            guest3 = (Guest) usr;
            System.out.println("GUEST LOGGED");
        }
        usr = hotel.logIn("2222");
        if(usr instanceof  Guest){
            guest4 = (Guest) usr;
            System.out.println("GUEST LOGGED");
        }

        System.out.println("---------ODALAR OLUSTURULDU---------");
        Room room1 = new Room(1,"EMPTY");
        hotel.addRoom(room1);
        Room room2 = new Room(2,"EMPTY");
        hotel.addRoom(room2);
        Room room3 = new Room(3,"EMPTY");
        hotel.addRoom(room3);
        Room room4 = new Room(4,"EMPTY");
        hotel.addRoom(room4);
        Room room5 = new Room(5,"EMPTY");
        hotel.addRoom(room5);
        Room room6 = new Room(6,"EMPTY");
        hotel.addRoom(room6);
        Room room7 = new Room(7,"EMPTY");
        hotel.addRoom(room7);
        Room room8 = new Room(8,"EMPTY");
        hotel.addRoom(room8);

        System.out.println("-------ODA DURUMU SORULDU---------");
        hotel.isEmpty(5);

        System.out.println("----------- 1. MUSTERI REZERV YAPTIRDI(KENDISI)-------");
        guest1.bookRoom(filename,room5,guest1);

        System.out.println("-------ODA DURUMU SORULDU---------");
        hotel.isEmpty(1);

        System.out.println("----------- 2. MUSTERI KAYIT YAPTIRDI-------");
        recep.checkIn(filename,room1,guest2);

        System.out.println("-------ODA DURUMU SORULDU---------");
        hotel.isEmpty(4);

        System.out.println("----------- 3. MUSTERI REZERV YAPTIRDI(RECEP TARAFINDAN))-------");
        recep.bookRoom(filename,room4,guest3);

        System.out.println("-------ODA DURUMU SORULDU---------");
        hotel.isEmpty(5);
        System.out.println("-------ODA DURUMU TEKRAR SORULDU---------");
        hotel.isEmpty(7);

        System.out.println("----------- 4. MUSTERI REZERV YAPTIRDI(KENDISI)-------");
        guest4.bookRoom(filename,room7,guest4);


        System.out.println("----------- 1. MUSTERI REZERVLI YERINE KAYIT YAPTIRDI-------");
        recep.checkIn(filename,room5,guest1);

        System.out.println("----------- 2. MUSTERI CIKIS YAPTI-------");
        recep.checkOut(filename,guest2);

        System.out.println("----------- 3. MUSTERI REZERV IPTAL ETTIRDI(KENDISI TARAFINDAN)-------");
        guest3.cancelRezerv(filename,guest3);

        System.out.println("----------- 4. MUSTERI REZERV IPTAL ETTIRDI(RECEP TARAFINDAN)-------");
        recep.cancelRezerv(filename,guest4);

    }
}
