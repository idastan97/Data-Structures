/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.IntStack;
/**
 *
 * @author Админ
 */
public class ArrayIntStack implements IntStack{
    
    private int[] values;
    private int size;
    
    public ArrayIntStack(){
        values=new int[10];
        size=0;
    }
    
    @Override
    public void push(int value) {
        if (size==values.length){
            int[] tmpArr=new int[2*values.length];
            for (int i=0; i<values.length; i++)
                tmpArr[i]=values[i];
            values=tmpArr;
        }
        values[size++]=value;
    }

    @Override
    public int pop() throws Exception {
        if (size<=0){
            throw new Exception("The stack is empty.");
        }
        return values[(size--)-1];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values=new int[10];
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
