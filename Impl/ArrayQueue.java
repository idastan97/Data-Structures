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
public class ArrayQueue<T> implements Queue<T> {
    
    private T[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue(){
        values=(T[]) new Object[10];
        size=0;
        front=0;
        back=9;
    }
    
    @Override
    public void enqueue(T value) {
        if (size==values.length){
            int i=front, j=0;
            T[] tmp=(T[]) new Object[2*values.length];
            do {
                tmp[j++]=values[i++];
                i%=values.length;
            } while (i!=front);
            values=tmp;
            front=0;
            back=j-1;
        }
        back=(++back)%values.length;
        values[back]=value;
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size==0){
            throw new Exception("The queue is empty.");
        }
        T result=values[front];
        values[front++]=null;
        front%=values.length;
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values=(T[]) new Object[10];
        size=0;
        front=0;
        back=9;
    }
    
    @Override
    public String toString(){
        String res="front[";
        int i=front, j=0, c=0;
        while (c<size) {
            res+=values[i++];
            i%=values.length;
            if (c<size-1){
                res+=", ";
            }
            c++;
        }
        res+="]back";
        return res;
    }
}
