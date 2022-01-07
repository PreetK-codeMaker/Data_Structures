package MyArrayList;

import java.io.Serializable;
import java.lang.reflect.Array;
import utilitie.Iterator;

import java.util.NoSuchElementException;

import utilitie.ListADT;

/**
 * This is the implementation of the arrayList using ListADT that was provieded by the SAIT .
 * This implemenetation of the arrayLisrt will also have the serialization
 * @param <E> the type of element this list will hold.
 *
 * References = 1. Data Structures and Absrtactions with Java By Frank M.Carrano and Timothy M.Henry
 * 	            2. https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

public class MyArrayList<E> implements ListADT<E>, Serializable {
	//Constant
	private static final int DEFAULT_ARRAY_SIZE = 10;
	private static final long serialVersionUID = 555458745665L;

	//Attributes.
	private int size;
	private E[] array;

	/**
	 * This created the default constructor which give the array a default size of 10
	 */
	public MyArrayList() {
		array = (E[]) new Object[DEFAULT_ARRAY_SIZE];
		size = 0;
	}

	/**
	 * This custom to specified a space a array that it creat the for the size
	 * @param customLength int value
	 */
	public MyArrayList(int customLength) {
		array = (E[]) new Object[customLength];
		size = 0;

	}

	/**
	 * This to keep track arrayList size
	 * @return the size of the array.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This empty the ArrayList
	 */
	@Override
	public void clear() {
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
	 * @throws IndexOutOfBoundsException is Thrown when the index is less then a zero or greater then size.
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (checkRange(index)) {
			throw new IndexOutOfBoundsException();
		}if(toAdd == null){
			throw new NullPointerException();
		}if(size() >=array.length){
			E[] newArr = (E[]) new Object[array.length * 2];
			System.arraycopy(array,0,newArr,0,array.length);
			array = newArr;
		}
		//Shifting the array to the right.
		for(int i = size(); i>=index; i--){
			array[i+1] = array[i];
		}
		array[index] =  toAdd;
		size++;
		return true;
	}

	/**
	 * This method add to the end of the array list.
	 * @param toAdd
	 * 			Element to be appended to this list.
	 * @return a boolean based on whether it was successful or not.
	 * @throws NullPointerException a null pointer is thrown based on if the null value is encounter
	 */
	@Override
	//Add is o(n) operations because we have to have make more space by creating new array with twice as much memory.
	public boolean add(E toAdd) throws NullPointerException {
		if (size >= array.length) {
			E[] newArr = (E[]) new Object[array.length * 2];
			System.arraycopy(array, 0, newArr, 0, array.length);
			array = newArr;
		}
		if (toAdd == null) {
			throw new NullPointerException();
		}
		array[size] = toAdd;
		size++;
		return true;
	}

	/**
	 * This add the all the List to the other array.
	 * @param toAdd
	 * 			The new sub list to be added.
	 * @return a  boolean based on whether it was successful or not.
	 * @throws NullPointerException a null pointer is thrown based on if the null value is encounter
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		boolean check = false;
		Object [] arr = toAdd.toArray();
		for (Object a: arr ) {
			if(a == null) {
				throw new NullPointerException();
			}
			add((E) a);
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
		return array[index];
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
		if(index < 0 ||index >= size){
			throw new IndexOutOfBoundsException();
		}
		E element = get(index);

		for (int i = index; i <array.length-1 ; i++) {
			array[i] = array[i+1];
		}
		size--;
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
		if(toRemove == null) {
			throw new NullPointerException();
		}
		int index = indexOf(toRemove);
		E element = get(index);
		remove(index);
		return toRemove;
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
		}

		if(toChange == null){
			throw new NullPointerException();
		}
		for (int i = 0; i <size() ; i++) {
			if(i == index){
				array[index] = toChange;
			}
		}
		return toChange;
	}

	/**
	 * This method check if the array is empty or not
	 * @return a boolean based on if the sizer is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size() ==0;
	}

	/**
	 * This method finds if the array contains the specified element have been requested.
	 * @param toFind
	 * 			The element whose presence in this list is to be tested.
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean check = false;
		boolean stopCounter = true;
		for (int i = 0; i <size() && stopCounter; i++) {
			if(get(i).equals(toFind)){
				check = true;
				stopCounter = false;
			}
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
		if (toHold == null || size == 0) {
			throw new NullPointerException();
		}
		//This set the size of the array. toHold is smaller then the size
		if (toHold.length < this.size) {
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(),size());

		}
		//This cop
		for (int i = 0; i < this.size; i++) {
			toHold[i] = (E) this.array[i];
		}
		return toHold;
	}

	/**
	 * Convert ArrayList  to a array of object.
	 * @return a array of object.
	 */
	@Override
	//This return just a object array.
	public Object[] toArray() {
		Object arr[] = (E[]) new Object[size()];
		for (int i = 0; i <size(); i++) {
			arr[i] = array[i];
		}
		return arr;
	}

	/**
	 * Method to iterator over the element without the use of the index.
	 * @return a iterator to iterate over the elements
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayBasedIterator();
	}

	/*-------------------------Private Methods---------------------------------*/
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
	 * This methos return the index of the element that is being passed from the parent method.
	 * @param toRemove
	 * @return a int value of the postion of the passed parameter.
	 */
	private int indexOf(E toRemove){
		int teRomvePostion =0;
		boolean stop = true;
		for(int i=0; i<size() && stop;i++){
			if(toRemove.equals(array[i])){
				teRomvePostion = i;
				stop = false;
			}
		}
		return teRomvePostion;
	}

	/**
	 * Check if the index out of bounds or not
	 * @param index a int value
	 * @return boolean based of the index id out bounds or not.s
	 */
	private boolean getCheck(int index){
		boolean status = false;
		if(index < 0 || index > size){
			status = true;
		}

		return status;
	}

	private boolean getCheckForGet(int index){
        boolean status = false;
        if(index < 0 || index >= size){
            status = true;
        }

        return status;
    }
	/*-------------------------End Private Methods--------------------------------------*/

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
			System.arraycopy(array,0,CopyofElementl,0,CopyofElementl.length);
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
}

