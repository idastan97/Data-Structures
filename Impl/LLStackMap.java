/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Map;

/**
 *
 * @author Админ
 * @param <K>
 * @param <V>
 */
public class LLStackMap<K, V> implements Map<K, V> {
    
    private LinkedListStack<KeyValuePair<K, V>> pairs;
    
    public LLStackMap(){
        pairs = new LinkedListStack();
    }
    
    @Override
    public void define(K key, V value) {
        LinkedListStack<KeyValuePair<K, V>> tmpStack = new LinkedListStack();
        int ss=pairs.getSize();
        boolean found=false;
        for (int i=0; i<ss; i++){
            KeyValuePair<K, V> x=null;
            try {
                x=pairs.pop();
            } catch (Exception ex){
                
            }
            if (key.equals(x.getKey())) {
                tmpStack.push(new KeyValuePair(key, value));
                found=true;
            } else {
                tmpStack.push(x);
            }
        }
        if (!found){
            tmpStack.push(new KeyValuePair(key, value));
        }
        pairs=tmpStack;
    }

    @Override
    public V getValue(K key) {
        LinkedListStack<KeyValuePair<K, V>> tmpStack = new LinkedListStack();
        int ss=pairs.getSize();
        V res=null;
        for (int i=0; i<ss; i++){
            KeyValuePair<K, V> x=null;
            try {
                x=pairs.pop();
            } catch (Exception ex){
                
            }
            if (key.equals(x.getKey())) {
                res=x.getValue();
            }
            tmpStack.push(x);
        }
        pairs=tmpStack;
        return res;
    }

    @Override
    public V remove(K key) {
        LinkedListStack<KeyValuePair<K, V>> tmpStack = new LinkedListStack();
        int ss=pairs.getSize();
        V res=null;
        for (int i=0; i<ss; i++){
            KeyValuePair<K, V> x=null;
            try {
                x=pairs.pop();
            } catch (Exception ex){
                
            }
            if (key.equals(x.getKey())) {
                res=x.getValue();
            } else {
                tmpStack.push(x);
            }
        }
        pairs=tmpStack;
        return res;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (pairs.getSize()==0){
            throw new Exception("The map is empty.");
        }
        return pairs.pop();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs=new LinkedListStack();
    }
    
    @Override
    public String toString(){
        LinkedListStack<KeyValuePair<K, V>> tmpStack = new LinkedListStack();
        int ss=pairs.getSize();
        String res="";
        for (int i=0; i<ss; i++){
            KeyValuePair<K, V> x=null;
            try {
                x=pairs.pop();
            } catch (Exception ex){
                
            }
            res+=x+"  ";
            tmpStack.push(x);
        }
        pairs=tmpStack;
        return res;
    }
}
