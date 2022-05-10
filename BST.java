package com.company;

public class BST<K extends Comparable<K>, V> {
    public class Node<K, V>{
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    public void put(K key, V value){
        Node iterator = root;
        while(iterator != null){
            System.out.println(iterator.value);
            int cmp = key.compareTo((K) iterator.key);
            if(cmp <= 0)
                iterator = iterator.left;
            else
                iterator = iterator.right;
        }
        iterator = new Node(key, value);
    }
    public V get(K key){
        Node iterator = root;
        while(iterator != null){
            if(iterator.key.equals(key))
                return (V) iterator.value;
            int cmp = key.compareTo((K) iterator.key);
            if(cmp <= 0)
                iterator = iterator.left;
            else
                iterator = iterator.right;
        }
        return null;
    }
    public void delete(K key){
        Node iterator = root;
        Node parent = null;
        while(iterator != null){
            if(iterator.key.equals(key)){
                int cmp = key.compareTo((K) parent.key);
                if(cmp <= 0)
                    parent.left = iterator.left;
                else
                    parent.right = iterator.left;
                iterator = iterator.left;
                Node<K, V> joiningRight = iterator.right;
                while (iterator != null)
                    iterator = iterator.right;
                iterator = joiningRight;
            }
            int cmp = key.compareTo((K) iterator.key);
            if(cmp <= 0)
                iterator = iterator.left;
            else
                iterator = iterator.right;
            parent = iterator;
        }
    }

// void view(boolean isFirst, Node iterator){
//         if(isFirst == true)
//             iterator = root;
//         if(iterator == null) return;
//         System.out.println("Current Node: " + root.key + " Left: " + root.left.key + " Right: " + root.right.value);
//         view(false, iterator.left);
//         view(false, iterator.right);
//     }

}
