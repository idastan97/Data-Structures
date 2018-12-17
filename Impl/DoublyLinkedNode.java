/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;

/**
 *
 * @author Админ
 * @param <T>
 */
public class DoublyLinkedNode<T> {
    private T value;
    private DoublyLinkedNode prev;
    private DoublyLinkedNode next;
    
    public DoublyLinkedNode(T v){
        value=v;
        prev=null;
        next=null;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the prev
     */
    public DoublyLinkedNode getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(DoublyLinkedNode prev) {
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public DoublyLinkedNode getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }
    
    /**
     * @return the string representation of the value 
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
