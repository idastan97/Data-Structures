/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.Impl;
import csci152.adt.Set;

/**
 *
 * @author Админ
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root=null;
        size=0;
    }
    
    @Override
    public void add(T value) {
        if (size==0){
            root=new TreeNode(value);
            size++;
        } else {
            addHelper(value, root);
        }
    }
    
    private void addHelper(T value, TreeNode<T> r){
        if (value.compareTo(r.getValue())<0){
            if (r.getLeft()!=null){
                addHelper(value, r.getLeft());
            } else {
                r.setLeft(new TreeNode(value));
                size++;
            }
        } else if (value.compareTo(r.getValue())>0){
            if (r.getRight()!=null){
                addHelper(value, r.getRight());
            } else {
                r.setRight(new TreeNode(value));
                size++;
            }
        }
    }

    @Override
    public boolean contains(T value) {
        if (size==0){
            return false;
        }
        return containsHelper(value, root);
    }
    
    private boolean containsHelper(T value, TreeNode<T> r){
        if (value.compareTo(r.getValue())==0){
            return true;
        } else if (value.compareTo(r.getValue())<0){
            if (r.getLeft()!=null){
                return containsHelper(value, r.getLeft());
            } else {
                return false;
            }
        } else {
            if (r.getRight()!=null){
                return containsHelper(value, r.getRight());
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean remove(T value) {
        TreeNode<T> c=root, p=null;
        while (c!=null){
            if (value.compareTo(c.getValue())>0){
                p=c;
                c=c.getRight();
            } else if (value.compareTo(c.getValue())<0){
                p=c;
                c=c.getLeft();
            } else {
                removeNode(p, c);
                return true;
            }
        }
        return false;
    }
    
    private void removeNode(TreeNode<T> p, TreeNode<T> c){
        if (c.getLeft()==null){
            if (p!=null){
                if (c==p.getRight()){
                    p.setRight(c.getRight());
                } else {
                    p.setLeft(c.getRight());
                }
            } else {
                root=c.getRight();
            }
        } else if (c.getRight()==null){
            if (p!=null){
                if (c==p.getRight()){
                    p.setRight(c.getLeft());
                } else {
                    p.setLeft(c.getLeft());
                }
            } else {
                root=c.getLeft();
            }
        } else {
            if (c.getRight().getLeft()!=null){
                TreeNode<T> prs=findParentOfSmallest(c.getRight(), 
                        c.getRight().getLeft());
                c.setValue(prs.getLeft().getValue());
                removeNode(prs, prs.getLeft());
                return;
            } else {
                c.setValue(c.getRight().getValue());
                removeNode(c, c.getRight());
                return;
            }
        }
        size--;
    }
    
    private TreeNode<T> findParentOfSmallest(TreeNode<T> p, TreeNode<T> c){
        if (c.getLeft()!=null){
            return findParentOfSmallest(c, c.getLeft());
        } else {
            return p;
        }
    }
    
    @Override
    public T removeAny() throws Exception {
        if (size==0){
            throw new Exception("The set is empty.");
        }
        T res=root.getValue();
        removeNode(null, root);
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root=null;
        size=0;
    }
    
    @Override
    public String toString(){
        return toStringHelper(root);
    }
    
    private String toStringHelper(TreeNode<T> r){
        if (r==null){
            return "";
        }
        return toStringHelper(r.getLeft()) + " " + r.getValue() + " " + 
                toStringHelper(r.getRight());
    }
}
