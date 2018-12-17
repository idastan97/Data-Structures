/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.adt;

/**
 *
 * @author Админ
 */
public interface HashTableStats {
    
    public double getLoadFactor();
    
    public double getBucketSizeStandardDev();
    
    public String bucketsToString();
}
