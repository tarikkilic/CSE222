import java.io.IOException;

public class Main {

    public static void main(String[] args)  {

        System.out.println("GTUCseCourses OBJESI OLUSTURULDU");
        //listenin metotlarini denemek icin part1 deki classi buraya ekledim.
        GTUCseCourses system = null;
        try {
            system = new GTUCseCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("MyList OBJESI OLUSTURULDU");
        MyList list = new MyList();
        //direk listeye ulasip listeden metotlara ulasabilmek icin listeyi return ettim.
        list = system.getList();

        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("ITERATOR OLUSTURULDU");
        //iterator olusturuldu.
        MyList.MyIterator iter  = list.iterator();

        System.out.println("----------------------------------------------------------------------------------");

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("ITERATOR BASARIYLA CALISTI(ITER.NEXT VE ITER.HASNEXT)");
        System.out.println("ADD METOTU BASARIYLA CALISTI");

        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("SIZE: " + list.size());
        System.out.println("SIZE METODU DOGRU CALISTI");

        System.out.println("----------------------------------------------------------------------------------");

        Course course = new Course(3,"MATH 101","Calculus I",7,5,"5+0+0");
        list.remove(course);
        System.out.println("SIZE: " + list.size());
        System.out.println("REMOVE METODU DOGRU CALISTI-SIZE 1 EKSILDI");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("SEMESTERLER ICIN YENIDEN ITERATOR OLUSTURULDU, BASA GERI DONDU");
        MyList.MyIterator iterSemester = list.iterator();
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());
        System.out.println(iterSemester.nextInSemester());

        System.out.println("ITERATOR DOGRU CALISTI(NEXTINSEMESTER) 1'ler ICIN, BASA GERI DONDU");
        System.out.println("----------------------------------------------------------------------------------");
        MyList.MyIterator iterSemester2 = list.iterator();

        iterSemester2.next();

        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());
        System.out.println(iterSemester2.nextInSemester());

        System.out.println("ITERATOR DOGRU CALISTI(NEXTINSEMESTER) 3'ler ICIN, BASA GERI DONDU");
        System.out.println("----------------------------------------------------------------------------------");



        MyList.MyIterator iterSemester3 = list.iterator();
        iterSemester3.next();
        iterSemester3.next();
        iterSemester3.next();
        iterSemester3.next();


        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());
        System.out.println(iterSemester3.nextInSemester());

        System.out.println("ITERATOR DOGRU CALISTI(NEXTINSEMESTER) 5'ler ICIN, BASA GERI DONDU");
        System.out.println("----------------------------------------------------------------------------------");

    }
}
