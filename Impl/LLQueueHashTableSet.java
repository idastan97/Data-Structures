/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.HashTableSet;
import static java.lang.Math.sqrt;
import java.util.Random;
import csci152.adt.Set;

/**
 *
 * @author dastan Iyembergen
 * @param <T>
 */
public class LLQueueHashTableSet<T> implements HashTableSet<T> {
    
    private Set<T>[] buckets;
    private int size;
    
    public LLQueueHashTableSet(int numBuckets){
        buckets = new LLQueueSet[numBuckets];
        size=0;
    }
    
    private int hbucket(T value){
        int hb=value.hashCode();
        if (hb<0) {
            hb=-hb;
        }
        hb%=buckets.length;
        return hb;
    }
    
    @Override
    public void add(T value) {
        int hb=hbucket(value);
        if (buckets[hb]==null){
            buckets[hb]=new LLQueueSet();
        }
        int pr=buckets[hb].getSize();
        buckets[hb].add(value);
        size+=(buckets[hb].getSize()-pr);
    }

    @Override
    public boolean contains(T value) {
        int hb=hbucket(value);
        if (buckets[hb]==null){
            return false;
        }
        return buckets[hb].contains(value);
    }

    @Override
    public boolean remove(T value) {
        int hb=hbucket(value);
        if (buckets[hb]==null){
            return false;
        }
        boolean res=buckets[hb].remove(value);
        if (res){
            if (buckets[hb].getSize()==0){
                buckets[hb]=null;
            }
            size--;
        }
        return res;
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0){
            throw new Exception("The set is empty. ");
        }
        Random rn = new Random();
        int ind=rn.nextInt(buckets.length);
        while (true){
            ind%=buckets.length;
            if (buckets[ind]!=null && buckets[ind].getSize()>0){
                size--;
                T res=buckets[ind].removeAny();
                if (buckets[ind].getSize()==0){
                    buckets[ind]=null;
                }
                return res;
            }
            ind++;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        int numBuckets=buckets.length;
        buckets = new LLQueueSet[numBuckets];
        size=0;
    }

    @Override
    public double getLoadFactor() {
        return (double)size/buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double ave=0, stdev=0;
        for (int i=0; i<buckets.length; i++){
            if (buckets[i]!=null){
                ave+=buckets[i].getSize();
            }
        }
        ave/=buckets.length;
        for (int i=0; i<buckets.length; i++){
            if (buckets[i]!=null){
                stdev+=(ave-buckets[i].getSize())*(ave-buckets[i].getSize());
            }
        }
        stdev=sqrt(stdev/(buckets.length-1));
        return stdev;
    }
    
    @Override
    public String bucketsToString(){
        return "load factor: "+getLoadFactor()+", StDev: "+getBucketSizeStandardDev();
    }
    
    @Override
    public String toString(){
        String res="";
        for (int i=0; i<buckets.length; i++){
            if (buckets[i]!=null){
                res+=buckets[i];
            }
        }
        return res;
    }
}
