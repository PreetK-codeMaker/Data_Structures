package DoubleLinkedList;

import utilitie.Iterator;
import utilitie.ListADT;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * This Class created nodes that will be used in the used in the Double linked list
 * This class will help with the next and Before refernces of the Double linked List.
 * It also Implemets Serializable to help with persistance of the obejct if the use choose to do so.s
 *
 * References = 1. CPRG251 Assignment 5 Single linked list,
 *              2. Data Structures and Absrtactions with Java By Frank M.Carrano and Timothy M.Henry
 *              3. https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 * */

public class DLL<E> implements ListADT<E>{
    private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;

    public DLL(){
        head = null;
        tail = null;
    }

    /**
     * This to keep track Double linked list size
     * @return the size of the array.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This empty the Double linked list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method add it to the specified index in with the specified element with it
     * @param index
     * 			The index at which the specified element is to be inserted.
     * 			The element is inserted before the existing element at [index],
     * 			or at the end if index is equal to the
     * 			size (<code>size()</code>).
     * @param toAdd
     * 			The element to be inserted.
     * @return
     * @throws NullPointerException is Thrown when the null value is encountered.
     * @throws IndexOutOfBoundsException is Thrown when the index is less then a zero or
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(checkRange(index)){
            throw new IndexOutOfBoundsException();
        }if(toAdd == null){
            throw new NullPointerException();
        }
        boolean status = false;
        if(!isEmpty()){
            if(index == 0){
                DLLNode insert = new DLLNode(toAdd);
                head.setPrev(insert);
                insert.setNext(head);
                head = insert;
                size++;

//                DLLNode insert = new DLLNode(toAdd);
//                insert.setPrev(insert);
//                tail.setNext(insert);
//                tail = insert;
//                size++;
            }else if(index == size ){
                add(toAdd);

            }else{

                DLLNode temp = head;
                for (int i = 0; i  <size(); i++) {

                    if(i == index-1){
                        DLLNode holder = temp.getNext();
                        DLLNode newInsert = new DLLNode(toAdd);
                        temp.setNext(newInsert);
                        newInsert.setPrev(temp);
                        newInsert.setNext(holder);
                        holder.setPrev(newInsert);
//                        DLLNode next = temp.getNext();
//                        DLLNode prev = temp.getPrev();
//                        newInsert.setNext(next);
//                        newInsert.setPrev(prev);
//                        prev.setNext(newInsert);
//                        temp.setNext(newInsert);
//                        temp.setPrev(prev);
                        size++;
                    }
                    temp = temp.getNext();
                }
            }
        }else{
            head = new DLLNode(toAdd);
            tail = head;
            size ++;
        }
        return false;
    }

    /**
     * This method add to the end of the array list.
     * @param toAdd
     * 			Element to be appended to this list.
     * @returna boolean based on whether it was successful or not.
     * @throws NullPointerException a null pointer is thrown based on if the null value is encounter
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
    	if(toAdd == null) {
    		throw new NullPointerException();
    	}
       if(!isEmpty()){
            DLLNode insert = new DLLNode(toAdd);
            insert.setPrev(tail);
            tail.setNext(insert);
            tail = insert;
            size++;

       }else{
           head = new DLLNode(toAdd);
           tail = head;
           size ++;
       }

        return false;
    }

    /**
     * This add the all the List to the other array.
     * @param toAdd
     * 			The new sub list to be added.
     * @returna boolean based on whether it was successful or not.
     * 	@throws NullPointerException a null pointer is thrown based on if the null value is encounter
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
       Object [] arr = toAdd.toArray();
        for (Object a: arr) {
            if(a == null){
                throw new NullPointerException();
            }else {
                if (!isEmpty()) {
                    DLLNode insert = new DLLNode(a);
                    insert.setNext(insert);
                    tail.setNext(insert);
                    tail = insert;
                    size++;
                }else{
                    head = new DLLNode(a);
                    tail = head;
                    size++;
                }
            }
        }
        return true;
    }

    /**
     * This method return a element on a given index
     * @param index
     * 			Index of element to return.
     * @return the value at the element of the index.
     * @throws IndexOutOfBoundsException is Thrown when the index is less then a zero or greater then size.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(getCheckForGet(index)){
            throw new IndexOutOfBoundsException();
        }
        if(!isEmpty()){
            DLLNode curr = head;
            for (int i = 0; i <index; i++) {
                curr = curr.getNext();
            }
            E o = (E) curr.getElement();
            return  o;
        }
        return null;
    }

    /**
     * This remove element at a given index.
     * @param index
     * 			The index of the element to remove.
     * @return the element that is about to delete.
     * @throws IndexOutOfBoundsException is Thrown when the index is less then a zero or greater then size.
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        E element = null;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(!isEmpty()){
           if(index == 0){
              element = removeFirst();
           }else if(index == size-1){
               removeLast();
           }else{
               DLLNode del =head;
//               DLLNode prev = head;
               for (int i = 0; i <index; i++) {
                   del = del.getNext();

//                   prev = prev.getNext();
//                       DLLNode next = del.getNext();
//                       DLLNode prev = del.getPrev();
//                       prev.setNext(next);
//                       next.setPrev(prev);
//                       size--;
//                       return null;
               }
               DLLNode temp = del;
               element = (E) temp.getElement();
               del = temp.getPrev();
               del.setNext(temp.getNext());
               size--;
               
           }
        }
        
        return element;
    }

    /**
     * This method remove based of what is given and it finds the element it the array.
     * @param toRemove
     * 			The element to be removed from this list.
     * @return a the element is about to be removed.
     * @throws NullPointerException a null pointer is thrown based on if the null value is encounter
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
    	E element = null;
        if(toRemove == null){
            throw new NullPointerException();
        }
        int position = 0;
        boolean status = false;
        DLLNode find = head;
        for (int i = 0; i <size(); i++) {
            if(find.getElement().equals(toRemove)){
                position = i;
                status = true;
                break;
                
            }
            find = find.getNext();
        }
        if(status){
           element =  remove(position);
        }
        return element;
    }


    /**
     * This method set the element at a given index and replaces it with given element that will passsed whenever t
     * this method is called.
     * @param index
     * 			The index of the element to replace.
     * @param toChange
     * 			Element to be stored at the specified position.
     * @return element that have been palced
     * @throws NullPointerException a null pointer is thrown based on if the null value is encounter
     * @throws IndexOutOfBoundsException is Thrown when the index is less then a zero or greater then size.
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if(checkRange(index)){
            throw new IndexOutOfBoundsException();
        }if (toChange == null){
            throw new NullPointerException();
        }
        if(index == 0){
            head.setElement(toChange);

        }else if(index == size-1){
            tail.setElement(toChange);

        }else {
            DLLNode find = head;
            for (int i = 0; i < index; i++) {
                find = find.getNext();
            }

            find.setElement(toChange);
        }
        return null;
    }

    /**
     * This method check if the Double linked list is empty or not
     * @return a boolean based on if the head = null.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * This method finds if the Double linked list contains the specified element have been requested.
     * @param toFind
     * 			The element whose presence in this list is to be tested.
     * @return the boolean based on if they found the value or not.
     * @throws NullPointerException
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        boolean check = false;
        boolean stop = true;
        DLLNode find = head;
        for (int i = 0; i <size() && stop; i++) {
            if(find.getElement().equals(toFind)){
                check = true;
                stop = false;
            }
            find = find.getNext();
        }
        return check;
    }

    /**
     *This Convert any array into the Specified array element type by the user and it also change the size of the array to
     * apporiate size if not passed.
     * @param toHold
     *			The array into which the elements of this list are to be
     * 			stored, if it is big enough; otherwise, a new array of the
     * 			same runtime type is allocated for this purpose.
     * @return array of the element.
     * @throws NullPointerException
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if(toHold == null){
            throw new NullPointerException();
        }
        if(toHold.length < size()){
//            toHold = (E[]) new Object[size()];
           toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(),size());
        }
        DLLNode copying = head;
        for (int i = 0; i <size(); i++) {
            toHold[i] = (E)copying.getElement();
            copying = copying.getNext();
        }
        return toHold;
    }

    /**
     * Convert Double linked lsit  to a array of object.
     * @return a array of object.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        DLLNode arr = head;
        for (int i = 0; i <size(); i++) {
            array[i] = arr.getElement();
            arr = arr.getNext();
        }
        return array;
    }

    /**
     * Method to iterator over the element without the use of the index.
     * @return a iterator to iterate over the elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayBasedIterator();
    }

    /*-----------------------Private Method----------------------------*/
    /**
     * This method check the range and make new array if the size of the stack is equal to the size
     */
    private boolean checkRange(int index){
        boolean status = false;
        if(index < 0 || index > size){
            status =true;
        }
        return status;
    }

    /**
     * This method removes it from the Start of the Double linkedList
     */
    private E removeFirst(){
        E element = (E) head.getElement();
        if(!isEmpty()) {
            DLLNode del = head;
            head = head.getNext();
            size--;
        }
        return element;
    }

    /**
     * This remove the elmenet from the end of the Double linked List.
     */
    private void removeLast(){
        if(!isEmpty()){
            DLLNode del =tail;
            tail = tail.getPrev();
            size--;
        }
    }

    private Object[] specialArray(){
        Object[] array = new Object[size()];
        DLLNode arr = head;
        for (int i = 0; i <size(); i++) {
            array[i] = arr.getElement();
            arr = arr.getNext();
        }
        return array;
    }
    
	private boolean getCheckForGet(int index){
        boolean status = false;
        if(index < 0 || index >= size){
            status = true;
        }

        return status;
    }
    /*----------------------END PRIVATE METHODS--------------------------------------------**/
    /**
     * Private class being called by the iterator method in the class.
     * References:
     *          1. Code was provided in the class by the instructor
     */
    private class ArrayBasedIterator implements Iterator<E> {
        private E[] CopyofElementl;
        private int pos;

        /**
         * This constructor make the apporiate size array and copying all the element to the to the new array.
         */
        public ArrayBasedIterator() {
            CopyofElementl = (E[]) (new Object[size()]);
            System.arraycopy(specialArray(),0,CopyofElementl,0,CopyofElementl.length);
        }

        /**
         * This method check for the if the array have more element to iterator over.
         * @return more element to iterator over.
         */
        @Override
        public boolean hasNext() {
            return pos <CopyofElementl.length;
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
    public static void main(String[] args) {
		DLL<String> l = new DLL<String>();
		l.add("Hello");
		l.add("Hello");
		l.add("Hello");
		l.remove("Hello");
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
			
		}
		System.out.println();
	}
}
