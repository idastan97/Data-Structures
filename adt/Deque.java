/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.adt;

/**
 *
 * @author Админ
 * @param <T>
 */
public interface Deque<T> {
    /**
     * 
     * @param value 
     */
    public void pushToFront(T value);
    
    /**
     * 
     * @param value 
     */
    public void pushToBack(T value);
    
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    public T popFromFront() throws Exception;
    
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    public T popFromBack() throws Exception;
    
    /**
     * @return the size of the queue
     */
    public int getSize();
    
    /**
     * Removes all elements from the queue
     */
    public void clear();
    
    /**
     * @return a String representation of the queue
     */
    @Override
    public String toString();
}
