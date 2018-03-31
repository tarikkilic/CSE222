package com.tarikkilic;

import java.util.*;

/**
 * Normal LinkedList haricinde elemanlari disable enable ve disable edilmis elemanlari
 * ekranda görulebiliyor
 * @param <E>
 */
public class TKLinkedList<E> extends LinkedList<E>{
    ArrayList<E> disabledList;
    public TKLinkedList(){
        super();
        disabledList = new ArrayList<>();
    }

    /**
     * @param element
     * @return E
     */
    public E disable(E element){
        E retVal = null;
        for(int index = 0; index < super.size();index++){
            if(super.get(index).equals(element)){
                retVal = super.get(index);
                disabledList.add(retVal);
            }
            //EXCEPTION EKLENECEK
        }
        return retVal;
    }

    /**
     * @param element
     * @return E enable edilen eleman
     */
    public E enable(E element){
        E retVal = null;
        for(int i = 0;i < disabledList.size();i++){
            if(disabledList.get(i).equals(element)){
                retVal = disabledList.remove(i);
                break;
            }
            //EXCEPTION EKLENECEK
        }
        return retVal;
    }

    /**
     * disable edilen elemanlari bastirir.
     */
    public void showDisabled(){
        for(E element : disabledList){
            System.out.println("element: " + element);
        }
    }


    /**
     * @param index
     * @return remove edilen elemani basar.
     */
    @Override
    public E remove(int index){
        for(int i = 0; i < disabledList.size();i++){
            if(super.get(index).equals(disabledList.get(i))){
                System.out.println("DISABLED ITEM");
                return null;
            }
        }
        return super.remove(index);
    }

    /**
     * @return int size
     */
    @Override
    public int size(){
        return super.size() - disabledList.size();
    }

    /**
     * @param index
     * @param element
     * @return E element
     */
    @Override
    public E set(int index, E element){
        for(int i = 0; i < disabledList.size();i++){
            if(super.get(index).equals(disabledList.get(i))){
                System.out.println("DISABLED ITEM");
                return null;
            }
        }
        return super.set(index,element);
    }

    /**
     * @param index
     * @return E verilen indextei elemani return eder.
     */
    @Override
    public E get(int index){
        for(int i = 0; i < disabledList.size();i++){
            if(super.get(index).equals(disabledList.get(i))){
                return null;
            }
        }
        return super.get(index);
    }

    /**
     * @return ListIterator iterator return eder.
     */
    public ListIterator<E> listIterator(){
        return new ListIterator<E>() {
            private int index;
            private int setIndex;

            {
                setIndex = 0;
                index = 0;
            }


            /**
             * @return boolean devami var mi yok mu kontrol eder.
             */
            @Override
            public boolean hasNext() {
               if(index == -1)
                   index = 0;
                return index < TKLinkedList.super.size();
            }

            /**
             * @return E elemani return eder. bir ileri node a gecer.
             */
            @Override
            public E next(){
                setIndex = index;
                return get(index++);
            }

            /**
             * @return boolean bir oncesi olup olmadgini kontrol eder.
             */
            @Override
            public boolean hasPrevious() {
                if(index == TKLinkedList.super.size())
                    index--;
                return index > -1;
            }

            /**
             * @return E elemani return eder bir onceki elemana gider.
             */
            @Override
            public E previous() {
                setIndex = index;
                return get(index--);
            }

            /**
             * @return int next indexi return eder.
             */
            @Override
            public int nextIndex() {
                return index++;
            }

            /**
             * @return int onceki index i return eder.
             */
            @Override
            public int previousIndex(){
                if(index == 0){
                    //EXCEPTION
                }
                return index--;
            }

            @Override
            public void remove() {
                TKLinkedList.super.remove(index-1);
            }

            /**
             * @param e elemani set eder.
             */
            @Override
            public void set(E e) {
                TKLinkedList.super.set(setIndex,e);
            }

            /**
             * @param e eleman
             */
            @Override
            public void add(E e) {
                TKLinkedList.super.add(e);
            }
        };
    }

}
