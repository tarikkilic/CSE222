package com.tarikkilic;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * GTU deki derslerin verilerini tutan class
 */
public class GTUCseCourses implements GTUCseCoursesInt {
    private LinkedList<Courses> courses;

    public  GTUCseCourses() throws IOException {
        courses = new LinkedList<Courses>();
        readCourse("data.csv");
    }

    public GTUCseCourses(LinkedList<Courses> courses) {
        this.courses = courses;
    }
    //Test icin
    public LinkedList<Courses> getList(){
        return courses;
    }

    /**
     * CSV dosyasinda ki kurs bilgilerini okur.
     * Okunan bilgileri listeye ekler.
     *
     * @param filename dosya adi
     * @return
     */
    @Override
    public void readCourse(String filename) throws IOException {
        BufferedReader br = null;
        String line = "";
        br = new BufferedReader(new FileReader(filename));
        //her bir satiri okuyup noktali virgüllerle ayirip sirayla course icine bilgileri atadim.
        br.readLine();

        while((line = br.readLine()) != null){
            String[] word = line.split(";");
            Courses course = new Courses();
            course.setSemester(Integer.parseInt(word[0]));
            course.setCode(word[1]);
            course.setCourse_title(word[2]);
            course.setEctsCredit(Integer.parseInt(word[3]));
            course.setGtuCredit(Integer.parseInt(word[4]));
            course.setHtl(word[5]);
            courses.add(course);
        }

    }

    /**
     * Eger dosyada degil de programdan kur eklenmek istenirse bu metot kullanilir.
     *
     * @param course eklenecek kurs objesi
     */
    @Override
    public void addCourse(Courses course) {
        courses.add(course);
    }

    /**
     * @param code
     * @return LinkedList<Courses> ayni koda sahip olan dersleri icerir
     */
    @Override
    public LinkedList<Courses> getByCode(String code)  {
        Iterator<Courses> iter = courses.iterator();
        LinkedList<Courses> retVal = new LinkedList<>();
        while(iter.hasNext()){
            Courses c =  iter.next();
            if(c.getCode().equals(code)){
                retVal.add(c);
            }
        }
        if(retVal.size() == 0){
            throw new NoSuchElementException();
        }

        return retVal;
    }

    /**
     * @param semester
     * @return LinkedList<Courses> ayni semester a sahip olan dersleri icerir
     */
    @Override
    public LinkedList<Courses> listSemesterCode(int semester) {
        Iterator<Courses> iter = courses.iterator();
        LinkedList<Courses> retVal = new LinkedList<>();
        while(iter.hasNext()){
            Courses c = iter.next();
            if(c.getSemester() == semester){
                retVal.add(c);
            }
        }
        if(retVal.size() == 0){
            throw new NoSuchElementException();
        }
        return retVal;
    }

    /**
     * @param start_index
     * @param last_index
     * @return LinkedList<Courses> indexler arasinda kalan dersleri icerir
     */
    @Override
    public LinkedList<Courses> getByRange(int start_index, int last_index) {
        LinkedList<Courses> retVal = new LinkedList<>();
        if(start_index < 0 || last_index < 0 || start_index > courses.size() || last_index > courses.size()){
            throw new IndexOutOfBoundsException();
        }
        for(int i = start_index; i < last_index; i++){
            retVal.add(courses.get(i));
        }

        if(retVal.size() == 0){
            throw new NoSuchElementException();
        }
        return retVal;
    }

    public void printCourses(){
        Iterator<Courses> iter = courses.iterator();
        while (iter.hasNext()){
            System.out.println("\n" + iter.next());
        }
    }

}
