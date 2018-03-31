

import java.io.IOException;
import java.util.LinkedList;


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
    void addCourse(Course course);

    LinkedList<Course> getByCode(String code) throws CloneNotSupportedException;

    LinkedList<Course> listSemesterCode(int semester);

    LinkedList<Course> getByRange(int start_index, int last_index);

}