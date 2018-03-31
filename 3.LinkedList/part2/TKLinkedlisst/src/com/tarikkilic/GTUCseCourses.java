package com.tarikkilic;

import java.io.*;
import java.util.Iterator;


/**
 * GTU deki derslerin verilerini tutan class
 */
public class GTUCseCourses implements GTUCseCoursesInt {
    private TKLinkedList<Courses> courses;

    public  GTUCseCourses() throws IOException {
        courses = new TKLinkedList<Courses>();
        readCourse("data.csv");
    }

    public GTUCseCourses(TKLinkedList<Courses> courses) {
        this.courses = courses;
    }

    public TKLinkedList<Courses> getList(){
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
     * @return TKLinkedList<Courses> ayni koda sahip olan dersleri icerir
     */
    @Override
    public TKLinkedList<Courses> getByCode(String code)  {
        Iterator<Courses> iter = courses.iterator();
        TKLinkedList<Courses> retVal = new TKLinkedList<>();
        while(iter.hasNext()){
            Courses c =  iter.next();
            if(c.getCode().equals(code)){
                retVal.add(c);
            }
        }
        return retVal;
    }


    /**
     * @param semester
     * @return TKLinkedList<Courses> ayni semester a sahip olan dersleri icerir
     */
    @Override
    public TKLinkedList<Courses> listSemesterCode(int semester) {
        Iterator<Courses> iter = courses.iterator();
        TKLinkedList<Courses> retVal = new TKLinkedList<>();
        while(iter.hasNext()){
            Courses c = iter.next();
            if(c.getSemester() == semester){
                retVal.add(c);
            }
        }
        return retVal;
    }


    /**
     * @param start_index
     * @param last_index
     * @return TKLinkedList<Courses> indexler arasinda kalan dersleri icerir
     */
    @Override
    public TKLinkedList<Courses> getByRange(int start_index, int last_index) {
        TKLinkedList<Courses> retVal = new TKLinkedList<>();
        for(int i = start_index; i < last_index; i++){
            retVal.add(courses.get(i));
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
