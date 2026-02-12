package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12, 16}};
        int[] newInterval = {2,5};

        int[][] ans = insert(arr,newInterval);

        for(int[] ele: ans){
            System.out.print(Arrays.toString(ele));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);

        while (i <n){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
