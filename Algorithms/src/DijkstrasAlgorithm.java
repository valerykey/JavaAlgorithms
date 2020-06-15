import java.util.*;

public class DijkstrasAlgorithm {
    static Map<String, Map<String, Integer>> graph = new HashMap<>();
    static List<String> processed = new ArrayList<>();



    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);

        graph.put("fin", new HashMap<>());

        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", -1);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);


    }

}
