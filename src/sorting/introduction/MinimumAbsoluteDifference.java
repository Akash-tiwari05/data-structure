package sorting.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
        System.out.println(minimumAbsDifference2(arr));
    }

    //brute force
    public static List<List<Integer>> minimumAbsDifference2(int[] arr) {

        int n = arr.length;
        // Find true minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                minDiff = Math.min(minDiff, diff);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int absDiff = Math.abs(arr[j] - arr[i]);
                if(absDiff == minDiff){
                    ans.add(List.of(arr[i],arr[j]));
                }
            }
        }
        return ans;
    }

    //optimal solution
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                ans.add(List.of(arr[i-1], arr[i]));
            }
        }
        return ans;
    }

}
