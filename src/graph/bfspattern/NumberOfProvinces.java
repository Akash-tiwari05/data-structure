package graph.bfspattern;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public static void main(String[] args) {

        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNum2(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(visited, i, isConnected, n);
                provinces++;
            }
        }
        return provinces;
    }


    //using bfs
    public static void bfs(boolean[] visited, int index,
                           int[][] isConnected, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visited[index] = true;
        while (!q.isEmpty()){

            int curr = q.poll();
            for (int i = 0; i < n ; i++) {
                if(!visited[i] && isConnected[curr][i] ==1){
                    visited[i] = true;
                    q.add(i);
                }

            }
        }

    }

    //using dfs
    public static int findCircleNum2(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int city = 0; city < n; city++) {
            if(!visited[city]){
                dfsProvinces(visited, city, isConnected);
                provinces++;
            }
        }
        return provinces;
    }


    //using bfs
    public static void dfsProvinces(boolean[] visited, int city,
                                    int[][] isConnected){
        visited[city] = true;
        for (int i = 0; i < isConnected.length ; i++) {
            if(!visited[i] && isConnected[city][i] ==1){
                dfsProvinces(visited,i, isConnected);
            }
        }
    }

}

