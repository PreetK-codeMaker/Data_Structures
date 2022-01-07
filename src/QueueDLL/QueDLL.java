package QueueDLL;

import DoubleLinkedList.DLL;
import Exceptions.EmptyQueueException;
import utilitie.Iterator;
import utilitie.QueueADT;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * This class is the logically implemented Queue stack that use the double linked list. It follow the same rules FIFO
 * First in first out.
 *
 * References = 1. CPRG251 Assignment 5 Single linked list,
 *              2. Data Structures and Absrtactions with Java By Frank M.Carrano and Timothy M.Henry
 *              3. https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 *              4. https://regex101.com/
 * */
public class QueDLL<E> implements QueueADT<E>, Serializable {

    private static final long serialversionUID = 7555665854466L;
    private DLL<E> que;

    /**
     * Defulut constructor.
     */
    public QueDLL(){
       que = new DLL<>();
    }

    /**
     * This Take element specifed by the user and add's it to that end of the Queue
     * @param toAdd the item to be added to the Queue.
     * @throws NullPointerException throws a null pointer exception whenever it encounter null value.
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if(notNull(toAdd)){
            throw new NullPointerException();
        }
        que.add(toAdd);
    }

    /**
     *  This method delete the very fist item was inserted in to the Queue
     * @return the item is that is about to be deleted
     * @throws EmptyQueueException gets throw if the Queue is empty.
     */
    @Override
    public E dequeue() throws EmptyQueueException {
//        E element= head.getElement();
        if(isEmpty()){
            throw  new EmptyQueueException("Empty Queue");
        }
        
        E element = que.remove(0);
        return element;
    }

    /**
     * This look at the very first item in the stack
     * @return a refereneces to the very first element
     * @throws EmptyQueueException gets throw if the Queue is empty.
     */
    @Override
    public E peek() throws EmptyQueueException {
        if(isEmpty()){
            throw  new EmptyQueueException("Empty Queue");
        }
        E element = que.get(0);
        return element;
    }

    /**
     * This method clear all everything in the queue
     */
    @Override
    public void dequeueAll() {
      que.clear();
    }

    /**
     * This methdo check whether the Queue is empty or not.
     * @return a boolean based on if null or not.
     */
    @Override
    public boolean isEmpty() {
        return que.isEmpty();
    }

    /***
     * Method to iterarot over the element without the use of the index.
     * @return a iterator to iterat over the elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayBasedIterator();
    }

    /**
     * This compare that two of the Queue ADT are the infact equal to each other. In every single way
     * This method even check of null the length are the same in every way possible.
     * @param that the Queue ADT to be compared to this queue.
     * @return a boolean based on the if they are equals or not.
     */
    @Override
    public boolean equals(QueueADT<E> that) {
        boolean check = true;
        Object compareTo[] = (E[]) that.toArray();//Convert it's to array of object
        Object mainArr[] = toArray(); //convert it's to arrat of object.
        check = compareTo.length > mainArr.length ? false : //Compare length  if bigger.
                compareTo.length < mainArr.length ? false : true; //Compare length for smaller.

        for (int i = 0; i <size() && check; i++) {
            if(compareTo[i] == null || mainArr[i] == null){
                throw new NullPointerException();
            }else if(!(compareTo[i].equals(mainArr[i]))){
                check = false;
            }
        }
        return check;
    }

    /**
     * Convert Double Linked List to the Array of object.
     * @return a array of object.
     */
    @Override
    public Object[] toArray() {
        Object [] array = new Object[size()];
        for (int i = 0; i <size(); i++) {
            array[i] = que.get(i);
        }
        return array;
    }

    /**
     * This Convert any array into the Specified array element type by the user and it also change the size of the array to
     * apporiate size if not passed.
     * @param holder Array of element that is bring passed.
     * @return array of the element
     * @throws NullPointerException
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if(holder == null){
            throw new NullPointerException();
        }
        if(holder.length < size()){
//            holder = (E[]) new Object[size()];
            holder = (E[]) Array.newInstance(holder.getClass().getComponentType(),size());
        }
        for (int i = 0; i <size(); i++) {
            holder[i] = que.get(i);
        }
        return holder;
    }


    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * This method keep track of the size of the array.
     * @return size of the array.
     */
    @Override
    public int size() {
        return que.size();
    }

    /*-----------------Private Methods-------------**/

    /**
     * This mehtod check for the null value of whatever being passed.
     * @param toAdd element that is being comapreTo
     * @return a boolean based on null found or not.
     */
    private boolean notNull(E toAdd){
        boolean check = false;
        if(toAdd == null){
            check = true;
        }
        return check;
    }

    /*-----------------END OF Private Methods-------------**/

    public static void main(String[] args) throws EmptyQueueException {
       QueueADT<String> hello = new QueDLL<String>();
       QueueADT<Integer> h = new QueDLL<>();


        hello.enqueue("1");
        hello.enqueue("2");
        hello.enqueue("3");
        hello.enqueue("4");
        hello.dequeue();
        h.enqueue(1);
        h.enqueue(2);
        h.enqueue(3);
        h.enqueue(4);
    }

    /**
     * Private class being called by the iterator method in the class.
     * References:
     *          1. Code was provided in the class by the instructor
     */
    private class ArrayBasedIterator implements Iterator<E> {
        //Attributes
        private  E[] CopyofElementl;
        private int pos;

        /**
         * This constructor make the apporiate size array and copying all the element to the to the new array.
         */
        public ArrayBasedIterator(){
            CopyofElementl = (E[]) (new Object[size()]);
            System.arraycopy(toArray(),0,CopyofElementl,0,CopyofElementl.length);
        }

        /**
         * This method check for the if the array have more element to iterator over.
         * @return more element to iterator over.
         */
        @Override
        public boolean hasNext() {
            return pos < CopyofElementl.length;
            
        }

        /**
         * gets the next element.
         * @return the next element
         * @throws NoSuchElementException throw an error if the element does not exist
         */
        @Override
        public E next() throws NoSuchElementException {
            try {
                E toReturn = CopyofElementl[pos];
                pos++;
                return toReturn;
            }catch(IndexOutOfBoundsException e){
                throw new NoSuchElementException();
            }
        }
    }
}
