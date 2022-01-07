package Stack;

import utilitie.Iterator;
import utilitie.StackADT;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import MyArrayList.MyArrayList;

/**
 *
 * This is the implemnentation for the stack ADT using array to implementation is follow the
 * LIFO rule which Last in first out it has also implmement Serializable for presistance purposes.
 * @param <E> the type of element this list will hold.
 *
 *
 * References = 1. Data Structures and Absrtactions with Java By Frank M.Carrano and Timothy M.Henry
 *  *           2. https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 *              3. https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html#equals(java.lang.Object)
 *
 */
public class Stack<E> implements StackADT<E>, Serializable {
    private static final long serialVersionUID = 55555454545454L;

    //Attributes
    private MyArrayList<E> stack;

    /**
     * This created the default constructor which give the array a default size of 10
     */
    public Stack(){
        stack = new MyArrayList<E>();


    }


    /**
     * This item add to the top of the stack and the stack index starts at 1
     * @param toAdd
     *            item to be pushed onto the top of the stack.
     * @throws NullPointerException throw null exception if any null exception is found.
     */
    @Override
    public void push(E toAdd) throws NullPointerException {
        if(nullCheck(toAdd)){
            throw new NullPointerException();
        }
        stack.add(toAdd);

    }

    /**
     * This method removes removes for the very top of the stack
     * @return a element that is being removed
     * @throws EmptyStackException  exception is thrown when stack is empty.
     */
    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E top = stack.get(size()-1);
        stack.remove(stack.size()-1);
        return  top;
    }

    /**
     * This method look at the very top of the stack without removeing element
     * @return the element it looked at
     * @throws EmptyStackException  exception is thrown when stack is empty.
     */
    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.get(size()-1);
    }

    /**
     * This empty the stack
     */
    @Override
    public void clear() {
        stack.clear();
    }

    /**
     * This method looks whether the stack is empty or not
     * @return return a boolean.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Convert ArrayList  to a array of object.
     * @return a array of object.
     */
    @Override
    public Object[] toArray() {
        Object arr[] = (E[]) new Object[size()];
        for (int i = size()-1; i>=0 ;i--) {
            arr[i] = stack.get(i);
        }
        return arr;
    }

    /**
     * This Convert any array into the Specified array element type by the user and it also change the size of the array to
     * apporiate size if not passed.
     * @param holder Array of element that is bring passed.
     * @return array of elements
     * @throws NullPointerException
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if(holder == null){
            throw  new NullPointerException();
        }
        if(holder.length < size()){
            holder = (E[]) Array.newInstance(holder.getClass().getComponentType(),size());
        }

        for (int i = size()-1; i >=0; i--) {
            holder[i] = stack.get(i);
        }
        return holder;
    }

    /**
     * This method check whether the specified obejct exist in the stack or not.
     * @param toFind
     *            element whose presence in this list is to be tested.
     * @return
     * @throws NullPointerException exception is thrown when encounter Null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(nullCheck(toFind)){
            throw new NullPointerException();
        }
        boolean check = false;
        boolean stop = true;
        for (int i = size()-1; i >=0 && stop; i--) {
            if(stack.get(i).equals(toFind)){
                check  = true;
                stop = false;
            }
        }
        return check;
    }

    /**
     * This method find specified element
     * @param toFind
     *            the desired object.
     * @return index of the position or the -1 if nothing is found.
     */
    @Override
    public int search(E toFind) {
        int position = indexOf(toFind);
        if (position !=0){
            return position;
        }else{
            return position = -1;
        }
    }

    /**
     Method to iterator over the element without the use of the index.
     * @return a iterator to iterate over the elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayBasedIterator();
    }

    /**
     * This compare that two of the Queue ADT are the infact equal to each other. In every single way
     * This method even check of null the length are the same in every way possible.
     *
     * @param that the Stack ADT to be compared to this stack.
     * @return a boolean based on the if they are equals or not
     */
    @Override
    public boolean equals(StackADT<E> that) {
        boolean check = true;
        Object compareTo[] = (E[])that.toArray();
        Object mainArr []  = toArray();
        check = compareTo.length > mainArr.length ? false :
                compareTo.length < mainArr.length ? false : true;

        for (int i = size()-1; i >=0 && check; i--) {
            if(compareTo[i] == null || mainArr[i] == null){
                throw new NullPointerException();
            }else if(!(compareTo[i].equals(mainArr[i]))){
                check = false;
            }
        }
        return check;
    }
    /**
     * This to keep stack of the size
     * @return the size of the array.
     */
    @Override
    public int size() {
        return stack.size();
    }
    /*-------------Private Methods-----------*/

    /**
     * This method check for the null value
     * @param toAdd a specified element
     * @return a boolean wheather is filed or passed.
     */
    private boolean nullCheck(E toAdd){
        boolean check = false;
        if(toAdd == null){
            check = true;
        }
        return check;
    }

    /**
     * This methos return the index of the element that is being passed from the parent method.
     * @param toFind
     * @return
     */
    private int  indexOf(E toFind) {
        int position =0;
        int counter = 0;
        boolean stop = true;
        
        for (int i = size()-1; i >=0 && stop; i--) {
            if(toFind.equals(stack.get(i))){
                position = counter;
                position++;
                stop = false;
            }
            counter++;
        }
        return position;
    }


    /**
     * Private class being called by the iterator method in the class.
     * References:
     *          1. Code was provided in the class by the instructor
     */
    private class ArrayBasedIterator implements Iterator<E> {
        private E[] CopyofElementl;
        private int pos = stack.size()-1;

        /**
         * This constructor make the apporiate size array and copying all the element to the to the new array.
         */
        public ArrayBasedIterator() {
            Object [] tStack  = stack.toArray();
            CopyofElementl = (E[]) (new Object[size()]);
            System.arraycopy(tStack,0,CopyofElementl,0,CopyofElementl.length);
        }

        /**
         * This method check for the if the array have more element to iterator over.
         * @return more element to iterator over.
         */
        @Override
        public boolean hasNext() {
//            return pos <CopyofElementl.length;
            return  pos >= 0;
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
                pos--;
                return toReturn;
            }catch(IndexOutOfBoundsException e){
                throw new NoSuchElementException();
            }

        }

    }
    public static void main(String[] args) {
		Stack<String> l = new Stack<String>();
		l.push(1+"");
		l.push(2+"");
		l.push(3+"");
        l.push(4+"");
		Stack<String> s = new Stack<String>();
		s.push(1+"");
		s.push(2+"");
		s.push(3+"");
		s.equals(l);
            System.out.println(s.equals(l));
		
	}

}
