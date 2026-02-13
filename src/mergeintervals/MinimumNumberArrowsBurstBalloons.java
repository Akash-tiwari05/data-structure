package mergeintervals;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {

    public static void main(String[] args) {

        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        System.out.println(findMinArrowShots(points));

    }

    public static int findMinArrowShots(int[][] points) {

        int n = points.length;
        if(n == 0) return 0;

        Arrays.sort(points,(a,b )-> Integer.compare(a[1],b[1]));

        int arrowsPoints = points[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(points[i][0] > arrowsPoints){
                count++;
                arrowsPoints = points[i][1];
            }
        }

        return count;
    }
}
