package graph.topologicalsort;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {

        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }

    public static int[] findOrder(int n, int[][] prerequisites) {

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            adj[prereq].add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] order = new int[n];
        int i = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            order[i++]= curr;

            for(int neighbor: adj[curr]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        return i == n ? order : new int[0];
    }
}
