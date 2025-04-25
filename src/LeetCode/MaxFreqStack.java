package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {
    //Map of element to frequency of element
    Map<Integer, Integer> freqMap;
    //map to hold frequency and elements of frequency as value in stack
    Map<Integer, Stack<Integer>> frequencyStackMap;
    int maxFreq;

    public MaxFreqStack() {
        freqMap = new HashMap<>();
        frequencyStackMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        //find freq to be added
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        //update maxFreq if it's more than freq
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        //Add it on freqStackMap
        frequencyStackMap.computeIfAbsent(freq, z -> new Stack<>()).push(x);
    }

    public int pop() {
        //find element of highest frequency
        int x = frequencyStackMap.get(maxFreq).pop();
        //update freqMap
        freqMap.put(x, freqMap.get(x) - 1);
        //Update max freq in case there is no element in stack for highest freq
        if (frequencyStackMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }
}
