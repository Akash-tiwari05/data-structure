package prefixsum;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public static void main(String[] args) {
        int[] arr = {2, -1, 2, 1, -4, 3, 5, -2, 4};
        int k = 7;
        System.out.println(shortestSubarray(arr,k)); //output = 7
    }

    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix= new long[n+1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] +nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {


            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k){
                minLength = Math.min(i - dq.peekFirst(),minLength);
                dq.pollFirst();
            }

            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }

        return minLength == Integer.MAX_VALUE?-1:minLength;
    }
}
