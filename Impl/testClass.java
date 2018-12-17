/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Map;

/**
 *
 * @author Dastan Iyembergen
 */
public class testClass {
    
    public static void main(String[] args){
        Map<Integer, String> mp=new LLStackMap();
        
        try {
            System.out.println(mp.removeAny());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Size: "+mp.getSize()+'\n'+mp);
        
        mp.define(5, "zxcvb");
        mp.define(6, "qwerty");
        mp.define(1, "vfvd");
        mp.define(152, "ttt");
        mp.define(789, "ppp");
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        System.out.println("Remove 1: "+mp.remove(1));
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        System.out.println("Remove 99: "+mp.remove(99));
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        mp.define(5, "newfive");
        mp.define(6, "newsix");
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        mp.define(10, "ten");
        mp.define(11, "e");
        mp.define(12, "t");
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        try {
            System.out.println("Remove any: "+mp.removeAny());
            System.out.println("Remove any: "+mp.removeAny());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        mp.clear();
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
        
        mp.define(100, "hndrd");
        mp.define(200, "thndrd");
        System.out.println("Size: "+mp.getSize()+'\n'+mp+'\n');
    }
}
