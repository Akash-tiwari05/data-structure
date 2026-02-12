package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};

        int[][] ans = merge(arr);

        for(int[] ele: ans){
            System.out.print(Arrays.toString(ele));
        }
    }

    public static int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if(n == 1) return intervals;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        list.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] last = list.get(list.size() -1);

            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(intervals[i][1],last[1]);
            }
            else{
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}
