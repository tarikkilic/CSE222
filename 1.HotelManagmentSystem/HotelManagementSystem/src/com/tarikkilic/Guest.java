package com.tarikkilic;

/**
 * Guest hakkinda bilgileri tutar
 */
public class Guest extends User{

    private String status;

    /**
     *
     * @param n name initliaze eder
     * @param s surname initliaze eder
     * @param id userid initliaze eder
     */
    public Guest(String n,String s,String id){
        super(n,s,id);
        status = "EMPTY";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    /**
     *
     * @param status status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }


}
