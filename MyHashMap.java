package com.company;

import java.util.*;
import java.lang.*;


class MyHashTable<K, V>{
    class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public HashNode() {

        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int size = 0;
    private int M = 11;

    public MyHashTable(int m) {
        M = m;
        chainArray = new HashNode[M];
    }
    public MyHashTable(){
        chainArray = new HashNode[M];
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value){
        size++;
        int hash = hash(key);
        HashNode<K, V>current = new HashNode<K, V>(key, value);
        if(chainArray[hash] == null)
            chainArray[hash] = current;
        else{
            HashNode<K, V> tmp = chainArray[hash];
            while(tmp.next != null)
                tmp = tmp.next;
            tmp.next = current;
        }

    }

    public V get(K key){
        int hash = hash(key);
        HashNode<K, V> tmp = chainArray[hash];
        while (tmp.key != null && !tmp.key.equals(key))
            tmp = tmp.next;
        if(tmp == null) return null;
        return tmp.value;
    }

    public K getKey(V value){
        for(int i = 0; i < M; i++) {
            HashNode<K, V> tmp = chainArray[i];
            while(tmp != null) {
                if (tmp.value != null && tmp.value.equals(value)) {
                    return tmp.key;
                }
                tmp = tmp.next;
            }
        }
        return null;
    }
    public String remove(K key){
        int hash = hash(key);
        HashNode<K, V> tmp = chainArray[hash];
        if(tmp == null){
            return "No such key in HashMap";
        }
        if(tmp.key.equals(key))
            chainArray[hash] = tmp.next;
        while (tmp.next.key != null && !tmp.next.key.equals(key)){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;

        return "Success";
    }
    public boolean contains(V value){
        if(this.getKey(value) == null) return false;
        return true;
    }


}
