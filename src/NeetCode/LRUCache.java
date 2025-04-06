package NeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> dic;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        dic=new LinkedHashMap(5,.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        return dic.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        dic.put(key,value);
    }
}

/**
 * Your NeetCode.LRUCache object will be instantiated and called as such:
 * NeetCode.LRUCache obj = new NeetCode.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */