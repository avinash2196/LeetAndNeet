package NeetCode;

import java.util.*;

public class OptimalCombinationFirst {
    public static void main(String[] args) {
        Map<String, Set<String>> combinationMap = new HashMap<>();
        combinationMap.put("item1", new HashSet<>(Arrays.asList("item2", "item3")));
        combinationMap.put("item8", new HashSet<>(Arrays.asList("item2", "item3", "item5")));
        combinationMap.put("item12", new HashSet<>(Arrays.asList("item10", "item11")));

        List<String> testInput1 = List.of("item1");
        List<String> testInput2 = Arrays.asList("item6", "item2", "item3");
        List<String> testInput3 = Arrays.asList("item9", "item2", "item3", "item5");
        List<String> testInput4 = Arrays.asList("item4", "item10", "item18", "item19", "item11");

        System.out.println("Test case 1: " + findOptimalCombinations(testInput1, combinationMap));
        System.out.println("Test case 2: " + findOptimalCombinations(testInput2, combinationMap));
        System.out.println("Test case 3: " + findOptimalCombinations(testInput3, combinationMap));
        System.out.println("Test case 4: " + findOptimalCombinations(testInput4, combinationMap));
    }

    public static List<String> findOptimalCombinations(List<String> input, Map<String, Set<String>> combinationMap) {
        List<String> result = new ArrayList<>(input);

        for (Map.Entry<String, Set<String>> entry : combinationMap.entrySet()) {
            if (input.containsAll(entry.getValue())) {
                result.add(entry.getKey());
                result.removeAll(entry.getValue());
            }
        }

        return result.isEmpty() ? input : result;
    }
}
