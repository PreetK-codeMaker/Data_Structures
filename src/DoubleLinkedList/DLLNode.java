package DoubleLinkedList;

import java.io.Serializable;
/**
        * This Class created nodes that will be used in the used in the Double linked list
        * This class will help with the next and Before refernces of the Double linked List.
        * It also Implemets Serializable to help with persistance of the obejct if the use choose to do so.s
        *
        * References = 1. CPRG251 Assignment 5 Single linked list,
        *              2. Data Structures and Absrtactions with Java By Frank M.Carrano and Timothy M.Henry
        *              3. https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
        * */

public class DLLNode<E> implements Serializable {
    private static final long serialVersionUID = 88874821482485214L;
    private E element;
    private DLLNode<E> next;
    private DLLNode<E> prev;

    public DLLNode(E element , DLLNode next, DLLNode prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    /**
     * This method is to set specifed type of element
     * @param o is specified type of element by the user
     */
    public DLLNode(E o){
        this.element = o;
        this.next = null;
        this.prev = null;
    }

    /**
     * This method takes DLLNode and sets it.
     * @param next a DLLNode.
     */
    public void setNext(DLLNode next){
        this.next = next;
    }

    /**
     * This method tales DLLNode and sets it.
     * @param prev a DLLNode
     */
    public void setPrev(DLLNode prev){
        this.prev = prev;
    }


    /**
     * This method return the value of the of teh Next
     * @return a DLLNode of next
     */
    public DLLNode getNext(){
        return next;
    }

    /**
     * This method return the value of the of teh Next
     * @return a DLLNode of next
     */
    public DLLNode getPrev(){
        return prev;
    }
    /**
     * This method returns the value of the node.
     * @return a specifed type pf element set by the user.
     */

    public Object getElement(){
        return element;
    }

    /**
     * This Method set the specified element by the user.
     * @param element is specified element by the user.
     */
    public void setElement(E element){
        this.element = element;
    }
}
