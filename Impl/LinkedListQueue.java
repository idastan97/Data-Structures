/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Queue;
/**
 *
 * @author Админ
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T>{

    Node<T> front;
    Node<T> back;
    int size;
    
    public LinkedListQueue(){
        front=null;
        back=null;
        size=0;
    }
    
    @Override
    public void enqueue(T value) {
        Node<T> newNode=new Node(value);
        if (size==0){
            back=newNode;
            front=newNode;
        } else {
            back.setLink(newNode);
            back=newNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size==0){
            throw new Exception("The queue is empty.");
        }
        T res=front.getValue();
        front=front.getLink();
        if (size==1){
            back=null;
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
        front=null;
        back=null;
        size=0;
    }
    
    @Override
    public String toString(){
        String res="front[";
        Node next=front;
        while (next!=null){
            res+=next.getValue();
            next=next.getLink();
            if (next!=null){
                res+=", ";
            }
        }
        res+="]back";
        return res;
    }
}
