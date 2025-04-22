package Map;

import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashTableDemo<K, V> {
    private Entry<K,V> [] data;
    private static final int INITIAL_CAPACITY = 10;
    public HashTableDemo(int capacity){
        data = new Entry[capacity];
    }

    public HashTableDemo() {
        this(INITIAL_CAPACITY);
    }
    private int hashFunction(K key){
        return Math.abs(key.hashCode()%data.length);
    }
    public void put(K key, V val){
        int index = hashFunction(key);
        while(data[index] != null){
            index++;
            if(index > data.length-1){
                index =0;
            }
        }
        data[index] = new Entry<>(key , val);

    }
    public boolean contains(K k){
        for (int i = 0; i < data.length; i++) {
            if(data[i]!= null && data[i].k.equals(k))
                return true;
        }
        return false;
    }
    public boolean remove(K key){
        int index = hashFunction(key);
        while(data[index] != null && data[index].k.equals(key)){
            data[index] = null;
            return true;

        }
        return false;
    }
    public void print() {

        for (int i = 0; i < data.length; i++) {
            if(data[i] != null) {
                System.out.print("[ Key = " + data[i].k +" Value = "+ data[i].v + " ]");
            } else
                System.out.print(" [ "+ data[i]+ " ] ");

        }
        System.out.println();
    }
    private class Entry<K,V>{
        K k;
        V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
