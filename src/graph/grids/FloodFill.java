package graph.grids;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] images = {{1,1,1},{1,1,0},{1,0,1}};

        int sr = 1, sc = 1, color = 2;

        int[][] ans = floodFill(images, sr, sc, color);
        //System.out.println(Arrays.toString(ans));
        for(int[] row: ans){
            System.out.println(Arrays.toString(row));
        }
        int[][] ans2 = floodFill2(images, sr, sc, color);

        // System.out.println(Arrays.toString(ans2));
        for(int[] row: ans2){
            System.out.println(Arrays.toString(row));
        }
    }

    //using bfs
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        int[] dx = {1,0,-1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int srColor = image[sr][sc];
        while (!q.isEmpty()){

            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();
            image[i][j]  = color;

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if(checkConditions(x, y, m ,n) && image[x][y] == srColor){
                    q.offer(new int[]{x,y});
                }
            }

        }
        return image;

    }

    private static boolean checkConditions(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    //using dfs
    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        int[] dx = {1,0,-1, 0};
        int[] dy = {0, 1, 0, -1};

        fill(image, sr, sc, m, n, color, image[sr][sc], dx, dy);

        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int m, int n,
                             int color, int curr, int[] dx, int[] dy){

        if(sr < 0 || sr >= m || sc < 0 || sc >= n) return;

        if(image[sr][sc] != curr) return;

        image[sr][sc] = color;
        for (int i = 0; i < 4; i++){
            fill(image, sr+ dx[i] , sc + dy[i], m, n, color, curr, dx, dy);
        }
    }
}
