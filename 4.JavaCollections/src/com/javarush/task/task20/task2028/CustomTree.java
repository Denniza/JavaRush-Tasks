package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String>  implements Cloneable, Serializable {

    Entry<String> root;
    ArrayList<Entry> elements = new ArrayList<>();
    ArrayDeque<Entry> levelMap = new ArrayDeque<>();
    boolean flag = false;

    public CustomTree(){
        this.root = new Entry<>("Root");
    }

    @Override
    public String set(int i, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int i, String s) {
        throw new UnsupportedOperationException();

    }

    @Override
    public String remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends String> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int size() {

        return elements.size();
    }
    public boolean remove (Object o){
        if(!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        String name = (String) o;
        levelMap.addFirst(root);
        flag = false;
        while(!levelMap.isEmpty()) {
            Entry current = levelMap.getLast();
            if (current.leftChild!=null&&current.leftChild.elementName.equals(name)) {
                elements.remove(current.leftChild);
                levelMap.clear();
                levelMap.addFirst(current.leftChild);
                current.leftChild = null;
                current.availableToAddLeftChildren = false;
                flag=true;
            } else if (current.rightChild!=null&&current.rightChild.elementName.equals(name)) {
                elements.remove(current.rightChild);
                levelMap.clear();
                levelMap.addFirst(current.rightChild);
                current.rightChild = null;
                current.availableToAddRightChildren = false;
                flag = true;
            } else {
                if (flag == true) {
                    elements.remove(current);}
                    if(current.leftChild!=null) levelMap.addFirst(current.leftChild);
                    if(current.rightChild!=null)levelMap.addFirst(current.rightChild);
                    levelMap.removeLast();
                }
            }
        return false;
    }

    public String getParent(String s){
        String result=null;
        for(Entry b : elements) {
            if (b.elementName.equals(s)) return b.parent.elementName;
        }
        return result;
    }

    @Override
    public boolean add(String s) {
        Entry element = new Entry(s);
        levelMap.addFirst(root);
        while (!levelMap.isEmpty()) {
            Entry current = levelMap.getLast();
            if(current.isAvailableToAddChildren()){
                if(current.availableToAddLeftChildren){
                    current.leftChild = element;
                    element.parent = current;
                    current.checkChildren();
                    elements.add(element);
                    levelMap.clear();
                    return true;
                }
                if(current.availableToAddRightChildren) {
                    current.rightChild = element;
                    element.parent = current;
                    current.checkChildren();
                    elements.add(element);
                    levelMap.clear();
                    return true;
                }
            } else {
                if(current.leftChild!=null) levelMap.addFirst(current.leftChild);
                if(current.rightChild!=null)levelMap.addFirst(current.rightChild);
            }
            levelMap.removeLast();
        }
        levelMap.addFirst(root);
        while (!levelMap.isEmpty()) {
            Entry current = levelMap.getLast();
            if(current.leftChild==null) current.availableToAddLeftChildren = true;
            else levelMap.addFirst(current.leftChild);
            if(current.rightChild==null) current.availableToAddRightChildren = true;
            else levelMap.addFirst(current.rightChild);
            levelMap.removeLast();
        }
        this.add(s);
        return true;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren,availableToAddRightChildren;
        Entry<T> parent,leftChild,rightChild;

        public Entry (String a){
            this.elementName = a;
            this.availableToAddLeftChildren=true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren(){
            if(this.leftChild != null) this.availableToAddLeftChildren = false;
            if(this.rightChild !=null) this.availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren(){
            return this.availableToAddLeftChildren||this.availableToAddRightChildren;
        }

    }
}
