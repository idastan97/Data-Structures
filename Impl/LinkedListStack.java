/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Stack;

/**
 *
 * @author Админ
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T>{
    
    private Node<T> top;
    int size;
    
    public LinkedListStack(){
        top=null;
        size=0;
    }
    
    @Override
    public void push(T value) {
        Node<T> newNode=new Node(value);
        newNode.setLink(top);
        top=newNode;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size==0){
            throw new Exception("The stack is empty.");
        }
        T res=top.getValue();
        top=top.getLink();
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top=null;
        size=0;
    }
    
    @Override
    public String toString(){
        Node next=top;
        String list="]top";
        while (next!=null){
            list=next.getValue()+list;
            next=next.getLink();
            if (next!=null){
                list=", "+list;
            }
        }
        return "bottom["+list;
    }
}
