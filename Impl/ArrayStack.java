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
public class ArrayStack<T> implements Stack<T>{
    private T[] values;
    private int size;
    
    public ArrayStack(){
        values=(T[]) new Object[10];
        size=0;
    }
    
    @Override
    public void push(T value) {
        if (size==values.length){
            T[] tmpArr=(T[]) new Object[2*values.length];
            for (int i=0; i<values.length; i++)
                tmpArr[i]=values[i];
            values=tmpArr;
        }
        values[size++]=value;
    }

    @Override
    public T pop() throws Exception {
        if (size<=0){
            throw new Exception("The stack is empty.");
        }
        T res=values[size-1];
        values[size-1]=null;
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values=(T[]) new Object[10];
        size=0;
    }
    
    @Override
    public String toString(){
        String list="bottom[";
        for (int i=0; i<size; i++){
            list+=values[i];
            if (i<size-1)
            list+=", ";
        }
        return list+"]top";
    }
}
