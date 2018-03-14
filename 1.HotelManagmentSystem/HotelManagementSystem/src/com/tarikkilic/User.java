package com.tarikkilic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * User hakkında verileri tutar
 * dosyaya yazma ve dosyadan okuma metodlari vardir.
 */
public abstract class User implements UserInterface{

     // Bu data field kullanımlarını stackoverflowdan gordum hosuma gıttı bende boyle kullandım.

    protected static final String COMMA_DELIMITER = ";";
    protected static final String NEW_LINE_SEPARATOR = "\n";
    private String name;
    private String surname;
    private String UserId;

    public static int NUMBER = 0;

    /**
     *
     * @param n name initiliaze eder
     * @param s surname initiliaze eder
     * @param id id initiliaze eder
     */
    public User(String n,String s,String id){
        this.name = n;
        this.surname = s;
        this.UserId = id;
    }


    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(!(other instanceof User))
            return false;
        User usr = (User) other;
        if(getUserId().equals(usr.getUserId()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return   getName() + "-" + getSurname() + "-" + getUserId();
    }

    /**
     *
     * @return name
     */
    public String getName(){
        return name;
    }


    /**
     *
     * @return surname
     */
    public String getSurname(){
        return surname;
    }

    /**
     *
     * @return userid
     */
    public String getUserId(){
        return UserId;
    }

    /**
     *
     * @param n name to set
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     *
     * @param s surname to set
     */

    public void setSurname(String s) {
        this.surname = s;
    }

    /**
     *
     * @param id userid to set
     */
    public void setUserId(String id) {
        UserId = id;
    }


    /**
     * ilk once gelen guest objesinin kendisi olup olmadigini kontrol eder.
     * sonra daha onceden kayit veya rezerv yapip yapmadigini kontrol eder.
     * ardindan guest in bilgilerini dosyaya yazar.
     *
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param room istenilen odanin objesi
     * @param guest rezerv yapilacak kisinin objesi
     * @see Room
     * @see Guest
     */
    public boolean bookRoom(String filename,Room room,Guest guest){
        NUMBER++;
        boolean append = false;
        BufferedWriter fileWriter = null;
        if(this != guest){
            System.out.println("SADECE KENDINIZI KAYIT EDEBILIRSINIZ");
            return false;
        }
        else if(!(guest.getStatus().equals("EMPTY"))  || !(room.getStatus().equals("EMPTY"))){
            System.out.println("ZATEN KAYITLISINIZ");
            return false;
        }

        else{
            try{
                if(NUMBER-1 != 0)
                    append = true;
                fileWriter = new BufferedWriter(new FileWriter(filename,append));
                fileWriter.write(valueOf(room.getrNo()));
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(guest.getName());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(guest.getSurname());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(valueOf(guest.getUserId()));
                fileWriter.write(COMMA_DELIMITER);
                room.changeStatus("RESERVE");
                guest.setStatus("RESERVE");
                fileWriter.write(valueOf(room.getStatus()));
                fileWriter.write(NEW_LINE_SEPARATOR);
                System.out.println("REZERVE EDILDI. ODA NO: " + room.getrNo() + " KISI: " + guest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * BU METODA STACKOVERFLOWDAN YARDIM ALINARAK YAZILMISTIR
     * eger bu fonksiyonu guest kullaniyor ise ilk once kendisi olup olmadigini kontrol eder.
     * kendisi ise ardindan dosyayi satir satir okuyup kaydi silicek musteri haric bilgiler arrayliste atilir.
     * her arrayliste atildiginde {@link com.tarikkilic.User#writeCSV(String, String, boolean)} fonksiyonu cagirilip dosyaya sifirdan yazilir.
     *
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param guest rezervi iptal edilecek kisinin objesi
     * @see Room
     * @see Guest
     */
    public boolean cancelRezerv(String filename,Guest guest){
        boolean res = false;
        if(this != guest){
            System.out.println("SADECE KENDI HESABINIZA ERISEBILIRSINIZ");
            return res;
        }
        else{
            NUMBER--;
            BufferedReader br = null;
            String line = "";
            List<String> lines = new ArrayList<String>();
            boolean isSame = false;
            try {
                br = new BufferedReader(new FileReader(filename));
                while ((line = br.readLine()) != null) {
                    isSame = false;
                    String[] object = line.split(COMMA_DELIMITER);
                    for (String l : object) {
                        if (l.equals(getUserId())) {
                            isSame = true;
                            res = true;
                        }
                    }
                    if (!isSame) {
                        lines.add(line);
                    }
                }

                boolean append = false;
                for (String newL : lines) {
                    writeCSV(newL,filename,append);
                    append = true;
                }
                br.close();


            }
            catch (Exception e) {
                System.out.println("Error in CsvFileReader !!!");
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    System.out.println("REZERV IPTAL EDILDI " + "KISI " + toString());
                } catch (IOException e) {
                    System.out.println("Error while closing fileReader !!!");
                    e.printStackTrace();
                }
            }
        }

        return res;

    }

    /**
     * bu fonksiyon yardimci  fonksiyon olarak kullanilmistir.
     * dosyadan bir seyler silinip sifirdan bir seyler yazilacaksa bu fonksiyon kullanilir.
     *
     * @param line silinmeyecek satirlar tek tek bu parametre ile gonderilir.
     * @param filename kayitlarin yazildigi dosya ismi
     * @param append overwrite mi edilecegi yoksa devamina mi yazilacagini belirler.
     */
    protected void writeCSV(String line,String filename,boolean append){
        BufferedWriter fileWriter = null;
        try{
            String parts[] = line.split(";");
            fileWriter = new BufferedWriter(new FileWriter(filename,append));
            fileWriter.write(parts[0]);
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(parts[1]);
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(parts[2]);
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(parts[3]);
            fileWriter.write(COMMA_DELIMITER);
            fileWriter.write(parts[4]);
            fileWriter.write(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }


}
