package com.tarikkilic;

import java.io.IOException;
import java.util.List;

public interface GTUCseCoursesInt {

    /**
     * CSV dosyasinda ki kurs bilgilerini okur.
     * Okunan bilgileri listeye ekler.
     * @param filename dosya adi
     * @return
     */
    void readCourse(String filename) throws IOException;

    /**
     * Eger dosyada degil de programdan kur eklenmek istenirse bu metot kullanilir.
     * @param course eklenecek kurs objesi
     */
    void addCourse(Courses course);

    List<Courses> getByCode(String code) throws CloneNotSupportedException;

    List<Courses> listSemesterCode(int semester);

    List<Courses> getByRange(int start_index, int last_index);

}