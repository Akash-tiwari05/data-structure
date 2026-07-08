package graph.sortestpath;

import java.util.ArrayList;
import java.util.List;

public class SnakesAndLadders {

    public static void main(String[] args) {

        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        System.out.println(snakesAndLadders(board));

    }

    public static int snakesAndLadders(int[][] board) {

        int n = board.length;

        int source = 1;
        List<Integer>[] adj = new List[n*n];
        for (int i = 0; i < n*n; i++) {
            adj[i] = new ArrayList<>();
        }

        return 0;
    }
}
