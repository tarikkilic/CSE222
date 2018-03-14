package com.tarikkilic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Resepsiyonist hakkinda verileri tutar ve dosyaya yazma ve okuma metodlari icerir.
 */
public class Receptionist extends User {

    /**
     *
     * @param n name initiliaze
     * @param s surname initliaze
     * @param id userid initiliaze
     */
    public Receptionist(String n,String s,String id){
        super(n,s,id);
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
     * !!!BU METODA STACKOVERFLOWDAN YARDIM ALINARAK YAZILMISTIR
     * eger guest objesi rezervi var ise kayittan ilk once silinir.
     * ardindan "reserve" durumu checkin yapilarak dosyaya tekrar eklenir.
     * tekrar ekleme islemi {@link com.tarikkilic.User#writeCSV(String, String, boolean)} fonksiyonu ile yapilir
     *
     * @return boolean kayıt yapıldıysa true; yapamadıysa false
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param room istenilen odanin objesi
     * @param guest kaydi yapilacak kisinin objesi
     * @see Room
     * @see Guest
     */
    public boolean checkIn(String filename, Room room, Guest guest) {
        boolean res = false;
        if(guest.getStatus().equals("RESERVE")){
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
                        if (l.equals(guest.getUserId())) {
                            isSame = true;
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
            }
            catch (Exception e) {
                System.out.println("Error in CsvFileReader !!!");
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    guest.setStatus("EMPTY");
                } catch (IOException e) {
                    System.out.println("Error while closing fileReader !!!");
                    e.printStackTrace();
                }
            }
        }


        if(guest.getStatus().equals("EMPTY")){
            NUMBER++;
            boolean append = false;
            BufferedWriter fileWriter = null;
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
                room.changeStatus("CHECK-IN");
                guest.setStatus("CHECK-IN");
                fileWriter.write(valueOf(room.getStatus()));
                fileWriter.write(NEW_LINE_SEPARATOR);
                System.out.println("KAYIT EDILDI. ODA NO: " + room.getrNo() + " KISI: " + guest);
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
            res = true;
        }
        return res;
    }

    /**
     * dosyayi satir satir okuyup kaydi silicek musteri haric bilgiler arrayliste atilir.
     * her arrayliste atildiginde {@link com.tarikkilic.User#writeCSV(String, String, boolean)} fonksiyonu cagirilip dosyaya sifirdan yazilir.
     *
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param guest kaydi silinecek kisinin objesi
     * @see Guest
     */
    public boolean checkOut(String filename, Guest guest){
        boolean res = false;
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
                    if (l.equals(guest.getUserId())) {
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
                System.out.println("CIKIS YAPILDI " + "KISI " + guest);
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * daha onceden kayit veya rezerv yapip yapmadigini kontrol eder.
     * ardindan guest in bilgilerini dosyaya yazar.
     * @return boolean rezerv yaptıysa true; yapamadıysa false
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param room istenilen odanin objesi
     * @param guest rezerv yapilacak kisinin objesi
     * @see Room
     * @see Guest
     */
    @Override
    public boolean bookRoom(String filename, Room room, Guest guest){
        NUMBER++;
        boolean append = false;
        BufferedWriter fileWriter = null;
        if(!(guest.getStatus().equals("EMPTY")) || !(room.getStatus().equals("EMPTY"))){
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
     * dosyayi satir satir okuyup kaydi silicek musteri haric bilgiler arrayliste atilir.
     * her arrayliste atildiginde {@link com.tarikkilic.User#writeCSV(String, String, boolean)} fonksiyonu cagirilip dosyaya sifirdan yazilir.
     *
     * @return boolean rezervi sildiyse true, silmediyse false
     * @param filename kayitlarin tutuldugu dosyanin ismi
     * @param guest rezervi iptal edilecek kisinin objesi
     * @see Guest
     */
    @Override
    public boolean cancelRezerv(String filename,Guest guest){
        boolean res = false;
        NUMBER--;
        BufferedReader br = null;
        String line = "";
        List<String> lines = new ArrayList<String>();
        boolean isDuplicate = false;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                isDuplicate = false;
                String[] object = line.split(COMMA_DELIMITER);
                for (String l : object) {
                    if (l.equals(guest.getUserId())) {
                        isDuplicate = true;
                    }
                }
                if (!isDuplicate) {
                    lines.add(line);
                }
            }

            boolean append = false;
            for (String newL : lines) {
                writeCSV(newL,filename,append);
                append = true;
                res = true;
            }
            br.close();


        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                br.close();
                System.out.println("REZERV IPTAL EDILDI " + " KISI " + guest.toString());
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return res;
    }



}
