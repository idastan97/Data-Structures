/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;

/**
 *
 * @author Dastan Iyembergen
 */
public class Student implements Comparable<Student>{
    private final int id;
    private final String name;
    
    public Student(String n, int i){
        id=i;
        name=n;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public int compareTo(Student s){
        return id-s.getId();
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student sobj=(Student) obj;
            return (id==sobj.id && name.equals(sobj.name));
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return id;
    }
    
    @Override
    public String toString(){
        return '['+name+"; "+id+"]";
    }
}
