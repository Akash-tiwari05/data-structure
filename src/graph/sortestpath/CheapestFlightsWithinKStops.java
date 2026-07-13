package graph.sortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int n = 4;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));

    }


    public static int findCheapestPrice(int n, int[][] flights,
                                        int src, int dst, int k) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight: flights) {

            int fromCity = flight[0];
            int toCity = flight[1];
            int cost = flight[2];

            graph.get(fromCity).add(new Edge(toCity,cost));
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost));

        pq.offer(new State(src,0, 0));
        int[][] dist = new int[k + 2][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][src] = 0;

        while (!pq.isEmpty()){
            State curr = pq.poll();

            int city = curr.city;
            int minCost = curr.cost;
            int stop = curr.stops;

            if (stop > k + 1)
                continue;

            if (curr.cost > dist[curr.stops][curr.city]) {
                continue;
            }

            if(city == dst){
                return minCost;
            }

            for (Edge nbrCity : graph.get(city)){
                int nextCity = nbrCity.to;
                int edgeCost = nbrCity.cost;
                int nextStops = stop+1;

                if (nextStops <= k + 1 &&
                        curr.cost + edgeCost < dist[nextStops][nextCity]) {

                    dist[nextStops][nextCity] = curr.cost + edgeCost;

                    pq.offer(new State(
                            nextCity,
                            dist[nextStops][nextCity],
                            nextStops
                    ));
                }
            }
        }
        
        return -1;
    }
}

class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}


class State {
    int city;
    int cost;
    int stops;

    State(int city, int cost, int stops) {
        this.city = city;
        this.cost = cost;
        this.stops = stops;
    }
}
