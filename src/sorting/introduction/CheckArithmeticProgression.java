package sorting.introduction;

import java.util.Arrays;
import java.util.HashSet;

public class CheckArithmeticProgression {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
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
        for (int ele : arr) {
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        /*System.out.println(min);
        System.out.println(secMin);*/

        int sumOfAp = n*(min + max);
        System.out.println(sumOfAp);

        int sum = 0;
        for (int ele: arr){
            sum += ele;
        }
        return sumOfAp == 2*sum;
    }
}
