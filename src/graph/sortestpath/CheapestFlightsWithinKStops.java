package graph.sortestpath;

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


        return n;
    }
}
