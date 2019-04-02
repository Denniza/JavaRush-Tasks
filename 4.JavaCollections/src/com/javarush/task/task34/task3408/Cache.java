package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V result = cache.get(key);
        if(result!=null) return result;
        Constructor constructor = clazz.getConstructor(key.getClass());//TODO add your code here
        result = (V) constructor.newInstance(key);
        cache.put(key,result);
        return result;
    }

    public boolean put(V obj) {
        try{
        Method method = obj.getClass().getDeclaredMethod("getKey");
        method.setAccessible(true);
        K result = (K) method.invoke(obj);
        cache.put(result,obj);//TODO add your code here
        return true;}
        catch (Exception e){
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
