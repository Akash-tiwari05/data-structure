package mergeintervals;

import java.util.Arrays;

public class OverlappingIntervals {

    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        System.out.println(isIntersect(arr));
    }

    static boolean isIntersect(int[][] intervals) {
        // Code Here

        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int current = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0] <= current){
                return true;
            }
            else{
                current = intervals[i][1];
            }
        }
        return false;
    }
}
