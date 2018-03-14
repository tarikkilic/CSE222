package com.tarikkilic;

public interface UserInterface {

    /**
     *
     * @return name
     */
    String getName();

    /**
     *
     * @return surname
     */
    String getSurname();

    /**
     *
     * @return userid
     */
    String getUserId();

    /**
     *
     * @param n name to set
     */
    void setName(String n);

    /**
     *
     * @param s surname to set
     */
    void setSurname(String s);

    /**
     *
     * @param id userid to set
     */
    void setUserId(String id);

    /**
     * rezerv yapanlarin csv dosyasina kaydedilmesine yarar
     *
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param room istenilen odanin objesi
     * @param guest rezerv yapilacak kisinin objesi
     * @see Room
     * @see Guest
     */
    boolean bookRoom(String filename,Room room,Guest guest);

    /**
     *
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param guest rezerv iptal edilecek kisinin objesi
     */
    boolean cancelRezerv(String filename,Guest guest);


}
