import java.io.*;
import java.util.LinkedList;

/**
 * GTU deki derslerin verilerini tutan class
 */
public class GTUCseCourses implements GTUCseCoursesInt {
    private MyList courses;

    public  GTUCseCourses() throws IOException {
        courses = new MyList();
        readCourse("data.csv");
    }

    public GTUCseCourses(MyList courses) {
        this.courses = courses;
    }

    /**
     * metotlara direk liste uzerinden erisebilmesi icin.
     * @return class icinde tuttugu listeyi return eder.
     */
    public MyList getList(){
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
            Course course = new Course();
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
    public void addCourse(Course course) {
        courses.add(course);
    }


    /**
     *
     *
     * @param code
     * @return verilen ders kodunun oldugu listeyi return eder.
     */
    @Override
    public LinkedList<Course> getByCode(String code)  {
        MyList.MyIterator iter = courses.iterator();
        LinkedList<Course> retVal = new LinkedList<>();
        while(iter.hasNext()){
            Course c =  iter.next();
            if(c.getCode().equals(code)){
                retVal.add(c);
            }
        }
        return retVal;
    }


    /**
     *
     * @param semester
     * @return verilen donem numarasinin oldugu listeyi return eder.
     */
    @Override
    public LinkedList<Course> listSemesterCode(int semester) {
        MyList.MyIterator iter = courses.iterator();
        LinkedList<Course> retVal = new LinkedList<>();
        while(iter.hasNext()){
            Course c = (Course) iter.next();
            if(c.getSemester() == semester){
                retVal.add(c);
            }
        }
        return retVal;
    }


    /**
     *
     * @param start_index
     * @param last_index
     * @return verilen indexler arasindaki dersleri return eder.
     */
    @Override
    public LinkedList<Course> getByRange(int start_index, int last_index) {
        LinkedList<Course> retVal = new LinkedList<>();
        for(int i = start_index; i < last_index; i++){
            retVal.add(courses.get(i));
        }
        return retVal;
    }


    /**
     * tum kurslari ekrana bastirir.
     */
    public void printCourses(){
        MyList.MyIterator iter =  courses.iterator();
        while (iter.hasNext()){
            System.out.println("\n" + iter.next());
        }
    }



}
