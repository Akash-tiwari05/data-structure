package sorting.introduction;

import java.util.Arrays;
import java.util.HashSet;

public class CheckArithmeticProgression {

    public static void main(String[] args) {
        int[] arr = {0, 12, 4, 8};
        System.out.println(checkIsAP(arr));
        System.out.println(checkIsAP2(arr));
    }

    //naive solution
    public static boolean checkIsAP(int[] arr) {
        // Your code goes here
        int n = arr.length;
        if(n <= 2) return true;
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if(arr[i] - arr[i-1] != d){
                return false;
            }
        }
        return true;
    }

    //optimal solution
    public static boolean checkIsAP2(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if ((max - min) % (n - 1) != 0) return false;

        int d = (max - min) / (n - 1);

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if ((num - min) % d != 0) return false;
            set.add(num);
        }

        return set.size() == n;
    }
}
