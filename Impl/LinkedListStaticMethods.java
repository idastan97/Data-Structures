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
public class LinkedListStaticMethods {
    
    public static boolean isIncreasing(Stack<Double> st){
        Stack<Double> tmp=new LinkedListStack();
        boolean res=true;
        while (st.getSize()>0){
            try{
                tmp.push(st.pop());
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        if (tmp.getSize()>0){
            double prev;
            try{
                prev=tmp.pop();
                st.push(prev);
            } catch(Exception ex){
                System.out.println(ex.getMessage());
                prev=0.0;
            }
            while (tmp.getSize()>0){
                try{
                    double newDouble=tmp.pop();
                    if (res && newDouble<prev){
                        res=false;
                    }
                    prev=newDouble;
                    st.push(prev);
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return res;
    }
    
    public static boolean isBalanced(Queue<Character> q) throws Exception{
        boolean res=true, ex=false;
        Stack<Character> tmpSt=new LinkedListStack();
        int quSize=q.getSize();
        for (int i=0; i<quSize; i++){
            char tmpC=q.dequeue();
            q.enqueue(tmpC);
            if (tmpC=='(' || tmpC=='[' || tmpC=='{'){
                tmpSt.push(tmpC);
            } else if (tmpC==')' || tmpC==']' || tmpC=='}'){
                if (tmpC==')'){
                    tmpC='(';
                } else if (tmpC==']'){
                    tmpC='[';
                } else if (tmpC=='}'){
                    tmpC='{';
                }
                if (tmpSt.getSize()==0 || tmpSt.pop()!=tmpC){
                    res=false;
                }
            } else {
                ex=true;
            }
        }
        if (ex){
            throw new Exception("Illegel character was found.");
        }
        return res;
    }
    
    public static boolean isPalindrome(Queue<Character> q){
        Stack<Character> tempStack=new LinkedListStack();
        Queue<Character> tempQueue=new LinkedListQueue();
        int s=q.getSize();
        for (int i=0; i<s; i++){
            char x;
            try {
                x=q.dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                x=' ';
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
}
