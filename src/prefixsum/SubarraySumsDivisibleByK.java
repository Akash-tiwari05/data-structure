package prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {

        int[] arr= {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(arr,k));
    }

    public static int subarraysDivByK(int[] nums, int k) {

        /*                                    mp = 0,1
        i = 0, n = 4, ps = 4, rem = 4, c = 0  mp = 4,1
        i = 1, n = 5, ps = 9, rem = 4, c = 1, mp = 4,2
        i = 3, n = 0, ps = 9, rem = 4, c = 3, mp = 4,3
        i = 4, n =-2, ps = 7, rem = 2, c = 3, mp = 2,1
        i = 5, n =-3, ps = 4, rem = 4, c = 6, mp = 4,4
        i = 6, n = 1, ps = 5, rem = 0, c = 7, mp = 0,1
         */
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int rem = prefixSum%k;
            if(rem < 0 ){
                rem += k;
            }

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        return count;
    }
}
