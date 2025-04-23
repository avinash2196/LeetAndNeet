package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> dictionary;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //last contains last accessed
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dictionary = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node) {
        Node previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //remove and add in last
    public int get(int key) {
        if (!dictionary.containsKey(key))
            return -1;
        Node node = dictionary.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    //if capacity exceeds, remove from start
    public void put(int key, int value) {
        if (dictionary.containsKey(key)) {
            Node oldNode = dictionary.get(key);
            remove(oldNode);
        }
        Node node = new Node(key, value);
        dictionary.put(key, node);
        add(node);
        if (dictionary.size() > capacity) {
            Node firstNode = head.next;
            remove(firstNode);
            dictionary.remove(firstNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

