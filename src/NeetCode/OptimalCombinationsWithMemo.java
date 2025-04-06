package NeetCode;

import java.util.*;

public class OptimalCombinationsWithMemo {
    public static void main(String[] args) {
        Map<String, Set<String>> combinationMap = new HashMap<>();
        combinationMap.put("item1", new HashSet<>(Arrays.asList("item2", "item3")));
        combinationMap.put("item8", new HashSet<>(Arrays.asList("item2", "item3", "item5")));
        combinationMap.put("item12", new HashSet<>(Arrays.asList("item10", "item11")));

        List<String> testInput1 = List.of("item1");
        List<String> testInput2 = Arrays.asList("item6", "item2", "item3");
        List<String> testInput3 = Arrays.asList("item9", "item2", "item3", "item5");
        List<String> testInput4 = Arrays.asList("item4", "item10", "item18", "item19", "item11");

        System.out.println("Test case 1: "+testInput1 +" ,result: " + findAllOptimalCombinations(testInput1, combinationMap));
        System.out.println("Test case 2: "+testInput2 +" ,result: " + findAllOptimalCombinations(testInput2, combinationMap));
        System.out.println("Test case 3: "+testInput3 +" ,result: " + findAllOptimalCombinations(testInput3, combinationMap));
        System.out.println("Test case 4: "+testInput4 +" ,result: " + findAllOptimalCombinations(testInput4, combinationMap));
    }

    public static List<List<String>> findAllOptimalCombinations(List<String> input, Map<String, Set<String>> combinationMap) {
        Map<List<String>, List<List<String>>> memo = new HashMap<>();
        return findCombinations(input, combinationMap, new ArrayList<>(), memo);
    }

    private static List<List<String>> findCombinations(List<String> input, Map<String, Set<String>> combinationMap,
                                                       List<String> current, Map<List<String>, List<List<String>>> memo) {
        if (memo.containsKey(input)) {
            return memo.get(input);
        }

        List<List<String>> results = new ArrayList<>();
        if (input.isEmpty()) {
            results.add(new ArrayList<>(current));
        } else {
            for (Map.Entry<String, Set<String>> entry : combinationMap.entrySet()) {
                if (input.containsAll(entry.getValue())) {
                    List<String> remaining = new ArrayList<>(input);
                    remaining.removeAll(entry.getValue());
                    current.add(entry.getKey());
                    results.addAll(findCombinations(remaining, combinationMap, current, memo));
                    current.remove(entry.getKey());
                }
            }
            if (!input.isEmpty()) {
                current.addAll(input);
                results.add(new ArrayList<>(current));
                current.removeAll(input);
            }
        }

        memo.put(input, results);
        return results;
    }
}
