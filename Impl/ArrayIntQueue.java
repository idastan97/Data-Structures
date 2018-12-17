/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.IntQueue;

/**
 *
 * @author Админ
 */
public class ArrayIntQueue implements IntQueue{
    
    private int[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayIntQueue(){
        values=new int[10];
        size=0;
        front=0;
        back=9;
    }
    
    @Override
    public void enqueue(int value) {
        if (size==values.length){
            int i=front, j=0;
            int[] tmp=new int[2*values.length];
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
    public int dequeue() throws Exception {
        if (size==0){
            throw new Exception("The queue is empty.");
        }
        int result=values[front++];
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
        values=new int[10];
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
