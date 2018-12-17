/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Deque;

/**
 *
 * @author Админ
 * @param <T>
 */
public class LinkedListDeque<T> implements Deque<T>{
    
    DoublyLinkedNode<T> front;
    DoublyLinkedNode<T> back;
    int size;
    
    public LinkedListDeque(){
        size=0;
        front=null;
        back=null;
    }

    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode=new DoublyLinkedNode(value);
        if (size==0){
            front=newNode;
            back=newNode;
        } else {
            newNode.setNext(front);
            front.setPrev(newNode);
            front=newNode;
        }
        size++;
    }

    @Override
    public void pushToBack(T value) {
       DoublyLinkedNode<T> newNode=new DoublyLinkedNode(value);
        if (size==0){
            front=newNode;
            back=newNode;
        } else {
            newNode.setPrev(back);
            back.setNext(newNode);
            back=newNode;
        }
        size++; 
    }

    @Override
    public T popFromFront() throws Exception{
        if (size==0){
            throw new Exception("The deque is empty.");
        }
        T res;
        res=front.getValue();
        if (size==1){
            front=null;
            back=null;
        } else {
            front=front.getNext();
            front.setPrev(null);
        }
        size--;
        return res;
    }

    @Override
    public T popFromBack() throws Exception{
        if (size==0){
            throw new Exception("The deque is empty.");
        }
        T res;
        res=back.getValue();
        if (size==1){
            front=null;
            back=null;
        } else {
            back=back.getPrev();
            back.setNext(null);
        }
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size=0;
        front=null;
        back=null;
    }
    
    @Override
    public String toString(){
        String res="front[";
        DoublyLinkedNode next=front;
        while (next!=null){
            res+=next.getValue();
            next=next.getNext();
            if (next!=null){
                res+=", ";
            }
        }
        res+="]back";
        return res;
    }
    
}
