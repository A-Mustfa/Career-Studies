package Map;

import java.util.Date;
import java.util.LinkedList;

public class HashTableLinked<K,V> {
    private class Entry<K,V>{
        public K k;
        public V v;
        public Entry(K k, V v){
        this.k = k;
        this.v = v;
        }
    }
    private LinkedList<Entry<K,V>>[] data;
    private static final int CAPACITY=10;

    public HashTableLinked(){
// كده مفيش اي سلوت فاضيه كل سلوت في ال array عباره عن linkedlist
        data = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            data[i] = new LinkedList<>();
        }
    }
    private int hashFunction(K k){
        return Math.abs(k.hashCode()% data.length-1);
    }
//      1- calculate index with hash function
//    2- check if there is duplicte keys if found then overwrite and return; otherwise add the new entry
    public void put(K k,V v){
        int index = hashFunction(k);
        for(Entry<K,V> entr :data[index]){
            if(entr.k.equals(k)){
                entr.v=v;
                return;
            }
        }
        data[index].add(new Entry(k,v));

    }
    public boolean contains(K k){
        int index = hashFunction(k);
        for (Entry<K,V> entr : data[index]) {
            if(entr.k == k){
                return true;
            }
        }
        return false;
    }
    public String get(K k){
        int index = hashFunction(k);
        for (Entry<K,V> entry : data[index]) {
            if(entry.k.equals(k)){
                return "value is: "+entry.v;
            }
        }
        return "no such value";
    }
    public boolean remove(K k){
        int index = hashFunction(k);
        return data[index].removeIf(entry -> entry.k.equals(k));
    }
    public void print(){
        for (int i = 0; i < data.length; i++) {
            System.out.print(i + " -> ");
                for (int j = 0; j < data[i].size(); j++) {
                    System.out.print("[ " + data[i].get(j).k+ ", " + data[i].get(j).v+ " ] ");
                }
            System.out.println();
        }

        }
    }







