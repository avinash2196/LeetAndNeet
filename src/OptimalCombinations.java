import java.util.*;

public class OptimalCombinations {
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
        List<List<String>> results = new ArrayList<>();
        findCombinations(input, combinationMap, new ArrayList<>(), results);
        return results;
    }

    private static void findCombinations(List<String> input, Map<String, Set<String>> combinationMap,
                                         List<String> current, List<List<String>> results) {
        if (input.isEmpty()) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (Map.Entry<String, Set<String>> entry : combinationMap.entrySet()) {
            if (input.containsAll(entry.getValue())) {
                List<String> remaining = new ArrayList<>(input);
                remaining.removeAll(entry.getValue());
                current.add(entry.getKey());
                findCombinations(remaining, combinationMap, current, results);
                current.remove(entry.getKey());
            }
        }

        if (!input.isEmpty()) {
            current.addAll(input);
            results.add(new ArrayList<>(current));
            current.removeAll(input);
        }
    }
}
