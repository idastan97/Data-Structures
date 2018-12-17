/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Set;
import csci152.adt.Queue;

/**
 *
 * @author Dastan Iyembergen
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T>{
    
    Queue<T> values;
    
    public LLQueueSet(){
        values=new LinkedListQueue();
    }
    
    @Override
    public void add(T value) {
        if (!contains(value)){
            values.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i=0; i<values.getSize(); i++){
            try {
                T x=values.dequeue();
                values.enqueue(x);
                if (x.equals(value)){
                    return true;
                }
            } catch (Exception ex){
                //This shouldn't happen
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        for (int i=0; i<values.getSize(); i++){
            try {
                T x=values.dequeue();
                if (x.equals(value)){
                    return true;
                }
                values.enqueue(x);
            } catch (Exception ex){
                //This shouldn't happen
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        try {
            return values.dequeue();
        } catch (Exception ex){
            throw new Exception("The set is empty.");
        }
    }

    @Override
    public int getSize() {
        return values.getSize();
    }

    @Override
    public void clear() {
        values.clear();
    }
    
    @Override
    public String toString(){
        String res="";
        for (int i=0; i<values.getSize(); i++){
            try {
                T x=values.dequeue();
                values.enqueue(x);
                res=res+x+" ";
            } catch (Exception ex){
                //This shouldn't happen
            }
        }
        return res;
    }
    
}
