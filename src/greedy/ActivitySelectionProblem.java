package greedy;

import java.util.Arrays;

public class ActivitySelectionProblem {

    public static void main(String[] args) {

        int[][] arr = {{1,2},{3,4},{0,6},{8,9},{5,7},{5,9}};
        System.out.println(maxActivitySelection(arr));
    }

    public static int maxActivitySelection(int[][] arr){

        //we need to choose the maximum intervals to maximize our output

        if (arr == null || arr.length == 0) return 0;

        //sort according to ending
        Arrays.sort(arr,(a,b) -> Integer.compare(a[1],b[1]));
        int count = 1;
        int nextEnding = arr[0][1];
        for (int i = 1; i < arr.length ; i++) {

            if(arr[i][0] >= nextEnding){
                count++;
                nextEnding = arr[i][1];
            }

        }

        return count;
    }
}
