/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.SortedQueue;

/**
 *
 * @author Dastan Iyembergen
 * @param <T>
 */
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T>{

    private Node<T> front;
    private int size;
    
    public LinkedListSortedQueue(){
        front=null;
        size=0;
    }
    
    @Override
    public void insert(Comparable value) {
        Node<T> newNode=new Node(value);
        if (size==0){
            front=newNode;
        } else {
            if (value.compareTo(front.getValue())<=0){
                newNode.setLink(front);
                front=newNode;
            } else {
                Node<T> tmpNode=front;
                while (tmpNode.getLink()!=null && value.compareTo(tmpNode.getLink().getValue())>0){
                    tmpNode=tmpNode.getLink();
                }
                newNode.setLink(tmpNode.getLink());
                tmpNode.setLink(newNode);
            }
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
