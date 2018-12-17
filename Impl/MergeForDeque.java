/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Deque;

/**
 *
 * @author Админ
 */
public class MergeForDeque {
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
        /* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
        int s1=d1.getSize(), s2=d2.getSize();
        Deque<Integer> resD=new LinkedListDeque();
        while (s1>0 || s2>0){
            if (s1>0 && s2>0){
                int x, y;
                try {
                    x=d1.popFromFront();
                    y=d2.popFromFront();
                } catch (Exception ex){
                    x=0;
                    y=0;
                }
                if (x<=y){
                    resD.pushToBack(x);
                    s1--;
                    d1.pushToBack(x);
                    d2.pushToFront(y);
                } else {
                    resD.pushToBack(y);
                    s2--;
                    d2.pushToBack(y);
                    d1.pushToFront(x);
                }
            } else if (s2==0){
                int x;
                try {
                    x=d1.popFromFront();
                } catch (Exception ex){
                    x=0;
                }
                resD.pushToBack(x);
                s1--;
                d1.pushToBack(x);
            } else {
                int y;
                try {
                    y=d2.popFromFront();
                } catch (Exception ex){
                    y=0;
                }
                resD.pushToBack(y);
                s2--;
                d2.pushToBack(y);
            }
        }
        return resD;
    }

    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
        /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
         */
        int s=deq.getSize(), hs=deq.getSize()/2;
        if (s<=1){
            return deq;
        }
        Deque<Integer> d1=new LinkedListDeque(), d2=new LinkedListDeque();
        while (s>hs){
            int x;
            try{
                x=deq.popFromFront();
            } catch (Exception ex){
                x=0;
            }
            d1.pushToBack(x);
            deq.pushToBack(x);
            s--;
        }
        while (s>0){
            int y;
            try{
                y=deq.popFromFront();
            } catch (Exception ex){
                y=0;
            }
            d2.pushToBack(y);
            deq.pushToBack(y);
            s--;
        }
        d1=mergeSort(d1);
        d2=mergeSort(d2);
        Deque<Integer> resD=merge(d1, d2);
        return resD;
    }
}
