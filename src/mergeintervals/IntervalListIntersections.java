package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        //output = [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

        System.out.println(intervalIntersection(firstList,secondList).toString());

        int[][] ans = intervalIntersection(firstList,secondList);

        for(int[] ele: ans){
            System.out.print(Arrays.toString(ele));
        }
    }

    public static int[][] intervalIntersection(int[][] firstList,
                                               int[][] secondList) {

        int m = firstList.length;
        int n = secondList.length;

        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n){

            int star1 = firstList[i][0];
            int end1 = firstList[i][1];
            int star2 = secondList[j][0];
            int end2 = secondList[j][1];

            int start = Math.max(star2,star1);
            int end = Math.min(end1,end2);
            if(start <= end) {
                list.add(new int[]{start, end});
            }
            if(end1 <= end2){
                i++;
            }

            else{
                j++;
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}
