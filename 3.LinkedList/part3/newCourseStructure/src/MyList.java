import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Normal LinkedList haricinde ayni donemin oldugu bir node tutar.
 */
public class MyList {
    private MyNode head;
    private int size;


    /**
     *
     */
    public MyList(){
        this.head = null;
        size = 0;
    }

    /**
     *
     * @return size
     */
    public int size(){
        return size;
    }


    /**
     *
     * @param i index
     * @return course
     */
    public Course get(int i){
        MyNode temp = head;
        int index = 0;
        while(index != i){
            index++;
            temp = temp.getNext();
        }
        return temp.getNext().getData();
    }


    /**
     * Hem linkedlist e ekeler ve semester lari birbirine baglayacak sekilde ekler.
     *
     * @param var
     */
    public boolean add(Course var){
        boolean status = false;
        if(head == null){
            head = new MyNode(var);
            size++;
            status = true;
        }
        else{
            MyNode res = new MyNode(var);
            MyNode temp = head;
            //semesterlari birbirine baglamak icin addSemester metotu cagirilir.
            addSemester(res);
            //en son node a gelene kadar dongu doner.
            while(temp.getNext() != null){
                temp = temp.getNext();
            }

            //node un baglantileri olmasi gereken sekilde baglanir.
            temp.setNext(res);
            temp.getNext().setNext(null);
            size++;
            status = true;
        }
        return status;
    }


    /**
     * Semesterlari birbirine baglar.
     *
     * @param var
     */
    private void addSemester(MyNode var){
        MyNode headSemester = null;
        MyNode temp1 = head;

        while(temp1 != null){
            //Eger semesterlari birbirine esit ve nextsemesteri null olan bir node ile karsilasiyor ise
            //verilen node ile birbirine baglanir.
            if(temp1.nextSemester == null && var.getData().getSemester() == temp1.getData().getSemester()){
                temp1.setNextSemester(var);
                var.setNextSemester(temp1);
                headSemester = temp1;
            }
            //verilen node un semesteri ile ayni olan o semesterin ilk nodeunu,verilen nodeun next semesteri bastaki
            //node a baglanir.
            else if( var.getData().getSemester() == temp1.getData().getSemester() && headSemester == null){
                var.setNextSemester(temp1);
                headSemester = temp1;
            }
            temp1 = temp1.next;
        }


        MyNode walk = head;

        //Eger listenin o semesterin son elemanina gelmisse---Bunu son elemanin nextsemestirinin o semesterlar icinde
        //bastaki olan node u gosteriyor ise o node o semesterin son elemanidir.Bunuda yukarida headSemester ile tuttuk.
        //---- Buldugumuz node un next semesterini ise  verilen node a bagladim.
        while(walk != null){
            if(headSemester != null){
                if(walk.nextSemester == headSemester && walk.getData().getSemester() == var.getData().getSemester()){
                    walk.setNextSemester(var);
                }
            }
            walk = walk.next;
        }
    }


    /**
     *
     * @param var
     */

    public boolean remove(Course var){
        MyNode temp = head;
        boolean status = false;
        //ilk elemani silmek istiyorsa.
        if(temp.getData().equals(var)){
            head = head.getNext();
            size--;
            status = true;
        }
        else{
            //ortalarda bir yerde silmek istiyorsa.
            while(temp.getNext() != null){
                if(temp.getNext().getData().equals(var)){
                    temp.setNext(temp.getNext().getNext());
                    size--;
                    status = true;
                }
                temp = temp.getNext();
            }
        }
        return status;
    }



    //-----------------------------------------------------------------------------------------------------------------

    /**
     *listenin icinde rahat dolasabilmemiz icin gerekli.
     *
     * @return MyIterator
     */
    public MyIterator iterator(){
        return new MyIterator();
    }

    public class MyIterator{
        MyNode next;

        public MyIterator(){
            next = head;
        }

        /**
         * devami var mi yok mu diye kontrol eder.
         * @return boolean
         */
        public boolean hasNext(){
            return next != null;
        }

        /**
         * olan course u basar ve sonraki node a gecer.
         *
         * @return Course
         */
        public Course next(){
            if(next == null)
                throw new NoSuchElementException();
            MyNode retVal = next;
            next = next.getNext();
            return  retVal.getData();
        }


        /**
         * kendisiyle ayni olan bir sonraki semestera gecer.
         *
         * @return Course
         */
        public Course nextInSemester(){
            MyNode retVal = next;
            next = next.getNextSemester();
            return  retVal.getData();
        }
    }


    /**
     * listemizi olusturan her bir dugum.
     */
        private class MyNode {
            private Course data;
            private MyNode next;
            private MyNode nextSemester;


            public MyNode(){
                this.data = null;
                this.next = null;
                this.nextSemester = null;
            }

            public MyNode(Course data) {
                this.data = data;
                this.next = null;
                this.nextSemester = null;
            }


            /**
             *
             * @return Course
             */
            public Course getData() {
                return data;
            }

            /**
             *
             * @param data
             */
            public void setData(Course data) {
                this.data = data;
            }


            /**
             *
             * @return MyNode
             */
            public MyNode getNext() {
                return next;
            }

            /**
             *
             * @param next
             */
            public void setNext(MyNode next) {
                this.next = next;
            }


            /**
             *
             * @return MyNode
             */
            public MyNode getNextSemester() {
                return nextSemester;
            }


            /**
             *
             * @param nextSemester
             */
            public void setNextSemester(MyNode nextSemester) {
                this.nextSemester = nextSemester;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                MyNode myNode = (MyNode) o;
                return Objects.equals(data, myNode.data) &&
                        Objects.equals(next, myNode.next) &&
                        Objects.equals(nextSemester, myNode.nextSemester);
            }

            @Override
            public int hashCode() {

                return Objects.hash(data, next, nextSemester);
            }

            @Override
            public String toString() {
                return "MyNode{" +
                        "data=" + data +
                        ", next=" + next +
                        ", nextSemester=" + nextSemester +
                        '}';
            }

        }



}
