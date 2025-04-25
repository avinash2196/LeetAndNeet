package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        int[] firstOccurrence = new int[26];
        //fill it with -1 so that we can find first Occurrence by checking if its populated or not
        Arrays.fill(firstOccurrence, -1);

        int partitionStart = 0, partitionEnd = 0;
        //populate firstOccurrence and lastOccurrence
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            lastOccurrence[index] = i;
            if (firstOccurrence[index] == -1) firstOccurrence[index] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            //If we find a new partition with condition partitionEnd <firstOccurrence
            if (partitionEnd < firstOccurrence[index]) {
                partitions.add(partitionEnd - partitionStart + 1);
                partitionStart = i;
                partitionEnd = i;
            }
            //update partition End boundary
            partitionEnd = Math.max(partitionEnd, lastOccurrence[index]);
        }
        //add last partition if it exists i.e, partitionEnd is not last
        if (partitionEnd - partitionStart + 1 > 0) {
            partitions.add(partitionEnd - partitionStart + 1);
        }
        return partitions;
    }
}
