package cache;

import java.util.HashMap;

public class LruCache {

    private LinkedNode head;
    private LinkedNode tail;

    private HashMap<Integer, LinkedNode> values;

    private int count;

    private int capacity;


    public LruCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode(1, 1);
        head.pre = null;
        tail = new LinkedNode(1, 1);
        tail.next = null;
        head.next = tail;
        tail.pre = head;

        values = new HashMap<>(capacity);
    }

    public int get(int key) {
        LinkedNode linkedNode  = values.get(key);
        if (linkedNode == null) {
            return -1;
        }
        removeKey(linkedNode);
        setHead(linkedNode);
        return linkedNode.value;
    }

    public void put(int key, int value) {
        LinkedNode v = values.get(key);
        if (v == null) {
            if (count >= capacity) {
                LinkedNode node = removeTail();
                count --;
                values.remove(node.key);
            }
            v = new LinkedNode(key, value);
            setHead(v);
            count++;
            values.put(key, v);
        } else {
            v.value = value;
            removeKey(v);
            setHead(v);
        }
    }

    private void setHead(LinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        return node;
    }

    private void removeKey(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }



    private class LinkedNode {
        private LinkedNode pre;
        private LinkedNode next;

        private int key;
        private int value;

        private LinkedNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));        // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));      // returns -1 (not found)
        System.out.println(cache.get(3));      // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
