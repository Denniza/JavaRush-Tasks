package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {

    public static void main(String[] args) {
        HashSet set = new HashSet();

    }

    private final static Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity= Math.max(16,(int)Math.floor(collection.size()/.75f)+1);
        this.map = new HashMap<>(capacity);
        for(E e:collection){
            map.put(e,PRESENT);
        }
    }
     public boolean add(Object e){

        return null==map.put((E) e,PRESENT);
     }

    @Override
    public Iterator iterator() {
        Iterator iterator = map.keySet().iterator();
        return iterator;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {

        if(map.remove(o)!=null) return true;
        else return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone(){
        try{
            AmigoSet set = new AmigoSet();
            set.map = (HashMap) map.clone();
        return set;}
        catch (Exception e){
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream outputStream)throws IOException{
        outputStream.defaultWriteObject();
        outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        outputStream.writeInt(map.keySet().size());
        for(E e:map.keySet()) outputStream.writeObject(e);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AmigoSet<?> amigoSet = (AmigoSet<?>) o;
        return Objects.equals(map, amigoSet.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), map);
    }

    private void readObject (ObjectInputStream inputStream) throws IOException, ClassNotFoundException{
        inputStream.defaultReadObject();
        int capacity = inputStream.readInt();
        float loadFactor = inputStream.readFloat();
        int size = inputStream.readInt();

        map = new HashMap(capacity,loadFactor);

        for(int i=0; i<size ;i++){
            E e = (E) inputStream.readObject();
            map.put(e,PRESENT);
        }



    }
}
