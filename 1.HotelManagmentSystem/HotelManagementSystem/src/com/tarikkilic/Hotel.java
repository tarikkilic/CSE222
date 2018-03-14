package com.tarikkilic;
import java.util.ArrayList;
import java.util.List;

/**
 * Otelin sahip oldugu ozellıklerı tutar
 */
public class Hotel {
    private String name;
    private List<Room> rooms = new ArrayList<Room>();
    private List<User> users = new ArrayList<User>();

    /**
     * kullanicilar arrayliste bilgileri atilmistir {@link #addUser(User)} fonk. ile
     *
     * @param n otel ismini init eder
     */
    public Hotel(String n){
        this.name = n;
        addUser(new Guest("Celal Can","KAYA","1234"));
        addUser(new Guest("Ramazan","GUVENC","4321"));
        addUser(new Guest("Serkan","SORMAN","2564"));
        addUser(new Guest("Akin","CAM","2222"));
        addUser(new Receptionist("Tarık","KILIÇ","0000"));

    }

    /**
     * hosgeldin mesaji ekrana bastirir.
     */
    public void welcomeMessage(){
        System.out.println("Welcome to " + name);
    }

    /**
     *
     * @return otel ismi
     */
    public String getName(){
        return name;
    }

    /**
     * room veritabanina kaydedilir.
     * @param room veritabanina eklenecek oda
     */
    public boolean addRoom(Room room){

        if(rooms.add(room))
            return true;

        return false;
    }

    /**
     * user veritabinana kaydedilir
     *
     * @param user oteli veritabanina kaydedilecek kisi
     */
    public boolean addUser(User user){

        if(users.add(user))
            return true;

        return false;
    }


    /**
     *
     * @param id kullanici id,veritabanina bulmak icin gerekli.
     * @return recep. ise receptionist guest ise guest return eder.
     */
    public User logIn(String id){
        for(User usr : users){
            if(usr.getUserId().equals(id)){
                if(usr instanceof Receptionist){
                    Receptionist rcp = (Receptionist) usr;
                    System.out.println("GIRIS YAPTI: " + rcp);
                    return rcp;
                }
                else if(usr instanceof  Guest){
                    Guest gst = (Guest) usr;
                    System.out.println("GIRIS YAPTI: " + gst);
                    return gst;
                }
            }
        }

        return null;
    }

    /**
     * odanin bos olup olmadigini gösterir
     * @param no oda numarasi
     */
    public boolean isEmpty(int no){
        for(Room room : rooms){
            if(room.getrNo() == no)
                System.out.println("Room " + room.getrNo() + " is" + room.getStatus());
            return true;
        }
        return false;
    }

}
