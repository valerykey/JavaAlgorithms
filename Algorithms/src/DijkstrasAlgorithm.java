import java.util.*;

public class DijkstrasAlgorithm {
    static Map<String, Map<String, Double>> graph = new HashMap<>();
    static List<String> processed = new ArrayList<>();

    static String find_lowest_cost_node(Map<String, Double> costs){
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        // Go through each node
        for(Map.Entry<String, Double> node : costs.entrySet()){
            Double cost = node.getValue();
            // If it's the lowest cost so far and hasn't been processed yet
            if(cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());

        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = find_lowest_cost_node(costs);
        while (node != null) {
            Double cost = costs.get(node);
            Map<String, Double> neighbours = graph.get(node);
            for(String n: neighbours.keySet()){
                // If it's cheaper to get to this neighbor by going through this node
                Double newCost = cost + neighbours.get(n);
                if(costs.get(n) > newCost) {
                    //update the cost for this node
                    costs.put(n, newCost);
                    // This node becomes the new parent for this neighbor
                    parents.put(n, node);
                }
            }
            // Mark the node as processed
            processed.add(node);
            // Find the next node to process, and loop
            node = find_lowest_cost_node(costs);
        }
        System.out.println("Cost from the start to each node:");
        System.out.println(costs); // { a: 5, b: 2, fin: 6 }
    }

}
