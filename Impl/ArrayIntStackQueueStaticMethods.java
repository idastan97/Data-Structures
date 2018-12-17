/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;

import csci152.adt.Queue;
import csci152.adt.Stack;

/**
 *
 * @author Админ
 */
public class ArrayIntStackQueueStaticMethods {
    
    public static int evenCount(Stack<Integer> stk){
        Stack<Integer> temp=new ArrayStack();
        int s=stk.getSize(), cnt=0;
        for (int i=0; i<s; i++){
            int x;
            try {
               x=stk.pop();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                x=1;
            }
            if (x%2==0){
                cnt++;
            }
            temp.push(x);
        }
        for (int i=0; i<s; i++){
            try {
                stk.push(temp.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cnt;
    }
    
    public static Stack<Integer> copyStack(Stack<Integer> orig) {
        Stack<Integer> res=new ArrayStack(), temp=new ArrayStack();
        int s=orig.getSize();
        for (int i=0; i<s; i++){
            try {
                temp.push(orig.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        for (int i=0; i<s; i++){
            try {
                int x=temp.pop();
                res.push(x);
                orig.push(x);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return res;
    }
    
    public static Queue<Integer> copyQueue(Queue<Integer> orig){
        Queue<Integer> res=new ArrayQueue();
        int s=orig.getSize();
        for (int i=0; i<s; i++){
            int x;
            try{
                x=orig.dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                x=0;
            }
            orig.enqueue(x);
            res.enqueue(x);
        }
        return res;
    }

    public static void reverseStack(Stack<Integer> toRev){
        Queue<Integer> tempQueue=new ArrayQueue();
        int s=toRev.getSize();
        for (int i=0; i<s; i++){
            try{
                tempQueue.enqueue(toRev.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        for (int i=0; i<s; i++){
            try{
                toRev.push(tempQueue.dequeue());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void reverseQueue(Queue<Integer> toRev){
        Stack<Integer> tempStack=new ArrayStack();
        int s=toRev.getSize();
        for (int i=0; i<s; i++){
            try{
                tempStack.push(toRev.dequeue());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        for (int i=0; i<s; i++){
            try{
                toRev.enqueue(tempStack.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static boolean isPalindrome(Queue<Integer> q){
        Stack<Integer> tempStack=new ArrayStack();
        Queue<Integer> tempQueue=new ArrayQueue();
        int s=q.getSize();
        for (int i=0; i<s; i++){
            int x;
            try {
                x=q.dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                x=0;
            }
            tempStack.push(x);
            tempQueue.enqueue(x);
            q.enqueue(x);
        }
        boolean res=true;
        for (int i=0; i<s; i++){
            try {
                if (tempStack.pop()!=tempQueue.dequeue()){
                    res=false;
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return res;
    }
    
    public static void insert(Stack<Integer> st, int pos, int val){
        int s=st.getSize();
        Stack<Integer> tempStack=new ArrayStack();
        for (int i=0; i<s+1-pos; i++){
            try {
                tempStack.push(st.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        st.push(val);
        for (int i=0; i<s+1-pos; i++){
            try {
                st.push(tempStack.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static Stack<Integer> merge(Stack<Integer> s1, Stack<Integer> s2){
        Stack<Integer> tempStack=new ArrayStack(), resStack=new ArrayStack();
        while (s1.getSize()>0 || s2.getSize()>0){
            if (s1.getSize()>0 && s2.getSize()>0){
                int x, y;
                try {
                    x=s1.pop();
                    y=s2.pop();
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    x=0;
                    y=0;
                }
                if (x>=y){
                    tempStack.push(x);
                    s2.push(y);
                } else {
                    tempStack.push(y);
                    s1.push(x);
                }
            } else if (s1.getSize()>0){
                try{
                    tempStack.push(s1.pop());
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            } else {
                try{
                    tempStack.push(s2.pop());
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        int s=tempStack.getSize();
        for (int i=0; i<s; i++){
            try {
                resStack.push(tempStack.pop());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resStack;
    }
}
