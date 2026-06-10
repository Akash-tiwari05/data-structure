package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphImplementation {

    static void printGraph(HashMap<Integer, List<Integer>> graph) {

        for (var entry : graph.entrySet()) {
            System.out.println("node: "+entry.getKey() + " -> "
                    +"Neighbors: " +entry.getValue());
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> edgesList = List.of(
                List.of(1, 2),
                List.of(2, 3),
                List.of(3, 4),
                List.of(4, 2),
                List.of(1, 3)
        );

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edgesList.size(); i++) {

            int a = edgesList.get(i).get(0);
            int b = edgesList.get(i).get(1);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a); // undirected graph
        }

        printGraph(graph);
    }
}
