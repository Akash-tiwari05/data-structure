package maths.numberTheory;

import java.util.*;

public class MinimumDistanceBetweenThreeEqualElements2 {

    public static void main(String[] args) {

        int[] arr = {1,1,2,3,2,1,2};

        System.out.println(minimumDistance(arr));
    }

    //brute force
    public static int minimumDistance(int[] nums) {

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            map.putIfAbsent(val, new ArrayDeque<>());
            Deque<Integer> dq = map.get(val);

            dq.addLast(i);

            if (dq.size() == 3) {
                int first = dq.peekFirst();
                int last = dq.peekLast();

                min = Math.min(min, 2 * (last - first));

                dq.pollFirst(); // slide window
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
