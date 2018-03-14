package com.tarikkilic;

/**
 * oda hakkina bilgiler barindirir
 */
public class Room {
    int rNo;
    String status;

    /**
     *
     * @param no oda numarasini init eder
     * @param s durumunu init eder
     */
    public Room(int no,String s){
        this.rNo = no;
        this.status = s;

    }

    /**
     *
     * @return room number
     */
    public int getrNo(){
        return this.rNo;
    }

    /**
     *
     * @return odanin doluluk durumu
     */
    public String getStatus(){
        return status;
    }

    /**
     *
     * @param s durumu set eder
     */
    public void changeStatus(String s){
        this.status = s;
    }

}
